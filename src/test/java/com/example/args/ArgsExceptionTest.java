package com.example.args;

import junit.framework.TestCase;

public class ArgsExceptionTest extends TestCase {
    public void testUnexpectedMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT,'x',null);
        assertEquals("Nieoczekiwany argument -x.", e.errorMessage());
    }

    public void testMissingMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_STRING,'x',null);
        assertEquals("Nie można znaleźć argumentu znakowego dla -x.", e.errorMessage());
    }

    public void testInvalidIntegerMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_INTEGER,'x',"Czterdzieści dwa");
        assertEquals("Argument -x oczekuje liczby całkowitej, a był 'Czterdzieści dwa'.", e.errorMessage());
    }

    public void testMissingIntegerMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_INTEGER,'x',null);
        assertEquals("Nie można znaleźć parametru całkowitego dla -x.", e.errorMessage());
    }

    public void testInvalidDoubleMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.INVALID_DOUBLE,'x',"Czterdzieści dwa");
        assertEquals("Argument -x oczekuje wartości double, a był 'Czterdzieści dwa'.", e.errorMessage());
    }

    public void testMissingDoubleMessage() throws Exception {
        ArgsException e = new ArgsException(ArgsException.ErrorCode.MISSING_DOUBLE,'x', null);
        assertEquals("Nie można znaleźć parametru double dla -x.", e.errorMessage());
    }
}
