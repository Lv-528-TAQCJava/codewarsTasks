package com.ss.ita.kata.implementation.meownjik;

import com.ss.ita.kata.Five;

import java.math.BigInteger;
import java.util.Arrays;

public class FiveImpl implements Five {
    @Override
    public int artificialRain(final int[] v) {
        if (v.length==1)
            return 1;
        int onr=0, bestNum = 1;
        for (int i=0; i<v.length; i+=onr+1) {
            onr = onRight(i, v);
            int num = onr + onLeft(i, v) + 1;
            if (num > bestNum)
                bestNum = num;
        }
        return bestNum;
    }

    /**
     * Number of points that could be watered from given position, with water moving right
     * @param pos position from which the garden is to be watered
     * @param v garden representation (same as in artificialRain method)
     */
    public static int onRight(int pos, int[] v) {
        //Doesn't count current position
        int count = 0;
        for (int i = pos; i<v.length-1 && v[i]>=v[i+1]; i++) {
            count++;
        }
        return count;
    }
    /**
     * Number of points that could be watered from given position, with water moving left
     * @param pos position from which the garden is to be watered
     * @param v garden representation (same as in artificialRain method)
     */
    public static int onLeft(int pos, int[] v) {
        int count = 0;
        for (int i = pos; i>0 && v[i-1]<=v[i]; i--) {
            count++;
        }
        return count;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        Eratosfen erat = new Eratosfen(n);
        erat.fillSieve();
        boolean[] primes = erat.primes;

        long prev = m;
        for (long i=m; i<=n; i++){
            if (primes[(int)i]){
                prev = i;
                break;
            }
        }
        int count = 0;
        for (long i=prev; i<=n; i++) {
            count++;
            if (primes[(int)i]){
                if (count==g)
                    return new long[] {prev, i};
                else {
                    prev = i;
                    count = 0;
                }
            }
        }
        return null;
    }
    /**
     * Eratosthenes sieve,
     * insolently copied from Wikipedia:
     * https://ru.wikibooks.org/wiki/%D0%A0%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D0%B8_%D0%B0%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC%D0%BE%D0%B2/%D0%A0%D0%B5%D1%88%D0%B5%D1%82%D0%BE_%D0%AD%D1%80%D0%B0%D1%82%D0%BE%D1%81%D1%84%D0%B5%D0%BD%D0%B0#Java
     */
    public static class Eratosfen { //Copied from Wikipedia
        public boolean[] primes;
        public Eratosfen(long n) {
            primes=new boolean[(int)n+1];
        }
        public void fillSieve() {
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for (long i = 2; i < primes.length; ++i) {
                if (primes[(int)i]) {
                    for (long j = 2; i * j < primes.length; ++j) {
                        primes[(int)(i * j)] = false;
                    }
                }
            }
        }
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; i<=n; i*=5){
            for (int j=i; j<=n; j+=i)
                count++;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return fiboSum(n.add(BigInteger.ONE)).multiply(BigInteger.valueOf(4));
    }

    /**
     * Sum of Fibonacci numbers from 1st to nth
     */
    public static BigInteger fiboSum(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))
            return  n;
        BigInteger sum = BigInteger.valueOf(2), preprev = BigInteger.ONE, prev = BigInteger.ONE, next;
        for (BigInteger i = BigInteger.valueOf(2);
             i.compareTo(n) < 0 ;
             i = i.add(BigInteger.ONE)) {
            next = preprev.add(prev);
            sum = sum.add(next);
            preprev = prev;
            prev = next;
        }
        return sum;
    }

    @Override
    public double solveSum(double m) {
        return 1 + 1.0/(2*m) - Math.sqrt(4*m+1)/(2*m);
    }

    @Override
    public long[] smallest(long n) {
        String strn = String.valueOf(n);
        long min = n;
        int f1=0, f2=0; //flip indices
        for (int i = 0, len = strn.length(); i < len; i++) {
            for (int j = 0; j < len; j++) {
                String newStr = flip(strn, i, j);
                long newVal = Long.parseLong(newStr);
                if (newVal < min) {
                    min = newVal;
                    f1 = i; f2 = j;
                }
            }
        }
        return new long[] {min, f1, f2};
    }
    /**
     * Pop one character from the string and place it to the given position
     * @param n given string
     * @param indChar index of char to flip
     * @param indInsert index of where to insert it
     * @return string with flipped char
     */
    public static String flip(String n, int indChar, int indInsert) {
        if (indChar > indInsert) {
            return n.substring(0, indInsert) + n.charAt(indChar) + n.substring(indInsert, indChar)
                    + n.substring(indChar+1);
        }
        else if (indChar < indInsert) {
            return n.substring(0, indChar) + n.substring(indChar+1, indInsert+1) + n.charAt(indChar)
                    + n.substring(indInsert+1);
        }
        else
            return n;
    }
}
