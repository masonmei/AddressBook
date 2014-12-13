package org.personal.mason.common.code.gen.template.java;

import java.util.Collections;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-05.
 */
public class JavaPackagePart extends AbstractJavaFilePart {

    private final String packageName;

    public JavaPackagePart(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageName() {
        return packageName;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return Collections.emptySet();
    }
}
