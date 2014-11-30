package org.personal.mason.common.code.gen.module;

import java.util.Iterator;

/**
 *
 * Any Project that is multiple modules project must implemented this interface.
 *
 * Created by mason on 11/30/14.
 */
public interface MultipleModuleStructure {

    /**
     * Get all the module structures of the project.
     *
     * @return
     */
    public Iterator<ModuleStructure> getModuleStructures();

    /**
     *
     * Add sub-module structure to project.
     *
     * @param moduleStructure
     */
    public void addModuleStructure(ModuleStructure moduleStructure);

    /**
     *
     * Remove sub-module structure to project.
     *
     * @param moduleStructure
     */
    public void removeModuleStructure(ModuleStructure moduleStructure);
}
