package org.personal.mason.common.code.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m00290368 on 2014-12-08.
 */
public abstract class StringUtils {

    public static <T> String join(String sign, List<T> src) {
        StringBuilder builder = new StringBuilder();
        if (src != null) {
            for (T string : src) {
                builder.append(string).append(sign);
            }

            if (builder.lastIndexOf(sign) > 0) {
                builder.delete(builder.lastIndexOf(sign), builder.length());
            }
        }
        return builder.toString();
    }

    public static String lastSection(String src, String splitter) {
        if (src == null) {
            return "";
        }
        String[] strings = src.split(splitter);
        if (strings.length > 0) {
            return strings[strings.length - 1];
        }
        return "";
    }

    public static boolean isClassName(String src) {
        if (null == src || src.isEmpty()) {
            return false;
        }

        return Character.isUpperCase(src.charAt(0));
    }

    public static String getClassName(String src) {
        if (isImportClass(src)) {
            return lastSection(src, "\\.");
        }
        return src;
    }

    public static boolean isImportClass(String src) {
        return isClassName(lastSection(src, "\\."));
    }

    public static <T> String commaJoin(List<T> classes) {
        return join(", ", classes);
    }

    public static List<String> getLastSectionList(List<String> src) {
        Assert.notNull(src);
        List<String> result = new ArrayList<String>(src.size());
        for (String string : src) {
            result.add(lastSection(string, "\\."));
        }
        return result;
    }
}
