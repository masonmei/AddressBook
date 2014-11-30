package org.personal.mason.common.code.gen.elements;

import org.personal.mason.common.code.gen.StructureMetaData;
import org.personal.mason.common.code.gen.Template;

/**
 * Created by m00290368 on 2014-11-27.
 */
public abstract class FileElement extends AbstractElement implements File {

    public FileElement(String name, Containable parent) {
        super(name, parent);
    }

    @Override
    public void construct() {
        //TODO:
    }

    public abstract Template getTemplate();

    public abstract StructureMetaData getMetaData();

}
