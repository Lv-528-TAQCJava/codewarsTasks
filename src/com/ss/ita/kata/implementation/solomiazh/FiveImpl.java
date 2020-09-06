package com.ss.ita.kata.implementation.solomiazh;

import com.ss.ita.kata.Five;

import java.math.BigInteger;
import java.util.Arrays;

public class FiveImpl implements Five {

    @Override
    public int artificialRain(int[] v) {

        int[] right = new int[v.length];
        int[] left = new int[v.length];
        left[0] = 0;
        right[v.length - 1] = 0;
        for (int i = 1; i < v.length; i++) {
            if (v[i - 1] <= v[i]) {
                left[i] = left[i - 1] + 1;
            } else left[i] = 0;
        }
        for (int i = v.length - 2; i >= 0; i--) {
            if (v[i] >= v[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else right[i] = 0;
        }

        for (int i = 0; i < v.length; i++) {
            left[i] += right[i];
        }
        int max = left[0];
        for (int i = 1; i < v.length; i++) {
            if (left[i] > max) {
                max = left[i];
            }
        }
        return max + 1;
    }


    @Override
    public long[] gap(int g, long m, long n) {
        Eratosfen eratosfen = new Eratosfen(n);
        eratosfen.fillSieve();
        boolean[] primes = eratosfen.primes;

        long prev = m;
        for (long i = m; i <= n; i++) {
            if (primes[(int) i]) {
                prev = i;
                break;
            }
        }
        int count = 0;
        for (long i = prev; i <= n; i++) {
            count++;
            if (primes[(int) i]) {
                if (count == g)
                    return new long[]{prev, i};
                else {
                    prev = i;
                    count = 0;
                }
            }
        }
        return null;
    }

    public static class Eratosfen {
        public boolean[] primes;

        public Eratosfen(long n) {
            primes = new boolean[(int) n + 1];
        }

        public void fillSieve() {
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for (long i = 2; i < primes.length; ++i) {
                if (primes[(int) i]) {
                    for (long j = 2; i * j < primes.length; ++j) {
                        primes[(int) (i * j)] = false;
                    }
                }
            }
        }
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5)
            count += n / i;
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {

            BigInteger a = BigInteger.ONE;
            BigInteger b = BigInteger.ONE;
            BigInteger sum = BigInteger.ONE;
            BigInteger i = BigInteger.ZERO;
            for (; !i.equals(n); i = i.add(BigInteger.ONE)) {

                b = b.add(a);
                a = b.subtract(a);
                sum = sum.add(a);
            }
            return sum = sum.multiply(BigInteger.valueOf(4));
        }


        @Override
        public double solveSum ( double m){
            return 0;
        }

        @Override
        public long[] smallest ( long n){
            return new long[0];
        }
    }
