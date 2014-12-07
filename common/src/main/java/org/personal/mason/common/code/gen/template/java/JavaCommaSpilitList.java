package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaCommaSpilitList extends AbstractJavaFilePart {

    private final List<String> classes;

    public JavaCommaSpilitList(List<String> classes) {
        Assert.notNull(classes, "Java Comma Spilit List must not be null.");
        this.classes = classes;
    }

    @Override
    public String build() {
        return null;
    }

    @Override
    public Set<String> getImports() {
        return null;
    }
}
