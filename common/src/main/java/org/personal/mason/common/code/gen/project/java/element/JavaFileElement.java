package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.gen.elements.FileElement;

/**
 * Created by mason on 11/30/14.
 */
public abstract class JavaFileElement extends FileElement implements JavaElement {


    public JavaFileElement(String name, JavaSourceDirectoryElement parent) {
        super(name, parent);
    }
}
