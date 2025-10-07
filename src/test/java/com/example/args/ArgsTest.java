package com.example.args;

import junit.framework.TestCase;

public class ArgsTest extends TestCase {
    public void testWithNoSchemaOrArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    public void testSimpleBooleanPresent() throws Exception {
        Args args = new Args("x", new String[]{"-x"});
        assertEquals(1, args.cardinality());
        assertTrue(args.getBoolean('x'));
    }

    public void testSimpleStringPresent() throws Exception {
        Args args = new Args("x*", new String[]{"-x", "param"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals("param", args.getString('x'));
    }

    public void testSpacesInFormat() throws Exception {
        Args args = new Args("x, y", new String[]{"-xy"});
        assertEquals(2, args.cardinality());
        assertTrue(args.has('x'));
        assertTrue(args.has('y'));
    }

    public void testSimpleIntPresent() throws Exception {
        Args args = new Args("x#", new String[]{"-x", "42"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42, args.getInt('x'));
    }

    public void testSimpleDoublePresent() throws Exception {
        Args args = new Args("x##", new String[]{"-x", "42.3"});
        assertTrue(args.isValid());
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42.3, args.getDouble('x'), .001);
    }

    public void testInvalidDouble() throws Exception {
        Args args = new Args("x##", new String[]{"-x", "Czterdzieści dwa"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertFalse(args.has('x'));
        assertEquals(0, args.getInt('x'));
        assertEquals("Argument -x oczekuje wartości double, a był 'Czterdzieści dwa'.",
                args.errorMessage());
    }

    public void testMissingDouble() throws Exception {
        Args args = new Args("x##", new String[]{"-x"});
        assertFalse(args.isValid());
        assertEquals(0, args.cardinality());
        assertFalse(args.has('x'));
        assertEquals(0.0, args.getDouble('x'), 0.01);
        assertEquals("Nie można znaleźć parametru double dla -x.", args.errorMessage());
    }
}
