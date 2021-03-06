package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaImportsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaImportPart> {

    private final List<JavaImportPart> importParts;

    public JavaImportsPart() {
        this(new ArrayList<JavaImportPart>());
    }

    public JavaImportsPart(List<JavaImportPart> importParts) {
        Assert.notNull(importParts, "Import Part must not be null.");
        this.importParts = importParts;
    }

    public List<JavaImportPart> getImportParts() {
        return importParts;
    }

    @Override
    public Iterator<JavaImportPart> getParts() {
        return importParts.iterator();
    }

    @Override
    public void addParts(JavaImportPart... parts) {
        if (parts.length <= 0) {
            return;
        }

        for (JavaImportPart part : parts) {
            if (!importParts.contains(part)) {
                importParts.add(part);
            }
        }
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return Collections.emptySet();
    }
}
