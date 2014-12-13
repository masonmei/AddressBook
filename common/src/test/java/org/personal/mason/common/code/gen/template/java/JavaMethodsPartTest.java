package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JavaMethodsPartTest {

    @Test
    public void testGetParts() throws Exception {
        JavaMethodsPart methodsPart = new JavaMethodsPart(Arrays.asList(
                new JavaMethodPart("/**Test Common*/", VisitPrivilege.PUBLIC, IsStatic.STATIC, IsFinal.DEFAULT, String.class.getName(),
                        "testMethod", new JavaMethodParamsPart(new JavaCommaSplitPart()), new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build()),
                new JavaMethodPart("/**Test Common*/", VisitPrivilege.PUBLIC, IsStatic.STATIC, IsFinal.DEFAULT, String.class.getName(),
                        "testMethod2", new JavaMethodParamsPart(new JavaCommaSplitPart()), new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build())
        ));
        System.out.println(methodsPart.build());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}