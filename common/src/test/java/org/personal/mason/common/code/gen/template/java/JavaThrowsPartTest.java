package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.util.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class JavaThrowsPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaThrowsPart throwsPart = new JavaThrowsPart();
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(Integer.class.getName()));

        List<String> src = new ArrayList<String>();
        src.add("String");
        src.add("Integer");
        assertEquals(throwsPart.build(), "throws " + StringUtils.join(", ", src));
    }

    @Test
    public void testGetImports() throws Exception {
        JavaThrowsPart throwsPart = new JavaThrowsPart();
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        throwsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(Integer.class.getName()));

        Set<JavaImportPart> imports = throwsPart.getImports();
        assertEquals(imports.size(), 2);
    }

}