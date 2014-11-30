package org.personal.mason.common.code.gen.elements;

import org.personal.mason.common.code.util.Assert;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class AbstractElement implements Element {
    private final String name;
    private final Containable parent;

    public AbstractElement(String name, Containable parent) {
        Assert.notNull(parent, "Parent Containable must not be null.");
        Assert.hasLength(name, "Element name must have length.");
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    @Override
    public Containable getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractElement)) return false;

        AbstractElement that = (AbstractElement) o;

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

    @Override
    public String toString() {
        return "AbstractStructureElement{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
