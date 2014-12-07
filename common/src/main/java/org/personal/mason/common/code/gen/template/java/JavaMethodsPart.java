package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaMethodsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaMethodPart> {

    private final List<JavaMethodPart> methodParts;

    public JavaMethodsPart(List<JavaMethodPart> methodParts) {
        Assert.notNull(methodParts, "Java Method Parts must not be null.");
        this.methodParts = methodParts;
    }

    @Override
    public String build() {
        return null;
    }

    @Override
    public Iterator<JavaMethodPart> getParts() {
        return methodParts.iterator();
    }

    @Override
    public void addParts(JavaMethodPart... parts) {
        if(parts != null) {
            Collections.addAll(methodParts, parts);
        }
    }
}
