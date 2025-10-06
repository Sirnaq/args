package com.example.args;

import junit.framework.TestCase;

public class ArgsTest extends TestCase {
    public void testWithNoSchemaOrArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

//    public void testWithNoSchemaButWithOneArgument() throws Exception {
//        try {
//            new Args("", new String[]{"-x"});
//            fail();
//        } catch (Exception e) {
//
//        }
//    }
}
