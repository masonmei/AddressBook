package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;

import static org.junit.Assert.*;

public class JavaAbstractMethodsPartTest {

    @Test
    public void testGetImports() throws Exception {

    }

    @Test
    public void testBuild() throws Exception {
        JavaAbstractMethodsPart methodsPart = new JavaAbstractMethodsPart();
        JavaAbstractMethodPart methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.ABSTRACT, String.class.getName(),
                "testAbstractMethods");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.ABSTRACT, String.class.getName(),
                "testAbstractMethods1");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.ABSTRACT, String.class.getName(),
                "testAbstractMethods2");
        methodsPart.addParts(methodPart);
        System.out.println(methodsPart.build());
    }

    @Test
    public void testBuildForInterface() throws Exception {
        JavaAbstractMethodsPart methodsPart = new JavaAbstractMethodsPart();
        JavaAbstractMethodPart methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.DEFAULT, String.class.getName(),
                "testAbstractMethods");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.DEFAULT, String.class.getName(),
                "testAbstractMethods1");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", null, String.class.getName(),
                "testAbstractMethods2");
        methodsPart.addParts(methodPart);
        System.out.println(methodsPart.build());
    }
}