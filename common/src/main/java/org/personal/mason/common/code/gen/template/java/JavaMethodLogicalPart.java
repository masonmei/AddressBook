package org.personal.mason.common.code.gen.template.java;

/**
 * Created by m00290368 on 2014-12-02.
 */
public abstract class JavaMethodLogicalPart extends AbstractJavaFilePart {

    public JavaMethodLogicalPart() {
        super(JavaMethodLogicalPart.class.getName().replaceAll("\\.", "/") + ".tm");
    }
}
