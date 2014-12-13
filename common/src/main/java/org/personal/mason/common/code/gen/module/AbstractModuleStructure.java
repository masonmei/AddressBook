package org.personal.mason.common.code.gen.module;

import org.personal.mason.common.code.gen.common.Structure;
import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractModuleStructure<T> implements ModuleStructure<T> {

    private final String name;
    private final Structure parent;
    private final Set<T> elements;

    public AbstractModuleStructure(String name, Structure parent) {
        Assert.hasLength(name, "Project Name Must has length.");
        Assert.notNull(parent, "Parent Structure must not be null.");
        this.name = name;
        this.parent = parent;

        this.elements = new HashSet<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Structure getParent() {
        return parent;
    }


    @Override
    public File getCurrentDirectory() {
        return Utils.getChildFile(parent.getCurrentDirectory(), name);
    }

    @Override
    public Set<T> getSubElements() {
        return Collections.unmodifiableSet(elements);

    }

    @Override
    public void addSubElement(T... elements) {
        if (elements != null) {
            this.elements.addAll(Arrays.asList(elements));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractModuleStructure)) return false;

        AbstractModuleStructure that = (AbstractModuleStructure) o;

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
