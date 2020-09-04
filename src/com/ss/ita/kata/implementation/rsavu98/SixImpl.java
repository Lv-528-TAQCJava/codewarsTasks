package com.ss.ita.kata.implementation.rsavu98;

import com.ss.ita.kata.Six;

public class SixImpl implements Six {
  
    @Override
    public int liters (double time) {
        return (int)(time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return (float)Math.round(mpg * 1.609344 / 4.54609188 * 100) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    @Override
    public int stringToNumber(String str) {
        return 0;
    }

    @Override
    public boolean amIWilson(double n) {
        return false;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return 0;
    }
  

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }
}

