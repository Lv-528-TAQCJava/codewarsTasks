package com.ss.ita.kata;


/**
 * For kata of 8 kyu
 */
public interface Eight {
    /**
     * For mpgToKPM method
     */
    double LITRES_IN_GALLON = 4.54609188;
    double KILOMETRES_IN_MILE = 1.609344;

    /**
     * Keep Hydrated!
     *
     * @param time
     * @return
     */
    int liters(final double time);

    /**
     * Volume of cuboid
     *
     * @param length
     * @param width
     * @param height
     * @return
     */
    double getVolumeOfCuboid(final double length, final double width, final double height);

    /**
     * Miles per gallon to kilometers per liter
     *
     * @param mpg
     * @return
     */
    float mpgToKPM(final float mpg);

    /**
     * To square root or no to square
     *
     * @param array
     * @return
     */
    int[] squareOrSquareRoot(final int[] array);

    /**
     * Count of positives / sum of negatives
     *
     * @param input
     * @return
     */
    int[] countPositivesSumNegatives(final int[] input);

    /**
     * @param str
     * @return
     */
    int stringToNumber(final String str);

    /**
     * Wilson primes
     *
     * @param n
     * @return
     */
    boolean amIWilson(final double n);

    /**
     * Formatting decimal places
     *
     * @param number
     * @return
     */
    double twoDecimalPlaces(final double number);

    /**
     * Find numbers which are divisible by given number
     *
     * @param numbers
     * @param divider
     * @return
     */
    int[] divisibleBy(final int[] numbers, final int divider);

}
