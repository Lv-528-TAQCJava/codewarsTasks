package com.ss.ita.kata.implementation.solomiazh;

import com.ss.ita.kata.Eight;

import java.text.DecimalFormat;

public class EightImpl implements Eight {

    @Override
    public int liters(double time) {

        return (int) (time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {

        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {

        double res = (mpg * KILOMETER / LITER * 100) / 100;
        DecimalFormat myFormatter = new DecimalFormat("###.##");
        String output = myFormatter.format(res);
        return Float.parseFloat(output);
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
