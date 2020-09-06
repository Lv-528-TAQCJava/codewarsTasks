package com.ss.ita.kata.implementation.ilona;

import com.ss.ita.kata.Eight;

import java.util.Arrays;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return (float) Math.round(100 * mpg * KILOMETRES_IN_MILE / LITRES_IN_GALLON) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {

            if (Math.sqrt(array[i]) % 1 == 0) {
                array[i] = (int) Math.round(Math.sqrt(array[i]));
            } else {
                array[i] = (int) Math.round(Math.pow(array[i], 2));
            }

        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int positiveSum = 0;
        int negativeSum = 0;
        int[] result = new int[2];
        int[] nullInput = new int[0];

        if (input == null || input.length == 0) {
            return nullInput;
        }
        if (input != null) {
            for (int i = 0; i < input.length; i++) {

                if (input[i] > 0) {
                    positiveSum++;
                } else {
                    negativeSum += input[i];
                }

            }
        }
        return new int[]{positiveSum, negativeSum};

    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public boolean amIWilson(double n) {
        return n == 5 || n == 13 || n == 563;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return Double.parseDouble(String.format("%.2f", number));
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int[] result = new int[numbers.length];
        int index = 0;
        for (int i : numbers)
            if (i % divider == 0)
                result[index++] = i;

        return Arrays.copyOf(result, index);
    }
}



