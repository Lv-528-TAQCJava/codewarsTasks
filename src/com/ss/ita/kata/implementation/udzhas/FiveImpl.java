package com.ss.ita.kata.implementation.udzhas;

import com.ss.ita.kata.Five;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class FiveImpl implements Five {
    static boolean CanFlowLeft(int[] numbers, int i) {
        if (i == 0)
            return false;
        return numbers[i - 1] <= numbers[i];
    }

    static boolean CanFlowRight(int[] numbers, int i) {
        if (numbers.length - 1 == i)
            return false;
        return numbers[i + 1] <= numbers[i];
    }

    static int[] LeftFlow(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            if (CanFlowLeft(numbers, i)) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    static int[] RightFlow(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (CanFlowRight(numbers, i)) {
                result[i] = result[i + 1] + 1;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }
    private static boolean isPrime(long n){
        for(var i=2; i < n; i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    @Override
    public int artificialRain(int[] v) {
        int[] flowRight = FiveImpl.RightFlow(v);
        int[] flowLeft = FiveImpl.LeftFlow(v);

        int maxWateredPlains = 0;

        for (int i = 0; i < flowLeft.length; i++) {
            maxWateredPlains = Math.max(flowLeft[i] + flowRight[i] + 1, maxWateredPlains);
        }
        return maxWateredPlains;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        long last = 0;
        for (long i=m;i<n;i++) {
            if (isPrime(i)) {
                if (i - last == g) {
                    long []result = new long[2];
                    result[0] = last;
                    result[1] = i;
                    return result;
                }
                last = i;
            }
        }
        return null;

    }

    @Override
    public int zeros(int n) {
        int numOfZeroes=0;
        while(n!= 0){
            numOfZeroes += (int)Math.floor(n/5);
            n/=5;
        }
        return numOfZeroes;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        Supplier<BigInteger> fibonachi = new Supplier() {
            private BigInteger previous = BigInteger.valueOf(0);
            private BigInteger current = BigInteger.valueOf(1);

            @Override
            public BigInteger get() {
                BigInteger nextValue = this.previous.add(this.current);
                this.previous = this.current;
                this.current = nextValue;
                return this.previous;
            }
        };

        BigInteger fibonachiSum = Stream.generate(fibonachi)
                .limit(n.intValue() + 1)
                .reduce(BigInteger.ZERO, BigInteger::add);

        return BigInteger.valueOf(4).multiply(fibonachiSum);
    }

    @Override
    public double solveSum(double m) {
        return 1 + (1 - Math.sqrt(1+4*m)) / (2*m);
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
