package com.ss.ita.kata.implementation.udzhas;

import com.ss.ita.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];
        long ans = (long) Math.ceil((arr.length + 1) * navg - sum);
        if (ans < 0) throw new IllegalArgumentException();
        return ans;
    }

    @Override
    public String seriesSum(int n) {

        float result = 1.0f;
        float baseNum = 1.0f;
        if (n <= 0) result = 0;
        else {
            for (int i = 1; i < n; i++) {
                baseNum = baseNum + 3;
                result += 1.0 / baseNum;
            }
        }
        return String.format("%.2f", result);
    }

    @Override
    public int whereIsHe(int p, int bef, int aft) {

        int count = 0;
        int befor = 0;
        int after = 0;
        for (int i = 1; i <= p; i++) {
            befor = i - 1;
            after = p - i;
            if (befor >= bef && after <= aft) {
                count++;
            }
        }
        return count;
    }

}
