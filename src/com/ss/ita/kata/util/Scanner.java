package com.ss.ita.kata.util;

import java.math.BigInteger;

/**
 * Provides source-independent reading possibilities
 */
public interface Scanner {

    /**
     * Reads integer from input source
     * @return int value
     */
    int getInt();

    /**
     * Reads long from input source
     * @return long value
     */
    long getLong();

    /**
     * Reads integer array from input source
     * @return array of integers
     */
    int[] getIntArray();

    /**
     * Reads float from input source
     * @return float value
     */
    float getFloat();

    /**
     * Reads double from input source
     * @return double value
     */
    double getDouble();

    /**
     * Reads double array from input source
     * @return array of doubles
     */
    double[] getDoubleArr();

    /**
     * Reads string from input source
     * @return string
     */
    String getString();

    /**
     * Reads string array from input source
     * @return array of strings
     */
    String[] getStringArray();

    /**
     * Reads big integer from input source
     * @return big integer value
     */
    BigInteger getBigInt();
}
