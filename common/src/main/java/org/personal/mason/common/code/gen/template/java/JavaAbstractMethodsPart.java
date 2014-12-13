package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaAbstractMethodsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaAbstractMethodPart> {
    private final List<JavaAbstractMethodPart> abstractMethodParts = new ArrayList<JavaAbstractMethodPart>();

    public JavaAbstractMethodsPart() {
        this(new ArrayList<JavaAbstractMethodPart>());
    }

    public JavaAbstractMethodsPart(List<JavaAbstractMethodPart> abstractMethodParts) {
        Assert.notNull(abstractMethodParts, "Java Abstract Methods Part must not be null.");
        addParts(abstractMethodParts.toArray(new JavaAbstractMethodPart[abstractMethodParts.size()]));
    }

    @Override
    public Iterator<JavaAbstractMethodPart> getParts() {
        return abstractMethodParts.iterator();
    }

    @Override
    public void addParts(JavaAbstractMethodPart... parts) {
        if (parts.length <= 0) {
            return;
        }

        for (JavaAbstractMethodPart part : parts) {
            if (!abstractMethodParts.contains(part)) {
                abstractMethodParts.add(part);
            }
        }
    }

    public List<JavaAbstractMethodPart> getAbstractMethodParts() {
        return abstractMethodParts;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> imports = new HashSet<JavaImportPart>();
        for (JavaAbstractMethodPart abstractMethodPart : abstractMethodParts) {
            imports.addAll(abstractMethodPart.getImports());
        }
        return Collections.unmodifiableSet(imports);
    }
}
