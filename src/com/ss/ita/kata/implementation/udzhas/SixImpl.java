package com.ss.ita.kata.implementation.udzhas;

import com.ss.ita.kata.Six;

public class SixImpl implements Six {
    public static final double litresInGallon = 4.54609188;
    public static final double kilometresInMile = 1.609344

    @Override
    public int liters(double time) {
        return (int) Math.floor(time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double res = mpg / litresInGallon * kilometresInMile;
        return (float) Math.round(res * 100) / 100;

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
