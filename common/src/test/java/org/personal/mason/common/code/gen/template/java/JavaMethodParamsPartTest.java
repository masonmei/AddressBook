package org.personal.mason.common.code.gen.template.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class JavaMethodParamsPartTest {

    @Test
    public void testBuild() throws Exception {
        JavaMethodParamsPart paramsPart = new JavaMethodParamsPart();
        paramsPart.getCommaSplitList().addEntries(
                new JavaCommaSplitEntry(String.class.getName(), "username"),
                new JavaCommaSplitEntry(Integer.class.getName(), "age"),
                new JavaCommaSplitEntry(Boolean.class.getName(), "gender")
                );
        assertEquals(paramsPart.build(), "String username, Integer age, Boolean gender");
    }

    @Test
    public void testGetImports() throws Exception {

    }
}