package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class JavaMethodPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaMethodPart methodPart = new JavaMethodPart("/**Test Common*/", VisitPrivilege.PUBLIC, IsStatic.STATIC, IsFinal.DEFAULT, String.class.getName(),
                "testMethod", new JavaMethodParamsPart(new JavaCommaSplitPart()), new JavaThrowsPart(), JavaMethodLogicalBuilder.createBuilder().build());
        System.out.println(methodPart.build());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}