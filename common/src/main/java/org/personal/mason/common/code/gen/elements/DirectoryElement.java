package org.personal.mason.common.code.gen.elements;

import org.personal.mason.common.code.util.Utils;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class DirectoryElement<E extends Element> extends AbstractElement implements Directory<E> {

    private Set<E> subElements = new HashSet<>();

    public DirectoryElement(String name, Containable parent) {
        super(name, parent);
    }

    @Override
    public void construct() {
        Utils.createDirectory(getCurrentDirectory());
        for (Element element : subElements) {
            element.construct();
        }
    }

    @Override
    public Set<E> getSubElements() {
        return Collections.unmodifiableSet(subElements);
    }


    @Override
    public File getCurrentDirectory() {
        Containable parent = getParent();
        File parentDir = parent.getCurrentDirectory();
        return Utils.getChildFile(parentDir, getName());
    }

    @Override
    public void addSubElement(E... elements) {
        if (elements != null) {
            subElements.addAll(Arrays.asList(elements));
        }

    }

}
