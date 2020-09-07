package com.ss.ita.kata.implementation.meownjik;

import com.ss.ita.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        // (sum + x) / n == navg
        // x = n * navg - sum
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int n = arr.length + 1;

        int x = (int) Math.ceil(n * navg - sum);

        if (x<=0)
            throw new java.lang.IllegalArgumentException();
        return x;
    }

    @Override
    public String seriesSum(int n) {
        // 1/1 + 1/4 + 1/7 + ... + 1/(n-3) + 1/n
        double sum = 0.0;
        for (int i = 1, j = 1; i<=n; i++)
        {
            sum += 1.0/j;
            j+=3;
        }
        sum = Math.round(sum * 100) / 100.0;
        String res = Double.toString(sum);
        if (res.length() < 4)
            res += "0";
        return res;
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {
        if (bef+aft>=p)
            return p - bef;
        else
            return aft + 1;
    }
}
