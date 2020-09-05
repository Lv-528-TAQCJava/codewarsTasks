package com.ss.ita.kata.implementation.ProstoLeleka;


import com.ss.ita.kata.Eight;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {

        return (int) (time/2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {

        return (length * width * height);
    }

    @Override
    public float mpgToKPM(float mpg) {

        return (float) Math.round(100 * mpg * KILOMETRES_IN_MILE / LITRES_IN_GALLON) / 100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {

        for(int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) array[i] = (int) Math.sqrt(array[i]);
            else array[i] = array[i] * array[i];
        }
        return array;
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
