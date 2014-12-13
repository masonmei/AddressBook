package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.ReflectionUtils;
import org.personal.mason.common.code.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Set;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaImportPart extends AbstractJavaFilePart {

    private final String className;

    public JavaImportPart(String className) {
        Assert.hasLength(StringUtils.getClassName(className), "Must be an validate class name.");
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String build() {
        Iterable<Field> declaredFields = ReflectionUtils.fieldsOf(getClass());
        for (Field field : declaredFields) {
            Object fieldValue = ReflectionUtils.getFieldValue(field, this);
            String value;
            if (null == fieldValue) {
                value = "";
            } else {
                value = fieldValue.toString();
            }

            replaceProperty(field.getName(), value);
        }
        return templateBuilder.toString();
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return Collections.emptySet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaImportPart)) return false;

        JavaImportPart that = (JavaImportPart) o;

        if (className != null ? !className.equals(that.className) : that.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return className != null ? className.hashCode() : 0;
    }
}
