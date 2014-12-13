package org.personal.mason.common.code.gen.template.java;

import org.apache.commons.io.IOUtils;
import org.personal.mason.common.code.gen.template.Template;
import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.ReflectionUtils;
import org.personal.mason.common.code.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJava implements Template {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJava.class);

    private final String template;
    protected final StringBuilder templateBuilder;

    public AbstractJava() {
        this(null);
    }

    public AbstractJava(String templateFileName) {
        if (templateFileName == null) {
            this.template = resolveTemplate(getPathString());
        } else {
            this.template = resolveTemplate(templateFileName);
        }
        this.templateBuilder = new StringBuilder(this.template);
    }

    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    public String resolveTemplate(String templatePath) {
        LOGGER.info("Start to resolve template with name {}", templatePath);
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(templatePath)) {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            throw new IllegalStateException(String.format("Cannot find template with name %s within current package.", templatePath));
        }
    }

    protected String getPathString() {
        return getClass().getName().replaceAll("\\.", "/") + ".tm";
    }

    protected void processFields() {
        Iterable<Field> declaredFields = ReflectionUtils.fieldsOf(getClass());

        for (Field field : declaredFields) {
            if (Modifier.isStatic(field.getModifiers())) {
                continue;
            }

            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                type = ReflectionUtils.resolvePrimitiveWrapperType(type);
            }

            if (type.isEnum()) {
                Object fieldValue = ReflectionUtils.getFieldValue(field, this);
                Assert.notNull(fieldValue, "Enum value must not be null.");
                String value = fieldValue.toString();
                if ("DEFAULT".equalsIgnoreCase(value)) {
                    value = "";
                } else {
                    value = value.toLowerCase();
                }

                replaceProperty(field.getName(), value);
                continue;
            }

            if (AbstractJavaFilePart.class.isAssignableFrom(type)) {
                AbstractJavaFilePart javaFilePart = (AbstractJavaFilePart) ReflectionUtils.getFieldValue(field, this);
                String value = javaFilePart.build();
                replaceJavaFilePartProperty(type.getSimpleName(), value);
                continue;
            }

            if (ReflectionUtils.isInPrimitiveWrapperType(type)) {
                Object fieldValue = ReflectionUtils.getFieldValue(field, this);
                String value;
                if (null == fieldValue) {
                    value = "";
                } else {
                    value = fieldValue.toString();
                }
                replaceProperty(field.getName(), value);
                continue;
            }

            if (Serializable.class.isAssignableFrom(type)) {
                Object fieldValue = ReflectionUtils.getFieldValue(field, this);
                String value;
                if (null == fieldValue) {
                    value = "";
                } else {
                    value = fieldValue.toString();
                }

                if (field.getType() == String.class) {
                    value = StringUtils.getClassName(value);
                }

                replaceProperty(field.getName(), value);
                continue;
            }
        }


    }

    protected boolean handleMultiplePart() {
        if (JavaMultiplePart.class.isAssignableFrom(getClass())) {
            JavaMultiplePart multiplePart = (JavaMultiplePart) this;
            Assert.notNull(multiplePart, "Java Multiple Part must not be null.");
            Iterator<AbstractJavaFilePart> parts = multiplePart.getParts();
            StringBuilder builder = new StringBuilder();
            String elementTypeName = null;

            while (parts.hasNext()) {
                AbstractJavaFilePart next = parts.next();
                if (elementTypeName == null) {
                    elementTypeName = next.getClass().getSimpleName();
                }
                builder.append(next.build());
            }

            if (elementTypeName == null) {
                elementTypeName = "[^#]+";
            }

            replaceMultipleJavaFilePartProperty(elementTypeName, builder.toString());
            return true;
        }
        return false;
    }


    protected void replaceProperty(String fieldName, String value) {
        String keyword = String.format("##%s", fieldName);
        replace(value, keyword);
    }

    protected void replaceJavaFilePartProperty(String typeName, String replacement) {
        String keyword = String.format("#%s#", typeName);
        replace(replacement, keyword);
    }

    protected void replaceMultipleJavaFilePartProperty(String typeName, String replacement) {
        String keyword = "##Each##" + System.lineSeparator() + "#" + typeName + "#" + System.lineSeparator() + "##Each##";
        replace(replacement, keyword);
    }

    /**
     * Replace all the keyword in the templateBuilder with replacement.
     *
     * @param replacement
     * @param keyword
     */
    private void replace(String replacement, String keyword) {
        int keywordStartIndex;
        if (replacement == null) {
            replacement = "";
        }
        while ((keywordStartIndex = templateBuilder.indexOf(keyword)) >= 0) {
            int keywordEndIndex = keywordStartIndex + keyword.length();
            if (keywordEndIndex <= keywordStartIndex) {
                break;
            }
            templateBuilder.replace(keywordStartIndex, keywordEndIndex, replacement);
        }
    }
}

