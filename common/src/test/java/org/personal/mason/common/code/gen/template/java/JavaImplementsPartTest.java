package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaImplementsPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaImplementsPart implementsPart = new JavaImplementsPart();
        implementsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        implementsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(Integer.class.getName()));
        assertEquals(implementsPart.build(), "implements String, Integer");
    }

    @Test
    public void testGetImports() throws Exception {

    }
}