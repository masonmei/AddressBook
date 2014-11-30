package org.personal.mason.common.code.gen.module;

import org.personal.mason.common.code.gen.project.Project;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractModule implements Module {

    private final String name;
    private final Set<Module> modules;
    private final Project parent;

    public AbstractModule(String name, Project parent) {
        this(name, Collections.emptySet(), parent);
    }

    public AbstractModule(String name, Set<Module> modules, Project parent) {
        Assert.hasText(name, "Module Name must have length.");
        Assert.notNull(parent, "Module Parent must not be null.");
        Assert.notNull(modules, "Module sub modules must not be null.");
        this.name = name;
        this.modules = modules;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Iterator<Module> getModules() {
        return modules.iterator();
    }

    @Override
    public Project getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return "AbstractModule{" +
                "name='" + name + '\'' +
                ", modules=" + modules +
                ", parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractModule)) return false;

        AbstractModule that = (AbstractModule) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (parent != null ? !parent.equals(that.parent) : that.parent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
