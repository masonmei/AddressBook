package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaExtendsPart extends AbstractJavaFilePart {

    private final JavaImportsPart importsPart;
    private final List<Class> classes;

    public JavaExtendsPart() {
        this(new JavaImportsPart(), new ArrayList<Class>());
    }

    public JavaExtendsPart(JavaImportsPart importsPart, List<Class> classes) {
        Assert.notNull(importsPart, "Java Imports Part must not be null.");
        Assert.notNull(classes, "Java Extends Part must not be null.");
        this.importsPart = importsPart;
        this.classes = classes;
    }

    public JavaImportsPart getImportsPart() {
        return importsPart;
    }

    public List<Class> getClasses() {
        return classes;
    }

    @Override
    public String build() {
        return null;
    }
}
