package org.personal.mason.common.code.gen.project;

import org.personal.mason.common.code.gen.module.Module;
import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractProject implements Project {
    private final Set<Module> modules;

    public AbstractProject(String projectPath) {
        this(Collections.emptySet());
    }

    public AbstractProject(Set<Module> modules) {
        Assert.notNull(modules, "Project modules cannot be null.");
        this.modules = modules;
    }

    @Override
    public Iterator<Module> getModules() {
        return modules.iterator();
    }
}
