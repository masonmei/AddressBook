package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.gen.module.ModuleStructure;
import org.personal.mason.common.code.gen.module.MultipleModuleStructure;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractMultipleModuleProjectStructure<T> extends AbstractProjectStructure<T> implements MultipleModuleStructure {

    private final Set<ModuleStructure> moduleStructures;

    public AbstractMultipleModuleProjectStructure(String name, String description, File path, Set<ModuleStructure> moduleStructures) {
        super(name, description, path);
        if(moduleStructures == null)
        {
            this.moduleStructures = new HashSet<>();
        } else {
            this.moduleStructures = moduleStructures;
        }
    }

    @Override
    public Iterator<ModuleStructure> getModuleStructures() {
        return moduleStructures.iterator();
    }

    @Override
    public void addModuleStructure(ModuleStructure moduleStructure) {
        moduleStructures.add(moduleStructure);
    }

    @Override
    public void removeModuleStructure(ModuleStructure moduleStructure) {
        moduleStructures.remove(moduleStructure);
    }

}
