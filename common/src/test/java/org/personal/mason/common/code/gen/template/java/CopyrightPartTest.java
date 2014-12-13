package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import java.net.URL;

import static org.junit.Assert.*;

public class CopyrightPartTest {

    @Test
    public void testBuild() throws Exception {
        CopyrightPart copyrightPart = new CopyrightPart(2014l, "igitras.com",
                "Apache License, Version 2.0 (the \"License\")",
                new URL("http://www.apache.org/licenses/LICENSE-2.0"));
        System.out.println(copyrightPart.build());
    }

    @Test
    public void testGetImports() throws Exception {

    }
}