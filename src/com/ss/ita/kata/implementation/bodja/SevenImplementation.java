package com.ss.ita.kata.implementation.bodja;

import com.ss.ita.kata.Seven;
import java.util.Arrays;

public class SevenImplementation implements Seven {

    @Override
    public long newAvg(double[] arr, double navg) {
        if(arr.length == 0)
            return (long)navg;
        else
        {
            double sum = Arrays.stream(arr).sum();
            double next = navg * (arr.length + 1) - sum;
            if(next < 0)
                throw new IllegalArgumentException();
            else
                return (long)Math.ceil(next);
        }
    }

    @Override
    public String seriesSum(int n) {
        double sum = 0;
        for(int i = 1; i <= n; i++)
            sum += 1/(double)(1 + (i-1)*3);

        return String.format("%.2f",sum);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        return p - Math.max(bef, p - aft - 1);
    }
}
