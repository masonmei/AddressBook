package org.personal.mason.common.code.gen.template.java;

import org.junit.Before;
import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.enums.IsAbstract;
import org.personal.mason.common.code.gen.template.java.enums.IsFinal;
import org.personal.mason.common.code.gen.template.java.enums.IsStatic;
import org.personal.mason.common.code.gen.template.java.enums.VisitPrivilege;

import java.net.URL;
import java.util.Arrays;

import static org.junit.Assert.*;

public class JavaInterfaceFileTest {

    private JavaInterfaceFile interfaceFile;

    @Before
    public void setUp() throws Exception {
        CopyrightPart copyrightPart = new CopyrightPart(2014l, "igitras.com",
                "Apache License, Version 2.0 (the \"License\")",
                new URL("http://www.apache.org/licenses/LICENSE-2.0"));
        JavaPackagePart packagePart = new JavaPackagePart("org.personal.mason");

        JavaImportsPart importsPart = new JavaImportsPart();
        String comment = "/** Test Interface */";
        VisitPrivilege visitPrivilege = VisitPrivilege.PUBLIC;
        String className = "TestInterface";
        JavaExtendsPart extendsPart = new JavaExtendsPart();
        JavaFieldsPart fieldsPart = new JavaFieldsPart(Arrays.asList(
            new JavaFieldPart("/**"+System.lineSeparator()+" * "+System.lineSeparator()+" * @throws Exception"+System.lineSeparator()+" */", VisitPrivilege.PRIVATE, IsStatic.DEFAULT,
                IsFinal.DEFAULT, String.class.getName(), "testField", new JavaInitialPart())
        ));
        JavaAbstractMethodsPart methodsPart = new JavaAbstractMethodsPart();
        JavaAbstractMethodPart methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.DEFAULT, String.class.getName(),
                "testInterfaceMethods");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", IsAbstract.DEFAULT, String.class.getName(),
                "testInterfaceMethods1");
        methodsPart.addParts(methodPart);
        methodPart = new JavaAbstractMethodPart("/**Test comment*/", null, String.class.getName(),
                "testInterfaceMethods2");
        methodsPart.addParts(methodPart);
        interfaceFile = new JavaInterfaceFile(copyrightPart, packagePart, importsPart, comment,
                visitPrivilege, className, extendsPart, fieldsPart, methodsPart);
    }

    @Test
    public void testBuild() throws Exception {
        System.out.println(interfaceFile.build());
    }

    @Test
    public void testAddField() throws Exception {

    }

    @Test
    public void testRemoveField() throws Exception {

    }

    @Test
    public void testAddAbstractMethod() throws Exception {

    }

    @Test
    public void testRemoveAbstractMethod() throws Exception {

    }

    @Test
    public void testAddConstructor() throws Exception {

    }

    @Test
    public void testRemoveConstructor() throws Exception {

    }

    @Test
    public void testAddMethod() throws Exception {

    }

    @Test
    public void testRemoveMethod() throws Exception {

    }
}