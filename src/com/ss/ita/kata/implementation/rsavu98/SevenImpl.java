package com.ss.ita.kata.implementation.rsavu98;

import java.util.Arrays;
import com.ss.ita.kata.Seven;

public class SevenImpl implements Seven {

    @Override
    public long newAvg(double[] arr, double navg) {
            double total = Arrays.stream(arr).sum();
            double res = navg * (arr.length + 1) - total;
            if (res > 0) {
                return Math.round(Math.ceil(res));
            } else {
                throw new IllegalArgumentException();
            }
        }

    @Override
    public String seriesSum(int n) {
        int denominator = 4;
        float sum = 0.00f;
        for (int counter = 1; counter <= n; counter++) {
            if (counter == 1) {
                sum += 1;
            }
            if (counter >= 2) {
                sum += (double) 1 / denominator;
                denominator += 3;
            }
        }
        return String.format("%.2f", sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        int withoutBef = p - bef;
        if (withoutBef > aft) {
            return aft + 1;
        } else return withoutBef;
    }

    @Override
    public long findNb(long m) {
        long totalVolume = 0L;
        int n = 0;
        while (totalVolume < m) {
            n++;
            totalVolume += (long) Math.pow(n, 3);
        }
        if (totalVolume == m) {
            return n;
        }
        return -1;
    }
}
