package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaExtendsPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaExtendsPart extendsPart = new JavaExtendsPart();
        extendsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(String.class.getName()));
        extendsPart.getCommaSplitList().addEntries(new JavaCommaSplitEntry(Integer.class.getName()));
        assertEquals(extendsPart.build(), "extends String, Integer");
    }

    @Test
    public void testBuild() throws Exception {

    }
}