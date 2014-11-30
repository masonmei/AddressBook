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


    //    @Override
//    public void generate() {
//            Assert.notNull(moduleStructure, "Module Structure Must not be null.");
//            Assert.hasLength(moduleStructure.getName(), "Project Name Must has length.");
//            Assert.notNull(parentStructure.getPath(), "Project Path Must not be null.");
//            Assert.pathExist(parentStructure.getPath(), "Project Path Must be existed.");
//
//            validateBasePath(projectStructure.getPath());
//            logger.debug("Starting to generate the project with name {} at {}.", projectStructure.getName(), projectStructure.getPath());
//
//            try {
//                String basePath = projectStructure.getPath().getCanonicalPath();
//                basePath += File.pathSeparator + projectStructure.getName();
//                File projectRoot = new File(basePath);
//                if(projectRoot.exists()) {
//                    throw new IllegalStateException("Project root path must be empty.");
//                }
//
//                projectRoot.mkdir();
//            } catch (IOException e) {
//                logger.debug("Cannot resolve the canonical path of {}.", projectStructure.getPath());
//                throw new IllegalStateException("Unknown runtime exception occurred while starting generate project.");
//            }
//
//            Iterator<StructureElement> structureElements = projectStructure.getStructureElements();
//            while (structureElements.hasNext()) {
//                structureElements.next().construct();
//            }
//
//            Iterator<Module> modules = projectStructure.getModuleStructures();
//            while (modules.hasNext()){
//                new ModuleGenerator(modules.next(), projectStructure).generate();
//            }
//    }
}
