package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaFieldsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaFieldPart> {
    private final List<JavaFieldPart> fieldParts = new ArrayList<JavaFieldPart>();

    public JavaFieldsPart() {
        this(new ArrayList<JavaFieldPart>());
    }

    public JavaFieldsPart(List<JavaFieldPart> fieldParts) {
        Assert.notNull(fieldParts, "Java Field Parts must not be null.");
        addParts(fieldParts.toArray(new JavaFieldPart[fieldParts.size()]));
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> result = new HashSet<JavaImportPart>();
        for (JavaFieldPart fieldPart : fieldParts) {
            result.addAll(fieldPart.getImports());
        }
        return Collections.unmodifiableSet(result);
    }

    public List<JavaFieldPart> getFieldParts() {
        return fieldParts;
    }

    @Override
    public Iterator<JavaFieldPart> getParts() {
        return fieldParts.iterator();
    }

    @Override
    public void addParts(JavaFieldPart... parts) {
        if (parts.length <= 0) {
            return;
        }

        for (JavaFieldPart part : parts) {
            if (!fieldParts.contains(part)) {
                fieldParts.add(part);
            }
        }
    }
}
