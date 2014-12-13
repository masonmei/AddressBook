package org.personal.mason.common.code.gen.template.java;

import java.util.Collections;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-08.
 */
public class JavaInitialPart extends AbstractJavaFilePart {

    private final String initialContent;

    public JavaInitialPart() {
        this(null);
    }

    public JavaInitialPart(String initialContent) {
        this.initialContent = initialContent;
    }

    @Override
    public String build() {
        if(initialContent == null || initialContent.trim().isEmpty()){
            return "";
        }

        return super.build();
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return Collections.emptySet();
    }
}
