package org.personal.mason.common.code.gen.module;

import org.personal.mason.common.code.gen.common.Structure;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractMultipleModulesModuleStructure<T> extends AbstractModuleStructure<T> implements MultipleModuleStructure {

    private final Set<ModuleStructure> moduleStructures;

    public AbstractMultipleModulesModuleStructure(String name, Structure parent, Set<ModuleStructure> moduleStructures) {
        super(name, parent);

        if(moduleStructures == null) {
            this.moduleStructures = Collections.emptySet();
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
