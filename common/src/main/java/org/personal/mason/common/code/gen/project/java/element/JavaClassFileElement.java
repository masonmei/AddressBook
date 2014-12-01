package org.personal.mason.common.code.gen.project.java.element;

import org.personal.mason.common.code.gen.MetaData;
import org.personal.mason.common.code.gen.Template;

/**
 * Created by m00290368 on 2014-11-27.
 */
public class JavaClassFileElement extends JavaFileElement {

    public JavaClassFileElement(String name, JavaPackageElement parent) {
        super(name, parent);
    }

    @Override
    public Template getTemplate() {
        return null;
    }

    @Override
    public MetaData getMetaData() {
        return null;
    }
}
