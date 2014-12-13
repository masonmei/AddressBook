package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaEnumElementsPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaEnumElementsPart elementsPart = new JavaEnumElementsPart();
        elementsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        elementsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(Integer.class.getName()));
        assertEquals(elementsPart.build(), System.lineSeparator() + "String, Integer"+System.lineSeparator());
    }

    @Test
    public void testBuild() throws Exception {

    }
}