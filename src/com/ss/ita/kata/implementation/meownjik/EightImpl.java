package com.ss.ita.kata.implementation.meownjik;

import com.ss.ita.kata.Eight;

import java.math.BigDecimal;
import java.util.ArrayList;
import static java.lang.Integer.parseInt;

public class EightImpl implements Eight {
    public static final double EPSILON = 1e-10; //For comparing double

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
        //ml / g => km / l
        double res = mpg / LITRES_IN_GALLON * KILOMETRES_IN_MILE;
        return (float) Math.round(res * 100)/100;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] res = new int[array.length];
        for(int i = 0; i<array.length; i++){
            double root = Math.sqrt(array[i]);
            if (Math.abs(root - (int) root) < EPSILON){
                res[i] = (int) root;
            }
            else {
                res[i] = (int) Math.pow(array[i], 2);
            }
        }
        return res;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length < 1)
            return new int[] {};
        int[] res = {0, 0};
        int countPos = 0, sumNeg = 0;
        for (int i = 0; i < input.length; i++)
        {
            if (input[i] > 0)
                countPos += 1;
            else
                sumNeg += input[i];
        }
        res[0] = countPos;
        res[1] = sumNeg;
        return res;
    }

    @Override
    public int stringToNumber(String str) {
        return parseInt(str); //no need to reinvent the wheel
    }

    @Override
    public boolean amIWilson(double n) {
        int p = (int) n;
        if (p<=1)
            return false;
        return (((factorial(new BigDecimal(p-1)).add(BigDecimal.ONE))
                .remainder(new BigDecimal(p*p)))
                .compareTo(BigDecimal.ZERO) == 0);
    }

    public static BigDecimal factorial(BigDecimal n) {
        if (n==BigDecimal.ZERO || n==BigDecimal.ONE)
            return BigDecimal.ONE;
        else {
            return n.multiply(factorial(n.subtract(BigDecimal.ONE)));
        }
    }

    @Override
    public double twoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] % divider == 0)
                res.add(numbers[i]);
        int[] res2 = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            res2[i] = res.get(i);
        return res2;
    }
}
