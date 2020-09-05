package com.ss.ita.kata.implementation.rsavu98;

import com.ss.ita.kata.Eight;

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
        return (float) Math.round(mpg * 1.609344 / 4.54609188 * 100) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        {
            for (int i = 0; i < array.length; i++) {
                double sqroot = Math.sqrt(array[i]);
                array[i] = sqroot % 1 == 0
                        ? (int) sqroot
                        : array[i] * array[i];
            }

            return array;
        }
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int[] output = new int[2];
        if (input == null || input.length == 0) {
            return new int[0];
        }
        for (int value : input) {
            if (value > 0) {
                output[0] += 1;
            } else output[1] += value;
        }
        return output;
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
        return Math.round(number * 100.0) / 100.0;
    }


    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int arrayLength = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                arrayLength++;
            }
        }
        int[] output = new int[arrayLength];
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                output[k] = numbers[i];
                k++;
            }
        }

        return output;
    }
}


