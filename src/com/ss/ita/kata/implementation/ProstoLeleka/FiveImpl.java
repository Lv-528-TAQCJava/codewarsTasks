package com.ss.ita.kata.implementation.ProstoLeleka;

import com.ss.ita.kata.Five;

import java.math.BigInteger;


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
        int s = 0;
        while( n > 0 ){
            n /= 5;
            s += n;
        }
        return s;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        new BigInteger("0");
        BigInteger a = new BigInteger("1"), b = new BigInteger("1"), c;
        BigInteger res = new BigInteger("2");
        for(int i = 3; i <= n.intValue()+1; i++){
            c = a.add(b);
            res = res.add(c);
            a = b;
            b = c;
        }
        return res.multiply(new BigInteger("4"));
    }

    @Override
    public double solveSum ( double m){
        return 1 + (1 - Math.sqrt(1+4*m)) / (2*m);
    }

    @Override
    public long[] smallest ( long n){

        long[] arr = new long[3];
        long min = n;
        String str = n + "";
        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                StringBuilder sb = new StringBuilder(str);
                char ch = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, ch);
                long num = Long.parseLong(sb.toString());
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

