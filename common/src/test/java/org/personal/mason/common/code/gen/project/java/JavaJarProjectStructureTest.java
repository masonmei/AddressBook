package org.personal.mason.common.code.gen.project.java;

import org.personal.mason.common.code.gen.elements.Element;
import org.personal.mason.common.code.gen.project.java.element.JavaSourceDirectoryElement;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class JavaJarProjectStructureTest {

//    @Test
    public void testGenerateJarProject(){
        String projectName = "TestProject";
        String projectDesc = "This is the desc of Test Project";
        File projectPath = new File("/Volumes/BACKUP/Mac/SCM/Test");

        JavaProjectStructure structure = new JavaProjectStructure(projectName, projectDesc, projectPath);

        Set<Element> elements = buildJavaJarProjectStructure(structure);
        structure.addSubElement(elements.toArray(new Element[elements.size()]));

        JavaProjectGenerator generator = new JavaProjectGenerator(structure);
        generator.generate();
    }

    private Set<Element> buildJavaJarProjectStructure(JavaProjectStructure structure) {
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