package org.personal.mason.common.code.gen.template.java;

import java.util.Collections;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-05.
 */
public class JavaMethodLogicalBuilder {

    public static JavaMethodLogicalBuilder createBuilder() {
        return new JavaMethodLogicalBuilder();
    }

    public JavaMethodLogicalPart build() {
        return new VoidJavaMethodLogicalPart();
    }

    private class VoidJavaMethodLogicalPart extends JavaMethodLogicalPart {

        @Override
        public String build() {
            return "";
        }

        @Override
        public Set<JavaImportPart> getImports() {
            return Collections.emptySet();
        }
    }
}
