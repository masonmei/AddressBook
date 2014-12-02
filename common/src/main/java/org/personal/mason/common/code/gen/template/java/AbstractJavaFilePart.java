package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJavaFilePart extends AbstractJava implements JavaFilePart {

    private final List<JavaFilePart> javaFileParts;

    public AbstractJavaFilePart() {
        this(new ArrayList<JavaFilePart>(), null);
    }

    public AbstractJavaFilePart(List<JavaFilePart> javaFileParts, String templateFileName) {
        super(templateFileName);
        Assert.notNull(javaFileParts, "Java File Parts must not be null.");
        this.javaFileParts = javaFileParts;
    }

}