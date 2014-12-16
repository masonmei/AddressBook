package org.personal.mason.axon;

/**
 * Created by m00290368 on 2014-12-16.
 */
public interface Project {

    String getFolder(SourceFolderType type);

    Project withType(ProjectType type);

    Project withName(String name);

    Project withDescription(String description);

    Project withBaseDirectory(String baseDirectory);

    Project withBasePackage(String basePackage);
}
