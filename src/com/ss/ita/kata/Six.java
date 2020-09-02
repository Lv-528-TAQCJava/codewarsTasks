package com.ss.ita.kata;

public interface Six {
    // Keep Hydrated!
    int liters(final double time);

    // Volume of cuboid
    double getVolumeOfCuboid(final double length, final double width, final double height);

    // Miles per gallon to kilometers per liter
    float mpgToKPM(final float mpg);

    // To square root or no to square
    int[] squareOrSquareRoot(final int[] array);

    // Count of positives / sum of negatives
    int[] countPositivesSumNegatives(final int[] input);

    // Convert a String to a Number!
    int stringToNumber(final String str);

    // Wilson primes
    boolean amIWilson(final double n);

    //Formatting decimal places
    double twoDecimalPlaces(final double number);

    // Find numbers which are divisible by given number
    int[] divisibleBy(final int[] numbers, final int divider);
}
