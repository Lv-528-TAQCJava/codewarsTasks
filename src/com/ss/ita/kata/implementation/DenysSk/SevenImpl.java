package com.ss.ita.kata.implementation.DenysSk;

import com.ss.ita.kata.Seven;

import java.text.DecimalFormat;

public class SevenImpl implements Seven {

    @Override
    public long newAvg(double[] arr, double navg) {
        double counter = 0;

        for (double i : arr)
            counter += i;

        if (navg < counter / arr.length)
            throw new IllegalArgumentException();

        return (long) Math.ceil(navg * (arr.length + 1) - counter);
    }

    @Override
    public String seriesSum(int n) {
        float nthParameter = 1.0f;
        float num = 1.0f;

        if (n <= 0) nthParameter = 0;
        else for (int i = 1; i < n; i++) {
            num = num + 3;
            nthParameter += 1.0 / num;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return decimalFormat.format(num);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        int count = 0;
        for (int i = bef; i < p; i++) {
            if (p - i - 1 <= aft) {
                count++;
            }
        }
        return count;
    }

}

