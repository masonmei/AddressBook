package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import java.util.Arrays;

import static org.junit.Assert.*;

public class JavaFieldsPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaFieldPart fieldPart = new JavaFieldPart("/**"+System.lineSeparator()+" * "+System.lineSeparator()+" * @throws Exception"+System.lineSeparator()+" */", VisitPrivilege.PRIVATE, IsStatic.DEFAULT,
                IsFinal.DEFAULT, String.class.getName(), "testField", new JavaInitialPart());
        JavaFieldPart fieldPart2 = new JavaFieldPart("/**"+System.lineSeparator()+" * "+System.lineSeparator()+" * @throws Exception"+System.lineSeparator()+" */", VisitPrivilege.PRIVATE, IsStatic.DEFAULT,
                IsFinal.DEFAULT, String.class.getName(), "testField2", new JavaInitialPart());
        JavaFieldsPart fieldsPart = new JavaFieldsPart(Arrays.asList(fieldPart, fieldPart2));
        System.out.println(fieldsPart.build());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}