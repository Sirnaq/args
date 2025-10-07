package com.example.args;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.example.args.ArgsException.ErrorCode.MISSING_STRING;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    String[] stringArrayValue = new String[]{};

    @Override
    public void set(Iterator<String> currentArgument) throws ArgsException {
        try {
            stringArrayValue = currentArgument.next().split(" ");
        } catch (NoSuchElementException e) {
            throw new ArgsException(MISSING_STRING);
        }
    }

    public static String[] getValue(ArgumentMarshaler am) {
        if (am != null && am instanceof StringArrayArgumentMarshaler)
            return ((StringArrayArgumentMarshaler) am).stringArrayValue;
        else
            return new String[]{};
    }
}
