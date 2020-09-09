package com.ss.ita.util;

import java.math.BigInteger;

/**
 * Provides source-independent reading possibilities
 */
public interface Scanner {

    /**
     * Reads integer from input source
     * @return int value
     */
    int readInt();

    /**
     * Reads long from input source
     * @return long value
     */
    long readLong();

    /**
     * Reads integer array from input source
     * @return array of integers
     */
    int[] readIntArray();

    /**
     * Reads float from input source
     * @return float value
     */
    float readFloat();

    /**
     * Reads double from input source
     * @return double value
     */
    double readDouble();

    /**
     * Reads double array from input source
     * @return array of doubles
     */
    double[] readDoubleArray();

    /**
     * Reads string from input source
     * @return string
     */
    String readString();

    /**
     * Reads string array from input source
     * @return array of strings
     */
    String[] readStringArray();

    /**
     * Reads big integer from input source
     * @return big integer value
     */
    BigInteger readBigInt();
}
