package org.personal.mason.common.code.gen.template.java;

/**
 * Created by mason on 2014-12-01.
 */
public class JavaImportPart extends AbstractJavaFilePart {

    private final String className;

    public JavaImportPart(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    @Override
    public String build() {
        return null;
    }
}
