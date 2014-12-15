package org.personal.mason.axon;

import org.personal.mason.common.code.gen.Generator;
import org.personal.mason.common.code.gen.project.MultipleModuleProjectStructure;
import org.personal.mason.common.code.gen.project.java.JavaProjectGenerator;
import org.personal.mason.common.code.gen.project.java.JavaProjectStructure;
import org.personal.mason.common.code.gen.project.java.element.JavaPackageElement;
import org.personal.mason.common.code.gen.project.java.element.JavaSourceDirectoryElement;
import org.personal.mason.common.code.util.Assert;

import java.io.File;

/**
 * Created by mason on 12/13/14.
 */
public class ProjectGen {

    private String name;
    private String description;
    private ProjectType type;
    private String baseDirectory;
    private String basePackage;

    private ProjectGen() {
    }

    public static ProjectGen getInstance() {
        return new ProjectGen();
    }

    protected ProjectGen withType(ProjectType type) {
        this.type = type;
        return this;
    }

    protected ProjectGen withName(String name) {
        this.name = name;
        return this;
    }

    protected ProjectGen withDescription(String description) {
        this.description = description;
        return this;
    }

    protected ProjectGen withBaseDirectory(String baseDirectory) {
        this.baseDirectory = baseDirectory;
        return this;
    }

    protected ProjectGen withBasePackage(String basePackage) {
        this.basePackage = basePackage;
        return this;
    }

    protected Generator build() {
        Assert.notNull(this.type, "Project Type must not be null.");
        Assert.notNull(this.name, "Project Name must not be null.");
        Assert.notNull(this.baseDirectory, "Project Base Directory must not be null.");
        Assert.notNull(this.basePackage, "Project Base Package must not be null.");

        switch (this.type) {
            case WAR:
            case JAR:
                return buildJavaProjectGenerator(this.type);
            case POM:
                return buildMultipleModuleProjectGenerator();
            default:
                throw new IllegalStateException("Invalid Project Type with name " + this.type);
        }
    }

    private JavaProjectGenerator buildJavaProjectGenerator(ProjectType projectType) {
        JavaProjectStructure projectStructure = new JavaProjectStructure(this.name, this.description, new File(this.baseDirectory));

        JavaSourceDirectoryElement javaSourceFolderElement = new JavaSourceDirectoryElement("src", projectStructure);

        JavaSourceDirectoryElement mainSourceFolder = new JavaSourceDirectoryElement("main", javaSourceFolderElement);
        JavaSourceDirectoryElement javaSourceFolder = new JavaSourceDirectoryElement("java", mainSourceFolder);
        mainSourceFolder.addSubElement(javaSourceFolder);
        JavaPackageElement javaPackageElement = new JavaPackageElement(this.basePackage, javaSourceFolder);
        javaSourceFolder.addSubElement(javaPackageElement);
        JavaSourceDirectoryElement resourcesSourceFolder = new JavaSourceDirectoryElement("resources", mainSourceFolder);
        mainSourceFolder.addSubElement(resourcesSourceFolder);

        if (projectType == ProjectType.WAR) {
            JavaSourceDirectoryElement webSourceFolder = new JavaSourceDirectoryElement("webapp", mainSourceFolder);
            mainSourceFolder.addSubElement(webSourceFolder);
        }

        JavaSourceDirectoryElement testSourceFolder = new JavaSourceDirectoryElement("test", javaSourceFolderElement);
        JavaSourceDirectoryElement testJavaSourceFolder = new JavaSourceDirectoryElement("java", testSourceFolder);
        testSourceFolder.addSubElement(testJavaSourceFolder);
        JavaPackageElement testPackageElement = new JavaPackageElement(this.basePackage, testJavaSourceFolder);
        testJavaSourceFolder.addSubElement(testPackageElement);
        JavaSourceDirectoryElement testResourcesSourceFolder = new JavaSourceDirectoryElement("resource", testSourceFolder);
        testSourceFolder.addSubElement(testResourcesSourceFolder);

        javaSourceFolderElement.addSubElement(mainSourceFolder);
        javaSourceFolderElement.addSubElement(testSourceFolder);

        projectStructure.addSubElement(javaSourceFolderElement);

        return new JavaProjectGenerator(projectStructure);
    }

    private JavaProjectGenerator buildMultipleModuleProjectGenerator() {
        return new JavaProjectGenerator(new MultipleModuleProjectStructure(this.name, this.description, new File(this.baseDirectory)));
    }
}
