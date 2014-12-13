package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaConstructorsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaConstructorPart> {

    private final List<JavaConstructorPart> constructorParts = new ArrayList<JavaConstructorPart>();

    public JavaConstructorsPart() {
        this(new ArrayList<JavaConstructorPart>());
    }

    public JavaConstructorsPart(List<JavaConstructorPart> constructorParts) {
        Assert.notNull(constructorParts, "Java Constructor Part must not be null.");
        addParts(constructorParts.toArray(new JavaConstructorPart[constructorParts.size()]));
    }

    @Override
    public Iterator<JavaConstructorPart> getParts() {
        return constructorParts.iterator();
    }

    @Override
    public void addParts(JavaConstructorPart... parts) {
        if (parts.length <= 0) {
            return;
        }
        for (JavaConstructorPart part : parts) {
            if (!constructorParts.contains(part)) {
                constructorParts.add(part);
            }
        }
    }

    public List<JavaConstructorPart> getConstructorParts() {
        return constructorParts;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> imports = new HashSet<JavaImportPart>();
        for (JavaConstructorPart constructorPart : constructorParts) {
            imports.addAll(constructorPart.getImports());
        }
        return Collections.unmodifiableSet(imports);
    }
}
