package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JavaConstructorsPartTest {

    @Test
    public void testGetImports() throws Exception {
        JavaConstructorsPart constructorsPart = new JavaConstructorsPart();
        constructorsPart.addParts(
                new JavaConstructorPart("/**Test*/", VisitPrivilege.PROTECTED, "JavaTest",
                        new JavaMethodParamsPart(), new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build()),
                new JavaConstructorPart("/**Test*/", VisitPrivilege.PROTECTED, "JavaTest",
                        new JavaMethodParamsPart(new JavaCommaSplitPart(Arrays.asList(new JavaCommaSplitEntry(String.class.getName(), "username")))),
                        new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build())
        );
        System.out.println(constructorsPart.build());
    }

    @Test
    public void testBuild() throws Exception {

    }
}