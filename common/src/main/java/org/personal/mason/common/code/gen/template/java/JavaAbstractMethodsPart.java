package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaAbstractMethodsPart extends AbstractJavaFilePart implements JavaMultiplePart<JavaAbstractMethodPart>{
    private final List<JavaAbstractMethodPart> abstractMethodParts;

    public JavaAbstractMethodsPart() {
        this(new ArrayList<JavaAbstractMethodPart>());
    }

    public JavaAbstractMethodsPart(List<JavaAbstractMethodPart> abstractMethodParts) {
        Assert.notNull(abstractMethodParts, "Java Abstract Methods Part must not be null.");
        this.abstractMethodParts = abstractMethodParts;
    }

    @Override
    public String build() {
        return null;
    }

    @Override
    public Iterator<JavaAbstractMethodPart> getParts() {
        return abstractMethodParts.iterator();
    }

    @Override
    public void addParts(JavaAbstractMethodPart... parts) {
        if(parts != null) {
            Collections.addAll(abstractMethodParts, parts);
        }
    }

    @Override
    public Set<String> getImports() {
        Set<String> imports = new HashSet<String>();
        for (JavaAbstractMethodPart abstractMethodPart : abstractMethodParts) {
            imports.addAll(abstractMethodPart.getImports());
        }
        return Collections.unmodifiableSet(imports);
    }
}
