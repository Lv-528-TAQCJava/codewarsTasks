package com.ss.ita.kata.implementation.ProstoLeleka;

import com.ss.ita.kata.Five;

import java.math.BigInteger;


public class FiveImpl implements Five {
    @Override
    public int artificialRain(int[] v) { return 0; }

    @Override
    public long[] gap(int g, long m, long n) { return null; }

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
    public BigInteger perimeter(BigInteger n) { return null; }

    @Override
    public double solveSum ( double m){
        return 0;
    }

    @Override
    public long[] smallest ( long n){
        return new long[0];
    }
}

