package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaImportsPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaImportsPart importsPart = new JavaImportsPart();
        JavaImportPart importPart = new JavaImportPart(String.class.getName());
        importsPart.addParts(importPart);
        importPart = new JavaImportPart(Integer.class.getName());
        importsPart.addParts(importPart);

        assertEquals(importsPart.build(), System.lineSeparator()+"import java.lang.String;"+System.lineSeparator()+"import java.lang.Integer;"+System.lineSeparator()+System.lineSeparator());
    }

    @Test
    public void testBuild() throws Exception {

    }
}