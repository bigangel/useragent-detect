package com.jingxuan.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jingxuan.utils.PatternUtils;

public class PatternUnitTest {

//    @Test
//    public void testMatch() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testCheck() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testCheckAll() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testCheckButExclude() {
//        fail("Not yet implemented");
//    }
//
//    @Test
//    public void testCheckAllButExclude() {
//        fail("Not yet implemented");
//    }

    @Test
    public void testStringOfPattern() {
        String[] patterns = {"jingxuan", "wenhao", "andy"};
        String  actual = PatternUtils.stringOfPattern(patterns);
        String expected = "jingxuan|wenhao|andy";
        
        assertEquals(expected, actual);
//        System.out.println(actual);
    }

}
