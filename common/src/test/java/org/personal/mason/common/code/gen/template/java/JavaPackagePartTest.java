package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaPackagePartTest {

    @Test
    public void testBuild() throws Exception {
        JavaPackagePart packagePart = new JavaPackagePart("org.personal.mason");
        assertEquals(packagePart.build(), "package org.personal.mason;"+System.lineSeparator());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}