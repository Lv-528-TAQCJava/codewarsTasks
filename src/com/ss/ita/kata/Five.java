package com.ss.ita.kata;

import java.math.BigInteger;

public interface Five {

    /**
     * Artificial Rain
     * @param v
     * @return
     */
    int artificialRain(final int[] v);

    /**
     * Gap in Primes
     * @param g
     * @param m
     * @param n
     * @return
     */
    long[] gap(int g, long m, long n);

    /**
     * Number of trailing zeros of N!
     * @param n
     * @return
     */
    int zeros(int n);

    /**
     * Perimeter of squares in a rectangle
     * @param n
     * @return
     */
    BigInteger perimeter(BigInteger n);

    /**
     * Which x for that sum
     * @param m
     * @return
     */
    double solveSum(double m);

    /**
     * Find the smallest
     * @param n
     * @return
     */
    long[] smallest(long n);
}
