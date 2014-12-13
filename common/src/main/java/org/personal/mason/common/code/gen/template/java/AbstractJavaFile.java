package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Reformatter;

import java.util.Set;

/**
 * Created by mason on 2014-12-01.
 */
public abstract class AbstractJavaFile extends AbstractJava implements JavaFile {

    public AbstractJavaFile() {
        this(null);
    }

    public AbstractJavaFile(String templateFileName) {
        super(templateFileName);
    }

    @Override
    public String build() {
        collectImports();

        processFields();

        return Reformatter.fixup(templateBuilder.toString());
    }

    protected abstract void collectImports();

    protected abstract JavaImportsPart getImportsPart();

    protected void collectJavaFilePartImports(Set<JavaImportPart> imports) {
        if (imports.size() > 0) {
            getImportsPart().addParts(imports.toArray(new JavaImportPart[imports.size()]));
        }
    }

}

