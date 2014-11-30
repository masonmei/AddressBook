package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.gen.StructureMetaData;
import org.personal.mason.common.code.gen.Template;

/**
 * Created by m00290368 on 2014-11-27.
 */
public class JavaPropertiesFileElement extends JavaFileElement {


    public JavaPropertiesFileElement(String name, JavaSourceDirectoryElement parent) {
        super(name, parent);
    }

    @Override
    public Template getTemplate() {
        return null;
    }

    @Override
    public StructureMetaData getMetaData() {
        return null;
    }
}
