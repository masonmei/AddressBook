package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;

import java.util.Collections;
import java.util.Set;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaEnumElementsPart extends AbstractJavaFilePart {

    private final JavaCommaSplitPart commaSplitList;

    public JavaEnumElementsPart() {
        this(new JavaCommaSplitPart());
    }

    public JavaEnumElementsPart(JavaCommaSplitPart commaSplitList) {
        Assert.notNull(commaSplitList, "Java Comma Split List Part must not be null.");
        this.commaSplitList = commaSplitList;
    }

    public JavaCommaSplitPart getCommaSplitList() {
        return commaSplitList;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        return Collections.unmodifiableSet(commaSplitList.getImports());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaEnumElementsPart)) return false;

        JavaEnumElementsPart that = (JavaEnumElementsPart) o;

        if (commaSplitList != null ? !commaSplitList.equals(that.commaSplitList) : that.commaSplitList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return commaSplitList != null ? commaSplitList.hashCode() : 0;
    }
}
