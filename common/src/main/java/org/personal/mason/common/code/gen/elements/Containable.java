package org.personal.mason.common.code.gen.elements;

import java.io.File;
import java.util.Set;

/**
 * Created by mason on 11/30/14.
 */
public interface Containable<T> {


    /**
     * Get the Current Directory in file system.
     *
     * @return
     */
    File getCurrentDirectory();

    /**
     * Get all the Sub Elements in this Folder.
     *
     * @return
     */
    Set<T> getSubElements();

    /**
     * Add Sub Elements to this.
     *
     * @param elements
     */
    void addSubElement(T... elements);
}
