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

        if (input == null || input.length == 0)
            return new int[]{};
        int count = 0,sum = 0;
        for (int i : input) {
            if (i > 0) count ++;
            if (i < 0) sum += i;
        }
        return new int[] {count,sum};
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

        return (Math.round(number*100))/100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {

        int count = 0;
        for (int number : numbers){
            if (number % divider == 0){
                count ++;
            }
        }
        int[] arr = new int[count];
        int i = 0;
        for (int number : numbers){
            if (number % divider == 0){
                arr[i] = number;
                i++;
            }
        }
        return arr;
    }

}
