package com.android.spike.steven.experimental.oop.CustomExceptions;

/**
 * Created by sfish on 11/30/17.
 */

public class NullOrEmptyStringException extends RuntimeException {
    private static String baseMessage = "Null or Empty String detected: %s";
    public NullOrEmptyStringException(String tag) {
        super(String.format(baseMessage, tag));
    }
}
