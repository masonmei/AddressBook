package org.personal.mason.common.code.util;

import org.junit.Test;
import org.personal.mason.common.code.gen.template.java.JavaCommaSplitEntry;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testJoin() throws Exception {
        String join = StringUtils.join(",", Arrays.asList("Test", "Hello"));
        assertEquals(join, "Test,Hello");
        join = StringUtils.join(",", Arrays.asList(new JavaCommaSplitEntry("Test"), new JavaCommaSplitEntry("Hello")));
        assertEquals(join, "Test,Hello");
    }

    @Test
    public void testLastSection() throws Exception {

    }

    @Test
    public void testIsClassName() throws Exception {

    }

    @Test
    public void testGetClassName() throws Exception {

    }

    @Test
    public void testIsImportClass() throws Exception {

    }

    @Test
    public void testCommaJoin() throws Exception {

    }

    @Test
    public void testGetLastSectionList() throws Exception {

    }

    @Test
    public void testCheckCollectionEqual() throws Exception {
        assertTrue(Utils.checkCollectionEqual(Arrays.asList(String.class.getName(), Integer.class.getName()),
                Arrays.asList(Integer.class.getName(), String.class.getName())));
        assertFalse(Utils.checkCollectionEqual(Arrays.asList(Integer.class.getName()),
                Arrays.asList(Integer.class.getName(), String.class.getName())));

        assertTrue(Utils.checkCollectionEqual(null, Arrays.asList()));

    }
}