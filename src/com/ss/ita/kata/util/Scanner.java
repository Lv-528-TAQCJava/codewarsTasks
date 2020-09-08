package com.ss.ita.kata.util;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Provides source-independent reading possibilities
 */
public interface Scanner {

    /**
     * Reads integer from input source
     * @return int value
     */
    int getInt() throws IOException;

    /**
     * Reads long from input source
     * @return long value
     */
    long getLong() throws IOException;

    /**
     * Reads integer array from input source
     * @return array of integers
     */
    int[] getIntArray() throws IOException;

    /**
     * Reads float from input source
     * @return float value
     */
    float getFloat() throws IOException;

    /**
     * Reads double from input source
     * @return double value
     */
    double getDouble() throws IOException;

    /**
     * Reads double array from input source
     * @return array of doubles
     */
    double[] getDoubleArray() throws IOException;

    /**
     * Reads string from input source
     * @return string
     */
    String getString() throws IOException;

    /**
     * Reads string array from input source
     * @return array of strings
     */
    String[] getStringArray() throws IOException;

    /**
     * Reads big integer from input source
     * @return big integer value
     */
    BigInteger getBigInt() throws IOException;
}
