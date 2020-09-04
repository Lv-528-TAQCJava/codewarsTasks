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

        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) {
                array[i] = (int) Math.sqrt(array[i]);
            } else array[i] = array[i] * array[i];
        }
        return array;
    }


    @Override
    public int[] countPositivesSumNegatives(int[] input) {

        if (input == null || input.length == 0)
            return new int[]{};

        int[] result = new int[2];
        for (int j : input) {
            if (j > 0)
                result[0]++;
            else
                result[1] += j;
        }
        return result;
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

        DecimalFormat myFormatter = new DecimalFormat("###.##");
        String output = myFormatter.format(number);
        return Double.parseDouble(output);
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {

        int arrLenght = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                arrLenght++;
            }
        }
        int[] res = new int[arrLenght];
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % divider == 0) {
                res[k] = numbers[i];
                k++;
            }
        }

        return res;
    }
}
