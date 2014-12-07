package org.personal.mason.common.code.gen.template.java;

import org.apache.commons.io.IOUtils;
import org.personal.mason.common.code.gen.template.Template;
import org.personal.mason.common.code.util.ReflectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJava implements Template {

    private final String template;
    private final StringBuilder contentBuilder;

    public AbstractJava() {
        this(null);
    }

    public AbstractJava(String templateFileName) {
        if (templateFileName == null) {
            this.template = resolveTemplate(getPathString());
        } else {
            this.template = resolveTemplate(templateFileName);
        }
        this.contentBuilder = new StringBuilder(this.template);
    }

    @Override
    public String getTemplate() {
        return template;
    }

    @Override
    public String resolveTemplate(String templatePath) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(templatePath)) {
            return IOUtils.toString(inputStream, "UTF-8");
        } catch (IOException e) {
            throw new IllegalStateException("Cannot find template with in current package.");
        }
    }

    protected String getPathString() {
        return getClass().getName().replaceAll("\\.", "/") + ".tm";
    }

    protected void processFields() {
        Iterable<Field> declaredFields = ReflectionUtils.fieldsOf(getClass());
        for (Field field : declaredFields) {
            Object fieldValue = ReflectionUtils.getFieldValue(field, this);
//            contentBuilder.
        }
    }
}

