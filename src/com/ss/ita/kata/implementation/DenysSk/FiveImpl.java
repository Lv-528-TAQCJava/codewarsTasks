package com.ss.ita.kata.implementation.DenysSk;

import com.ss.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public int artificialRain(int[] v) {
        if (v.length == 1) {
            return 1;
        }

        int[] left = new int[v.length];
        int[] right = new int[v.length];

        for (int i = 1; i < v.length; i++) {
            if (v[i - 1] <= v[i]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = v.length-2; i >= 0; i--) {
            if (v[i + 1] <= v[i]) {
                right[i] = right[i + 1] + 1;
            }
        }

        int bestCoverage = 0;
        for (int i = 0; i < v.length; i++)  {
            int coverage = left[i] + right[i] + 1;
            if (coverage > bestCoverage) {
                bestCoverage = coverage;
            }
        }

        return bestCoverage;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        return (int)Math.floor(n / 5);
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        BigInteger c = new BigInteger("0");
        BigInteger result = new BigInteger("2");
        for(int i = 3; i <= n.intValue() + 1; i++){
            c = a.add(b);
            result = result.add(c);
            a = b;
            b = c;
        }
        return result.multiply(new BigInteger("4"));
    }

    @Override
    public double solveSum(double m) {
        return 1 + (1 - Math.sqrt(1+4*m)) / (2*m);
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
