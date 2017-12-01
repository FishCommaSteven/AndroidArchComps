package com.android.spike.steven.experimental.oop;

import com.android.spike.steven.experimental.oop.CustomExceptions.NullOrEmptyStringException;

/**
 * Created by sfish on 11/30/17.
 */

public class Guards {

    public static void nullOrEmptyString(String value, String tag) {
        if (value == null || value.isEmpty()) {
            throw new NullOrEmptyStringException(tag);
        }
    }
}
