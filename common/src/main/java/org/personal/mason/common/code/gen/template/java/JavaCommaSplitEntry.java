package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.StringUtils;

/**
 * Created by m00290368 on 2014-12-12.
 */
public class JavaCommaSplitEntry {

    private final String className;
    private final String name;

    public JavaCommaSplitEntry(String className) {
        this(className, null);
    }

    public JavaCommaSplitEntry(String className, String name) {
        Assert.hasLength(StringUtils.getClassName(className), "The class name must be a validate value.");
        this.className = className;
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaCommaSplitEntry)) return false;

        JavaCommaSplitEntry that = (JavaCommaSplitEntry) o;

        if (name != null) {
            if (that.name != null) {
                return name.equals(that.name);
            } else {
                return false;
            }
        } else {
            return className.equals(that.className);
        }
    }

    @Override
    public int hashCode() {
        int result = className != null ? className.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(StringUtils.getClassName(className));
        if (name != null) {
            builder.append(" ");
            builder.append(name);
        }
        return builder.toString();
    }
}
