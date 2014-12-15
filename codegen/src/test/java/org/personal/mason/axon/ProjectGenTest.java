package org.personal.mason.axon;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class ProjectGenTest {


    @Before
    public void setUp() throws Exception {
        File file = new File("/Volumes/BACKUP/Mac/SCM/AddressBook/codegen/target/TestProject");
        FileUtils.deleteDirectory(file);
    }

    @Test
    public void testBuild() throws Exception {
        ProjectGen.getInstance().withName("TestProject")
                .withDescription("Test Project")
                .withBasePackage("org.personal.mason")
                .withBaseDirectory("/Volumes/BACKUP/Mac/SCM/AddressBook/codegen/target")
                .withType(ProjectType.JAR)
                .build().generate();
    }
}