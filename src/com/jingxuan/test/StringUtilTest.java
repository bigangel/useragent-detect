package com.jingxuan.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jingxuan.utils.StringUtils;


public class StringUtilTest {

    @Test
    public void testIsEmpty() {
        String str1 = "null"; 
        String str2 = null;
        String str3 = "false";
        String str4 = "";
        String str5 = "     ";
        // exception return: true, true, true, true, true
        assertTrue(StringUtils.isEmpty(str1));
        assertTrue(StringUtils.isEmpty(str2));
        assertTrue(StringUtils.isEmpty(str3));
        assertTrue(StringUtils.isEmpty(str4));
        assertTrue(StringUtils.isEmpty(str5));
    }

    @Test
    public void testIsNotEmpty() {
        String str1 = "null";  // false
        String str2 = null; // false
        String str3 = "false2"; // true
        String str4 = " 2132"; // true
        
        assertFalse(StringUtils.isNotEmpty(str1));
        assertFalse(StringUtils.isNotEmpty(str2));
        assertTrue(StringUtils.isNotEmpty(str3));
        assertTrue(StringUtils.isNotEmpty(str4));
    }
}
