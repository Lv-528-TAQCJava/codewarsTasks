package com.ss.ita.util;

import com.ss.ita.enums.UserNames;
import com.ss.ita.kata.Eight;
import com.ss.ita.kata.Five;
import com.ss.ita.kata.Seven;
import com.ss.ita.kata.Six;

import java.util.Arrays;

public class Runner implements IRunner {
    private Eight Impl8;
    private Seven Impl7;
    private Six Impl6;
    private Five Impl5;
    private Scanner scan;

    public Runner(UserNames whose) {
        scan = new ConsoleScanner();
        setImplementation(whose);
    }

    public Runner() { scan = new ConsoleScanner(); }

    @Override
    public void setImplementation(UserNames whose) {
        switch (whose) {
            case YURIY:
                this.Impl8 = new com.ss.ita.kata.implementation.udzhas.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.udzhas.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.udzhas.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.udzhas.FiveImpl();
                break;
            case RUSLANA:
                this.Impl8 = new com.ss.ita.kata.implementation.rsavu98.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.rsavu98.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.rsavu98.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.rsavu98.FiveImpl();
                break;
            case BORYS:
                this.Impl8 = new com.ss.ita.kata.implementation.meownjik.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.meownjik.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.meownjik.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.meownjik.FiveImpl();
                break;
            case ILONA:
                this.Impl8 = new com.ss.ita.kata.implementation.ilona.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ilona.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ilona.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ilona.FiveImpl();
                break;
            case DENYS:
                this.Impl8 = new com.ss.ita.kata.implementation.DenysSk.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.DenysSk.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.DenysSk.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.DenysSk.FiveImpl();
                break;
            case SOLOMIA:
                this.Impl8 = new com.ss.ita.kata.implementation.solomiazh.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.solomiazh.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.solomiazh.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.solomiazh.FiveImpl();
                break;
            case BOHDAN_H:
                this.Impl8 = new com.ss.ita.kata.implementation.ProstoLeleka.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ProstoLeleka.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ProstoLeleka.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ProstoLeleka.FiveImpl();
                break;
            case BOHDAN_D:
                this.Impl8 = new com.ss.ita.kata.implementation.bodja.EightImplementation();
                this.Impl7 = new com.ss.ita.kata.implementation.bodja.SevenImplementation();
                this.Impl6 = new com.ss.ita.kata.implementation.bodja.SixImplementation();
                this.Impl5 = new com.ss.ita.kata.implementation.bodja.FiveImplementation();
                break;
            default:
                throw new IllegalArgumentException("There is no such author: " + whose);
        }
        System.out.println(whose.getName() + "'s (" + whose.getNick() + ") implementation used.");
    }

    /**
     * Prints prompt before running a task
     * @param name the name of the task
     * @param param the name of parameter for the task (call many times in case many parameters needed)
     * @param type the type of the parameter (integer, float, etc.)
     */
    private void printTaskPrompt(String name, String param, String type) {
        System.out.print("Running \"" + name + "\". Please enter parameter \"" + param + "\" (" + type + "): ");
    }

    /**
     * Keep Hydrated!
     */
    @Override
    public String runTask1() {
        printTaskPrompt("Keep Hydrated!", "liters", "double");
        double input = scan.readDouble();
        String res = String.valueOf(Impl8.liters(input));
        System.out.println(res);
        return res; //in case the result is not only to be printed
    }

    /**
     * Volume of cuboid
     */
    @Override
    public String runTask2() {
        printTaskPrompt("Volume of cuboid", "length", "double");
        double input1 = scan.readDouble();
        printTaskPrompt("Volume of cuboid", "width", "double");
        double input2 = scan.readDouble();
        printTaskPrompt("Volume of cuboid", "height", "double");
        double input3 = scan.readDouble();

        String res = String.valueOf(Impl8.getVolumeOfCuboid(input1, input2, input3));
        System.out.println(res);
        return res;
    }

    /**
     * Miles per gallon to kilometers per liter
     */
    @Override
    public String runTask3() {
        printTaskPrompt("Miles per gallon to kilometers per liter", "miles per gallon", "float");
        float input = scan.readFloat();
        String res = String.valueOf(Impl8.mpgToKPM(input));
        System.out.println(res);
        return res;
    }

    /**
     * To square root or no to square
     */
    @Override
    public String runTask4() {
        printTaskPrompt("To square root or no to square", "array", "int[]");
        int[] input = scan.readIntArray();
        String res = Arrays.toString(Impl8.squareOrSquareRoot(input));
        System.out.println(res);
        return res;
    }

    /**
     * Count of positives / sum of negatives
     */
    @Override
    public String runTask5() {
        printTaskPrompt("Count of positives / sum of negatives", "array", "int[]");
        int[] input = scan.readIntArray();
        String res = Arrays.toString(Impl8.countPositivesSumNegatives(input));
        System.out.println(res);
        return res;
    }

    /**
     * String to number
     */
    @Override
    public String runTask6() {
        printTaskPrompt("String to number", "str", "String");
        String input = scan.readString();
        String res = String.valueOf(Impl8.stringToNumber(input));
        System.out.println(res);
        return res;
    }

    /**
     * Wilson primes
     */
    @Override
    public String runTask7() {
        printTaskPrompt("Wilson primes", "n", "double");
        double input = scan.readDouble();
        String res = String.valueOf(Impl8.amIWilson(input));
        System.out.println(res);
        return res;
    }

    /**
     * Formatting decimal places
     */
    @Override
    public String runTask8() {
        printTaskPrompt("Formatting decimal places", "number", "double");
        double input = scan.readDouble();
        String res = String.valueOf(Impl8.twoDecimalPlaces(input));
        System.out.println(res);
        return res;
    }

    /**
     * Find numbers which are divisible by given number
     */
    @Override
    public String runTask9() {
        return null;
    }

    /**
     * Looking for a benefactor
     */
    @Override
    public String runTask10() {
        return null;
    }

    /**
     * Sum of the first nth term of Series
     */
    @Override
    public String runTask11() {
        return null;
    }

    /**
     * Where is Vasia?
     */
    @Override
    public String runTask12() {
        return null;
    }

    /**
     * Build a pile of Cubes
     */
    @Override
    public String runTask13() {
        return null;
    }

    /**
     * Easy Balance Checking
     */
    @Override
    public String runTask14() {
        return null;
    }

    /**
     * Floating-point Approximation
     */
    @Override
    public String runTask15() {
        return null;
    }

    /**
     * Rainfall
     */
    @Override
    public String runTask16() {
        return null;
    }

    /**
     * Ranking NBA teams
     */
    @Override
    public String runTask17() {
        return null;
    }

    /**
     * Help the bookseller
     */
    @Override
    public String runTask18() {
        return null;
    }

    /**
     * Artificial Rain
     */
    @Override
    public String runTask19() {
        return null;
    }

    /**
     * Gap in Primes
     */
    @Override
    public String runTask20() {
        return null;
    }

    /**
     * Number of trailing zeros of N!
     */
    @Override
    public String runTask21() {
        return null;
    }

    /**
     * Perimeter of squares in a rectangle
     */
    @Override
    public String runTask22() {
        return null;
    }

    /**
     * Which x for that sum
     */
    @Override
    public String runTask23() {
        return null;
    }

    /**
     * Find the smallest
     */
    @Override
    public String runTask24() {
        return null;
    }
}
