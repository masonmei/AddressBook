package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;

import static org.junit.Assert.*;

public class JavaAbstractMethodPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaAbstractMethodPart methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.ABSTRACT, String.class.getName(),
                "testAbstractMethod");
        assertEquals(methodPart.build(), System.lineSeparator() + "/**Test comment*/"+System.lineSeparator()+"abstract String testAbstractMethod () ;"+System.lineSeparator());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}