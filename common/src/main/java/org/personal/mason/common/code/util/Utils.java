package org.personal.mason.common.code.util;

import java.io.File;
import java.io.IOException;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class Utils {

    public static File toCanonicalFile(File file) {
        try {
            return file.getCanonicalFile();
        } catch (IOException e) {
            return null;
        }
    }

    public static String toCanonicalPath(File file) {
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            return null;
        }
    }

    public static File getChildFile(File file, String childName) {
        String canonicalPath = toCanonicalPath(file);
        if(canonicalPath == null) {
            return null;
        }
        return new File(canonicalPath + File.separator + childName);
    }

    public static void createDirectory(File directory) {
        Assert.notNull(directory, "Directory cannot be null when creating directoryName in it.");
        if(!directory.exists()) {
            directory.mkdirs();
        } else if(directory.isFile()) {
            directory.delete();
            directory.mkdir();
        }
    }
}
