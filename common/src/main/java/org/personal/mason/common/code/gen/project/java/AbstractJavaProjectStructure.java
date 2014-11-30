package org.personal.mason.common.code.gen.project.java;

import org.personal.mason.common.code.gen.module.ModuleStructure;
import org.personal.mason.common.code.gen.project.AbstractMultipleModuleProjectStructure;

import java.io.File;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractJavaProjectStructure extends AbstractMultipleModuleProjectStructure {

    public AbstractJavaProjectStructure(String name, String description, File path, Set<ModuleStructure> moduleStructures) {
        super(name, description, path, moduleStructures);
    }
}
