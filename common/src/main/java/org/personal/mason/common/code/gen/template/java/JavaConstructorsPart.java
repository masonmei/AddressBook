package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaConstructorsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaConstructorPart> {

    private final List<JavaConstructorPart> constructorParts;

    public JavaConstructorsPart(List<JavaConstructorPart> constructorParts) {
        Assert.notNull(constructorParts, "Java Constructor Part must not be null.");
        this.constructorParts = constructorParts;
    }

    @Override
    public String build() {
        return null;
    }

    @Override
    public Iterator<JavaConstructorPart> getParts() {
        return constructorParts.iterator();
    }

    @Override
    public void addParts(JavaConstructorPart... parts) {
        if(parts != null) {
            Collections.addAll(constructorParts, parts);
        }
    }
}
