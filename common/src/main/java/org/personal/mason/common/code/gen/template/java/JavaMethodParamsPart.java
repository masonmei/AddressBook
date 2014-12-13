package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaMethodParamsPart extends AbstractJavaFilePart {

    private final JavaCommaSplitPart commaSplitList;

    public JavaMethodParamsPart() {
        this(new JavaCommaSplitPart());
    }

    public JavaMethodParamsPart(JavaCommaSplitPart commaSplitList) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaMethodParamsPart)) return false;

        JavaMethodParamsPart that = (JavaMethodParamsPart) o;

        if (commaSplitList != null ? !commaSplitList.equals(that.commaSplitList) : that.commaSplitList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return commaSplitList != null ? commaSplitList.hashCode() : 0;
    }
}
