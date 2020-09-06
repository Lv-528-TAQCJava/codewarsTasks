package com.ss.ita.kata.implementation.bodja;

import com.ss.ita.kata.Eight;
import java.util.Arrays;
import java.math.BigInteger;

public class EightImplementation implements Eight {

    @Override
    public int liters(double time) {
        return (int)(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        double mpgToKPMcoef = KILOMETRES_IN_MILE / LITRES_IN_GALLON;

        return (float)(Math.round((mpg * mpgToKPMcoef)*100)/100.0);
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for(int i = 0; i < array.length; i++)
        {
            double sqrt = Math.sqrt(array[i]);
            array[i] = (sqrt%1 == 0) ? (int)sqrt : array[i] * array[i];
        }

        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0)
            return new int[0];
        else {
            int[] res = new int[2];
            for (int i : input) {
                if (i > 0)
                    res[0]++;
                else
                    res[1] += i;
            }

            return res;
        }
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public boolean amIWilson(double n) {
        if(n%1 != 0 || n == 1)
            return false;

        BigInteger value = factorial((int)n - 1).add(BigInteger.ONE);
        return value.mod(BigInteger.valueOf((int) (n * n))).compareTo(BigInteger.ZERO) == 0;
    }

    private static BigInteger factorial(int number)
    {
        BigInteger res = BigInteger.ONE;
        while(number > 1)
            res = res.multiply(BigInteger.valueOf(number--));

        return res;
    }

    @Override
    public double twoDecimalPlaces(double number) {
        number*= 100;
        number = Math.round(number);
        number = number/100;

        return number;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        int[] res = new int[numbers.length];
        int index = 0;
        for(int i : numbers)
            if(i % divider == 0)
                res[index++] = i;

        return Arrays.copyOf(res, index);
    }
}
