package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import static org.junit.Assert.*;

public class JavaFieldPartTest {

    /**
     *
     * @throws Exception
     */
    @Test
    public void testBuild() throws Exception {
        JavaFieldPart fieldPart = new JavaFieldPart("/**"+System.lineSeparator()+" * "+System.lineSeparator()+" * @throws Exception"+System.lineSeparator()+" */", VisitPrivilege.PRIVATE, IsStatic.DEFAULT,
                IsFinal.DEFAULT, String.class.getName(), "testField", new JavaInitialPart());
        System.out.println(fieldPart.build());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}