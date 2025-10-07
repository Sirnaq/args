package com.example.args;

public class ArgsException extends Exception {
    private char errorArgumentId = '\0';
    private String errorParameter = null;
    private ErrorCode errorCode = ErrorCode.OK;

    public ArgsException() {
    }

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }

    public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
        this.errorArgumentId = errorArgumentId;
    }

    public char getErrorArgumentId() {
        return errorArgumentId;
    }

    public void setErrorArgumentId(char errorArgumentId) {
        this.errorArgumentId = errorArgumentId;
    }

    public String getErrorParameter() {
        return errorParameter;
    }

    public void setErrorParameter(String errorParameter) {
        this.errorParameter = errorParameter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String errorMessage() throws Exception {
        switch (errorCode) {
            case OK:
                throw new Exception("TILT: Niedostępne.");
            case UNEXPECTED_ARGUMENT:
                return String.format("Nieoczekiwany argument -%c.", errorArgumentId);
            case MISSING_STRING:
                return String.format("Nie można znaleźć argumentu znakowego dla -%c.", errorArgumentId);
            case INVALID_INTEGER:
                return String.format("Argument -%c oczekuje liczby całkowitej, a był '%s'.",
                        errorArgumentId, errorParameter);
            case MISSING_INTEGER:
                return String.format("Nie można znaleźć parametru całkowitego dla -%c.", errorArgumentId);
            case INVALID_DOUBLE:
                return String.format("Argument -%c oczekuje wartości double, a był '%s'.",
                        errorArgumentId, errorParameter);
            case MISSING_DOUBLE:
                return String.format("Nie można znaleźć parametru double dla -%c.", errorArgumentId);
            case INVALID_ARGUMENT_NAME:
                return String.format("'%c' nie jest prawidłową nazwą argumentu.", errorArgumentId);
            case INVALID_ARGUMENT_FORMAT:
                return String.format("'%s' nie jest prawidłowym formatem dokumentu.", errorArgumentId);
        }
        return "";
    }

    public enum ErrorCode {
        OK, MISSING_STRING, MISSING_INTEGER, INVALID_INTEGER, UNEXPECTED_ARGUMENT,
        MISSING_DOUBLE, INVALID_DOUBLE, INVALID_ARGUMENT_NAME, INVALID_ARGUMENT_FORMAT
    }
}
