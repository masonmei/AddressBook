package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.gen.elements.Containable;

/**
 * Created by mason on 11/30/14.
 */
public class JavaSourceDirectoryElement extends JavaDirectoryElement<JavaElement> implements JavaElement {

    public JavaSourceDirectoryElement(String name, Containable parent) {
        super(name, parent);
    }
}
