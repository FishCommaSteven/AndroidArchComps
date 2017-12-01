package com.android.spike.steven.experimental.oop;

/**
 * Created by sfish on 11/30/17.
 */

public class RequiredString implements CharSequence, Comparable<RequiredString>{

    final private String value;

    private RequiredString(final String value) {
        this.value = value;
    }

    public static RequiredString fromString(final String value) {
        Guards.nullOrEmptyString(value, "fromString");
        return new RequiredString(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RequiredString)) {
            return false;
        }

        RequiredString other = (RequiredString) obj;
        return value.equals(other.value);
    }

    public boolean equalsIgnoreCase(RequiredString other) {
        return value.equalsIgnoreCase(other.value);
    }

    public int compareTo(RequiredString other) {
        return value.compareTo(other.value);
    }

    public int compareToIgnoreCase(RequiredString other) {
        return value.compareToIgnoreCase(other.value);
    }

    @Override
    public int length() {
        return value.length();
    }

    @Override
    public char charAt(int index) {
        return value.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return value.subSequence(start, end);
    }
}
