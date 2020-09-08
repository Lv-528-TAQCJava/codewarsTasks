package com.ss.ita.kata.implementation.bodja;

import com.ss.ita.kata.Five;

import java.math.BigInteger;
import java.util.Arrays;

public class FiveImplementation implements Five {
    @Override
    public int artificialRain(int[] v) {
        if (v.length == 1) {
            return 1;
        }

        int[] availableLeft = new int[v.length];
        int[] availableRight = new int[v.length];

        for (int i = 1; i < v.length; i++) {
            if (v[i - 1] <= v[i]) {
                availableLeft[i] = availableLeft[i - 1] + 1;
            }
        }

        for (int i = v.length-2; i >= 0; i--) {
            if (v[i + 1] <= v[i]) {
                availableRight[i] = availableRight[i + 1] + 1;
            }
        }

        int bestCoverage = 0;
        for (int i = 0; i < v.length; i++)  {
            int coverage = availableLeft[i] + availableRight[i] + 1;
            if (coverage > bestCoverage) {
                bestCoverage = coverage;
            }
        }

        return bestCoverage;
    }

    /**
     * Checks if number is prime
     * @param number
     * @return <b>true<b/> if number is prime
     */
    private static boolean isPrime(long number) {
        for (long i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        long last = Long.MIN_VALUE;
        for (long i = m; i < n; i++) {
            if (isPrime(i)) {
                if (i - last == g) {
                    return new long[]{last, i};
                }
                last = i;
            }
        }

        return null;
    }

    @Override
    public int zeros(int n) {
        int kMax = (int)(Math.log(n) / Math.log(5));
        int z = 0;

        for (int i = 1; i <= kMax; i++) {
            z+= (int)(n/Math.pow(5, i));
        }

        return z;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.valueOf(0);
        BigInteger prev = BigInteger.valueOf(0);
        BigInteger current = BigInteger.valueOf(1);
        sum = sum.add(current);

        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(n) == -1; i = i.add(BigInteger.ONE)) {
            BigInteger tmp = current;
            current = current.add(prev);
            prev = tmp;
            sum = sum.add(current);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        return -(-2*m + Math.sqrt(4*m + 1) - 1)/(2*m);
    }

    /**
     * Shifts chars by taking char 'from' and pasting 'to'
     * @param array
     * @param from
     * @param to
     * @return new array of  shifted chars
     */
    private static char[] moveChars(final char[] array, int from, int to)
    {
        char[] arr = Arrays.copyOf(array, array.length);
        char c = arr[(int)from];

        if (from > to) { // Shifting left
            for (int i = from; i > to; i--) {
                arr[i] = arr[i - 1];
            }
        } else {// Shifting right
            for (int i = from; i < to; i++) {
                arr[i] = arr[i + 1];
            }
        }
        arr[to] = c;

        return arr;
    }

    @Override
    public long[] smallest(long n) {
        long[] res = new long[3];
        String str = Long.toString(n);
        char[] digits = str.toCharArray();

        for (int begin = 0; begin < digits.length;) {
            int first = begin, last = begin;
            char lowest = '9';

            for (int i = begin; i < digits.length;) {
                if (digits[i] < lowest) {
                    lowest = digits[i];
                    first = i;
                    last = i;
                    while (i < digits.length && digits[i] == lowest) {
                        i++;
                    }
                } else if(digits[i] == lowest) {
                    last = i;
                    while (i < digits.length && digits[i] == lowest) {
                        i++;
                    }
                } else {
                    i++;
                }
            }

            if (last == begin) { // We cannot move lowest digits, because they are leading
                while (begin < digits.length && digits[begin] == lowest) {
                    begin++;
                }
                // And "recursion"...
            } else if (first == begin + 1) { // Then move the fist digit as far as possible
                int pos = first;

                while (pos < digits.length && digits[begin] >= digits[pos]) { // first greater digit
                    pos++;
                }
                pos-=1;
                while (digits[begin] == digits[pos]) {
                    pos--;
                }

                long l1 = Long.parseLong(String.copyValueOf(moveChars(digits, begin, pos)));
                long l2 = Long.parseLong(String.copyValueOf(moveChars(digits, last, begin)));
                if (l1 <= l2) {
                    res[1] = begin;
                    res[2] = pos;
                } else {
                    res[1] = last;
                    res[2] = begin;
                }
                break;
            }
            else { // We need to move the "farest" smallest to begin
                res[1] = last;
                res[2] = begin;
                break;
            }
        }

        res[0] = Long.parseLong(String.copyValueOf(moveChars(digits, (int)res[1], (int)res[2])));
        return res;
    }
}
