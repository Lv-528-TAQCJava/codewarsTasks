package com.ss.ita.kata.implementation.solomiazh;

import com.ss.ita.kata.Seven;

import java.text.DecimalFormat;

public class SevenImpl implements Seven {

    @Override
    public long newAvg(double[] arr, double navg) {

        double average = 0;
        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        if (navg < average / arr.length) {
            throw new java.lang.IllegalArgumentException();
        } else {
            long ret = (long) Math.ceil((arr.length + 1) * navg - average);
            return ret;
        }
    }

    public String seriesSum(int n) {

        double sum = 1;
        double znam = 1;
        for (int i = 1; i < n; i++) {
            znam += 3;
            sum += 1 / znam;
        }
        DecimalFormat myFormatter = new DecimalFormat("###.00");
        return myFormatter.format(sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {

        return Math.min(p - bef, aft + 1);
    }


    @Override
    public long findNb(long m) {

        long i = 0;
        long sum = 0;
        while (sum < m) {
            i++;
            sum += i * i * i;

        }
        return sum == m ? i : -1;
    }
}

