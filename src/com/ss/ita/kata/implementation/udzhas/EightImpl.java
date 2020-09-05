package com.ss.ita.kata.implementation.udzhas;

import com.ss.ita.kata.Eight;

public class EightImpl implements Eight {
    public static final double litresInGallon = 4.54609188;
    public static final double kilometresInMile = 1.609344;

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

        for (int i = 0; i < array.length; i++) {
            int help = (int) Math.sqrt(array[i]);
            if (help * help == array[i]) {
                array[i] = help;
            } else {
                array[i] = array[i] * array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        } else {
            int[] newArray = {0, 0};
            for (int value : input) {
                if (value > 0) {
                    ++newArray[0];
                } else if (value < 0) {
                    newArray[1] += value;
                }
            }
            return newArray;

        }
    }

    @Override
    public int stringToNumber(String str) {

        return Integer.parseInt(str);
    }

    @Override
    public boolean amIWilson(double n) {
        long p = (long) n;
        if (p < 2)
            return false;
        long fact = 1;
        for (int i = 2; i < p; i++) {
            fact = fact * i;
            fact = fact % (p * p);
        }
        return (fact + 1) % (p * p) == 0;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return Double.parseDouble(String.format("%.2f", number));
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {

        int count = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                count++;
            }
        }
        int[] arr = new int[count];
        int i = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                arr[i] = number;
                i++;
            }
        }
        return arr;

    }

}
