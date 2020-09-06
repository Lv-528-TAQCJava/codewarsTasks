package com.ss.ita.kata.implementation.ProstoLeleka;

import com.ss.ita.kata.Seven;

import java.text.DecimalFormat;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg){
        double sum = 0;
        for (double v : arr) sum += v;
        long ans = (long) Math.ceil((arr.length + 1) * navg - sum);
        if (ans < 0) throw new IllegalArgumentException();
        return ans;
    }


    @Override
    public String seriesSum(int n){

        double sum = 1;
        double param = 1;
        for (int i = 1; i < n; i++) {
        param += 3;
        sum += 1 / param;
        }
        DecimalFormat df = new DecimalFormat("#.00");
        return  String.valueOf(df.format(sum));

        }

    @Override
    public int whereIsHe(int p, int bef, int aft){
        return Math.min(p - bef, aft + 1);
    }

    }

