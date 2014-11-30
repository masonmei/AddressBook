package org.personal.mason.common.code.gen.project.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.elements.Element;
import org.personal.mason.common.code.gen.module.ModuleStructure;
import org.personal.mason.common.code.gen.project.java.element.JavaSourceDirectoryElement;

import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class JavaJarProjectStructureTest {

    @Test
    public void testGenerateJarProject(){
        String projectName = "TestProject";
        String projectDesc = "This is the desc of Test Project";
        File projectPath = new File("/Volumes/BACKUP/Mac/SCM/Test");
        Set<ModuleStructure> moduleStructures = Collections.emptySet();

        JavaJarProjectStructure structure = new JavaJarProjectStructure(projectName, projectDesc, projectPath, moduleStructures);

        Set<Element> elements = buildJavaJarProjectStructure(structure);
        structure.addSubElement(elements.toArray(new Element[elements.size()]));

        JavaJarProjectGenerator generator = new JavaJarProjectGenerator(structure);
        generator.generate();
    }

    private Set<Element> buildJavaJarProjectStructure(JavaJarProjectStructure structure) {
        Set<Element> elements = new HashSet<>();

        JavaSourceDirectoryElement javaSourceFolderElement = new JavaSourceDirectoryElement("src", structure);

        JavaSourceDirectoryElement mainSourceFolder = new JavaSourceDirectoryElement("main", javaSourceFolderElement);
        JavaSourceDirectoryElement javaSourceFolder = new JavaSourceDirectoryElement("java", mainSourceFolder);
        JavaSourceDirectoryElement resourcesSourceFolder = new JavaSourceDirectoryElement("resources", mainSourceFolder);
        mainSourceFolder.addSubElement(javaSourceFolder);
        mainSourceFolder.addSubElement(resourcesSourceFolder);

        javaSourceFolderElement.addSubElement(mainSourceFolder);

        JavaSourceDirectoryElement testSourceFolder = new JavaSourceDirectoryElement("test", javaSourceFolderElement);
        JavaSourceDirectoryElement testJavaSourceFolder = new JavaSourceDirectoryElement("java", testSourceFolder);
        JavaSourceDirectoryElement testResourcesSourceFolder = new JavaSourceDirectoryElement("resource", testSourceFolder);
        testSourceFolder.addSubElement(testJavaSourceFolder);
        testSourceFolder.addSubElement(testResourcesSourceFolder);

        javaSourceFolderElement.addSubElement(testSourceFolder);


        elements.add(javaSourceFolderElement);

        return elements;
    }
}