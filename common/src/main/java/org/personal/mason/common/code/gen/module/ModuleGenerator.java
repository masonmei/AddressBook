package org.personal.mason.common.code.gen.module;

import org.personal.mason.common.code.gen.AbstractGenerator;
import org.personal.mason.common.code.gen.common.Structure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by m00290368 on 2014-11-27.
 */
public class ModuleGenerator extends AbstractGenerator {
    private final static Logger logger = LoggerFactory.getLogger(ModuleGenerator.class);

    private final ModuleStructure structure;
    private final Structure parentStructure;

    public ModuleGenerator(ModuleStructure structure, Structure parentStructure) {
        this.structure = structure;
        this.parentStructure = parentStructure;
    }

    @Override
    protected void buildWorkingDir() {
        try {
            File parentDirectory = parentStructure.getCurrentDirectory();
            String name = structure.getName();
            String basePath = parentDirectory.getCanonicalPath();
            basePath += File.pathSeparator + name;
            File currentWorkingDir = new File(basePath);

            if (currentWorkingDir.exists()) {
                throw new IllegalStateException("Module root path must be empty.");
            }

            currentWorkingDir.mkdir();
        } catch (IOException e) {
            logger.debug("Cannot resolve the canonical path of {}.", structure.getCurrentDirectory());
            throw new IllegalStateException("Unknown runtime exception occurred while starting generate project.");
        }
    }

    @Override
    protected Structure getStructure() {
        return structure;
    }

}
