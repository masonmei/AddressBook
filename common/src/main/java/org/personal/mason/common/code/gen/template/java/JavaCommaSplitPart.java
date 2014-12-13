package org.personal.mason.common.code.gen.template.java;

import org.personal.mason.common.code.util.Assert;
import org.personal.mason.common.code.util.StringUtils;
import org.personal.mason.common.code.util.Utils;

import java.util.*;

/**
 * Created by m00290368 on 2014-12-02.
 */
public class JavaCommaSplitPart extends AbstractJavaFilePart {

    private final List<JavaCommaSplitEntry> entries = new ArrayList<JavaCommaSplitEntry>();

    public JavaCommaSplitPart() {
        this(new ArrayList<JavaCommaSplitEntry>());
    }

    public JavaCommaSplitPart(List<JavaCommaSplitEntry> entries) {
        Assert.notNull(entries, "Java Comma Split Part must not be null.");
        addEntries(entries.toArray(new JavaCommaSplitEntry[entries.size()]));
    }

    @Override
    public String build() {
        return StringUtils.commaJoin(entries);
    }

    public void addEntries(JavaCommaSplitEntry... entries) {
        if (entries.length > 0) {
            for (JavaCommaSplitEntry entry : entries) {
                if (!this.entries.contains(entry)) {
                    this.entries.add(entry);
                }
            }
        }
    }

    public boolean hasEntry() {
        return entries.size() > 0;
    }

    @Override
    public Set<JavaImportPart> getImports() {
        Set<JavaImportPart> result = new HashSet<JavaImportPart>();
        for (JavaCommaSplitEntry entry : entries) {
            result.add(new JavaImportPart(entry.getClassName()));
        }
        return Collections.unmodifiableSet(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JavaCommaSplitPart)) return false;

        JavaCommaSplitPart that = (JavaCommaSplitPart) o;

        if (Utils.checkCollectionEqual(entries, that.entries)) ;

        return true;
    }

    @Override
    public int hashCode() {
        return entries != null ? entries.hashCode() : 0;
    }
}
