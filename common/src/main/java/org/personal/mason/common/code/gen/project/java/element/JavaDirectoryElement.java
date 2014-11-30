package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.gen.elements.Containable;
import org.personal.mason.common.code.gen.elements.DirectoryElement;

/**
 * Created by mason on 11/30/14.
 */
abstract class JavaDirectoryElement<E extends JavaElement> extends DirectoryElement<E> implements JavaElement {

    public JavaDirectoryElement(String name, Containable parent) {
        super(name, parent);
    }
}
