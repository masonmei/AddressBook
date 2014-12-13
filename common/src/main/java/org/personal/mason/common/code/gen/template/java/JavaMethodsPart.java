package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaMethodsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaMethodPart> {

    private final List<JavaMethodPart> methodParts = new ArrayList<JavaMethodPart>();

    public JavaMethodsPart(List<JavaMethodPart> methodParts) {
        Assert.notNull(methodParts, "Java Method Parts must not be null.");
        addParts(methodParts.toArray(new JavaMethodPart[methodParts.size()]));
    }

    public List<JavaMethodPart> getMethodParts() {
        return methodParts;
    }

    @Override
    public Iterator<JavaMethodPart> getParts() {
        return methodParts.iterator();
    }

    @Override
    public void addParts(JavaMethodPart... parts) {
        if (parts.length <= 0) {
            return;
        }
        for (JavaMethodPart part : parts) {
            if (!methodParts.contains(part)) {
                methodParts.add(part);
            }
        }
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> result = new HashSet<JavaImportPart>();
        for (JavaMethodPart methodPart : methodParts) {
            result.addAll(methodPart.getImports());
        }
        return Collections.unmodifiableSet(result);
    }
}
