package com.ss.ita.kata.implementation.rsavu98;

import com.ss.ita.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public int artificialRain(int[] v) {
        int left = 0, area = 0, record = 1;
        for (int i = 1; i < v.length; i++) {
            if (v[i] < v[i - 1]) left = i;
            else if (v[i] > v[i - 1]) {
                area = Math.max(area, record);
                record = i - left;
            }
            record++;
        }
        return Math.max(area, record);
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

    private static boolean isPrime(long i) {
        for (long j = 2; j < i / 2; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        return (n < 5) ? 0 : (n / 5) + zeros(n / 5);
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
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solveSum(double m) {
        double s =  Math.sqrt(4 * m + 1);
        return (1 - s) / (2 * m) + 1;
    }

    @Override
    public long[] smallest(long n) {
        long[] arr = new long[3];
        long min = n;
        String str = n + "";
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                StringBuffer sb = new StringBuffer(str);
                char ch = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, ch);
                long num = Long.valueOf(sb.toString());
                if(num < min){
                    min = num;
                    arr[0] = min;
                    arr[1] = i;
                    arr[2] = j;
                }
            }
        }
        return arr;
    }
}
