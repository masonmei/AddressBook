package org.personal.mason.common.code.gen.project.java;

import org.personal.mason.common.code.gen.module.ModuleStructure;

import java.io.File;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public class JavaWebProjectStructure extends AbstractJavaProjectStructure {

    public JavaWebProjectStructure(String name, String description, File path, Set<ModuleStructure> moduleStructures) {
        super(name, description, path, moduleStructures);
    }
}
