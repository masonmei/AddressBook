package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaImportPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaImportPart importPart = new JavaImportPart(String.class.getName());
        assertEquals("import java.lang.String;"+System.lineSeparator(), importPart.build());
    }

    @Test
    public void testBuild() throws Exception {

    }
}