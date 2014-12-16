package org.personal.mason.axon;

import java.io.File;

/**
 * Created by m00290368 on 2014-12-16.
 */
public enum SourceFolderType {
    JAVA_SOURCE("main" + File.separator + "java"),
    JAVA_RESOURCES("main" + File.separator + "resources"),
    TEST_SOURCE("test" + File.separator + "java"),
    TEST_RESOURCE("test" + File.separator + "resources"),
    WEBAPP("webapp");

    private final String folderName;

    private SourceFolderType(String folderName) {
        this.folderName = folderName;
    }

    public String getFolderName() {
        return folderName;
    }

}
