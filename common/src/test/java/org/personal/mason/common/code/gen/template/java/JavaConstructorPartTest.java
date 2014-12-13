package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import static org.junit.Assert.*;

public class JavaConstructorPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaConstructorPart constructorPart = new JavaConstructorPart("/**Test*/", VisitPrivilege.PROTECTED, "JavaTest",
                new JavaMethodParamsPart(), new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build());
        System.out.println(constructorPart.build());
    }

    @Test
    public void testBuild() throws Exception {

    }
}