package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaImplementsPart extends AbstractJavaFilePart {

    private final JavaCommaSplitPart commaSplitList;

    public JavaImplementsPart() {
        this(new JavaCommaSplitPart());
    }

    public JavaImplementsPart(JavaCommaSplitPart commaSplitList) {
        Assert.notNull(commaSplitList, "Java Comma Split List Part must not be null.");
        this.commaSplitList = commaSplitList;
    }

    public JavaCommaSplitPart getCommaSplitList() {
        return commaSplitList;
    }

    @Override
    public String build() {
        if (!commaSplitList.hasEntry()) {
            return "";
        }
        return super.build();
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return commaSplitList.getImports();
    }
}
