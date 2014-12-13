package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaCommaSplitPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaCommaSplitPart splitClass = new JavaCommaSplitPart();
        splitClass.addEntries(new JavaCommaSplitEntry(String.class.getName()));
        splitClass.addEntries(new JavaCommaSplitEntry(Integer.class.getName()));
        splitClass.addEntries(new JavaCommaSplitEntry(Double.class.getName()));

        assertEquals(splitClass.build(), "String, Integer, Double");
    }

    @Test
    public void testGetImports() throws Exception {

    }
}