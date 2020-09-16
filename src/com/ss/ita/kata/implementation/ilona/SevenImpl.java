package com.ss.ita.kata.implementation.ilona;

import com.ss.ita.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = Arrays.stream(arr).sum();
        double result = navg * (arr.length + 1) - sum;

        if (result > 0) {
            return Math.round(Math.ceil(result));
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String seriesSum(int n) {
        double result = 0.0;
        for (int i = 0; i < n; i++) {
            result += 1.0 / (1 + 3 * i);
        }
        return String.format("%.2f", result);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return Math.min(p - bef, aft + 1);
    }
}
