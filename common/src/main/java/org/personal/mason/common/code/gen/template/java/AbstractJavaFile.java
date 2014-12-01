package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJavaFile extends AbstractJava implements JavaFile {

    private final List<JavaFilePart> javaFileParts;

    public AbstractJavaFile() {
        this(new ArrayList<JavaFilePart>(), null);
    }

    public AbstractJavaFile(List<JavaFilePart> javaFileParts, String templateFileName) {
        super(templateFileName);
        Assert.notNull(javaFileParts, "Java File Parts must not be null.");
        this.javaFileParts = javaFileParts;
    }

    @Override
    public List<JavaFilePart> getFileParts() {
        return Collections.unmodifiableList(javaFileParts);
    }

    @Override
    public void addFilePart(JavaFilePart... filePartTemplate) {
        if (filePartTemplate != null) {
            javaFileParts.addAll(Arrays.asList(filePartTemplate));
        }
    }

}

