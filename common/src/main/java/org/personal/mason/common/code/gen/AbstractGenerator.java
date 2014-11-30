package org.personal.mason.common.code.gen;

import org.personal.mason.common.code.gen.common.Structure;
import org.personal.mason.common.code.gen.elements.Element;
import org.personal.mason.common.code.gen.module.ModuleGenerator;
import org.personal.mason.common.code.gen.module.ModuleStructure;
import org.personal.mason.common.code.gen.module.MultipleModuleStructure;
import org.personal.mason.common.code.util.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractGenerator implements Generator {
    private final static Logger logger = LoggerFactory.getLogger(AbstractGenerator.class);

    @Override
    public void generate() {
        Structure structure = getStructure();
        Assert.notNull(structure, "The Structure Must not be null.");
        Assert.hasLength(structure.getName(), "Project/Module Name Must has length.");

        logger.debug("Starting to generate the code with project/module name {} at {}.", structure.getName(), structure.getCurrentDirectory());

        buildWorkingDir();

        Iterator<Element> structureElements = structure.getSubElements().iterator();
        while (structureElements.hasNext()) {

            Element next = structureElements.next();
            next.construct();
        }

        if(structure instanceof MultipleModuleStructure){
            MultipleModuleStructure multipleModuleStructure = (MultipleModuleStructure) structure;
            Iterator<ModuleStructure> modules = multipleModuleStructure.getModuleStructures();
            while (modules.hasNext()) {
                new ModuleGenerator(modules.next(), structure).generate();
            }
        }
        logger.debug("Finished to generate the project/module with name {} at {}.", structure.getName(), structure.getCurrentDirectory());
    }

    // To be Implemented by the subclass
    protected abstract void buildWorkingDir();

    protected abstract Structure getStructure();
}
