package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.gen.AbstractGenerator;
import org.personal.mason.common.code.gen.common.Structure;
import org.personal.mason.common.code.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractProjectGenerator extends AbstractGenerator {
    private final static Logger logger = LoggerFactory.getLogger(AbstractProjectGenerator.class);

    private static final long MIN_PROJECT_SPACE_IN_MB = 500 * 1024 * 1024;

    private final ProjectStructure structure;

    public AbstractProjectGenerator(ProjectStructure structure) {
        Assert.notNull(structure, "Project Structure Must not be null.");
        Assert.pathExist(structure.getBasePath(), "Project Base Path Must not be null.");

        this.structure = structure;
    }

    protected void buildWorkingDir() {
        try {
            validateBasePath();
            File baseDirectory = structure.getBasePath();
            String name = structure.getName();
            String basePath = baseDirectory.getCanonicalPath();
            basePath += File.separator + name;
            File projectRoot = new File(basePath);
            if (projectRoot.exists()) {
                throw new IllegalStateException("Project root path must be empty.");
            }

            projectRoot.mkdir();
        } catch (IOException e) {
            logger.debug("Cannot resolve the canonical path of {}.", structure.getCurrentDirectory());
            throw new IllegalStateException("Unknown runtime exception occurred while starting generate project.");
        }
    }

    @Override
    protected Structure getStructure() {
        return structure;
    }

    protected void validateBasePath() {
        File projectPathFile = structure.getBasePath();

        if (!projectPathFile.isDirectory()) {
            throw new IllegalStateException("Project must be created in a directory. ");
        }

        if (projectPathFile.isHidden()) {
            throw new IllegalStateException("Project cannot be created in hidden directory.");
        }

        if (!projectPathFile.canWrite()) {
            throw new IllegalStateException("Project must be generated in a writable directory.");
        }

        if (projectPathFile.getUsableSpace() < MIN_PROJECT_SPACE_IN_MB) {
            throw new IllegalStateException("No Enough disk space for generate project, the minimum space required is 500M.");
        }
    }

}
