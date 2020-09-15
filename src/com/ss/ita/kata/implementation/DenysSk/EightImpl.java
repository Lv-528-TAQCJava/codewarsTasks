package com.ss.ita.kata.implementation.DenysSk;

import com.ss.ita.kata.Eight;

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
        double kmPerLiter = mpg / LITRES_IN_GALLON * KILOMETRES_IN_MILE;
        return (float)(Math.round(kmPerLiter * 100.0) / 100.0);
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for(int i = 0; i < array.length; i++)
        {
            if(Math.sqrt(array[i]) % 1 == 0)
            {
                array[i] = (int) Math.sqrt(array[i]);
            }
            else array[i] = array[i] * array[i];
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int count = 0;
        int sum = 0;
        if(input == null || input.length == 0){
            return new int[]{};
        }
        for(int i = 0 ; i < input.length; i++) {
            if(input[i] > 0) count++;
            else sum += input[i];
        }
        return new int[] {count, sum};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt((str));
    }

    @Override
    public boolean amIWilson(double n) {
        long p = (long) n;
        if (p < 2) return false;

        long factorial = 1;
        for (int i = 2; i < p; i++) {
            factorial = factorial * i;
            factorial = factorial % (p * p);
        }
        return (factorial + 1) % (p * p) == 0;
    }


    @Override
    public double twoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int masLength = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % divider == 0) {masLength++;};
        }
        int[] array = new int[masLength];
        int j = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] % divider == 0){
                array[j] = numbers[i];
                j++;
            }
        }
        return array;
    }
}
