package com.ss.ita.util;

import com.ss.ita.enums.UserNames;
import com.ss.ita.kata.Eight;
import com.ss.ita.kata.Five;
import com.ss.ita.kata.Seven;
import com.ss.ita.kata.Six;

import java.math.BigInteger;
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
        String input;
        String res;
        while (true) {
            input = scan.readString();
            try {
                res = String.valueOf(Impl8.stringToNumber(input));
                break;
            } catch (NumberFormatException exception) {
                System.out.println("Input again");
            }
        }
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
        printTaskPrompt("Find numbers which are divisible by given number", "numbers", "int[]");
        int[] input1 = scan.readIntArray();
        printTaskPrompt("Find numbers which are divisible by given number", "divider", "int");
        int input2 = scan.readInt();
        String res = Arrays.toString(Impl8.divisibleBy(input1, input2));
        System.out.println(res);
        return res;
    }

    /**
     * Looking for a benefactor
     */
    @Override
    public String runTask10() {
        printTaskPrompt("Looking for a benefactor", "array", "double[]");
        double[] input1 = scan.readDoubleArray();
        printTaskPrompt("Looking for a benefactor", "new average", "double");
        double input2 = scan.readDouble();
        String res = String.valueOf(Impl7.newAvg(input1, input2));
        System.out.println(res);
        return res;
    }

    /**
     * Sum of the first nth term of Series
     */
    @Override
    public String runTask11() {
        printTaskPrompt("Sum of the first nth term of Series", "n", "integer");
        int input = scan.readInt();
        String res = String.valueOf(Impl7.seriesSum(input));
        System.out.println(res);
        return res;
    }

    /**
     * Where is Vasia?
     */
    @Override
    public String runTask12() {
        printTaskPrompt("Where is Vasia?", "position", "integer");
        int input1 = scan.readInt();
        printTaskPrompt("Where is Vasia?", "before", "integer");
        int input2 = scan.readInt();
        printTaskPrompt("Where is Vasia?", "after", "integer");
        int input3 = scan.readInt();
        String res = String.valueOf(Impl7.whereIsHe(input1, input2, input3));
        System.out.println(res);
        return res;
    }

    /**
     * Build a pile of Cubes
     */
    @Override
    public String runTask13() {
        printTaskPrompt("Build a pile of Cubes", "m", "long");
        long input = scan.readLong();
        String res = String.valueOf(Impl6.findNb(input));
        System.out.println(res);
        return res;
    }

    /**
     * Easy Balance Checking
     */
    @Override
    public String runTask14() {
        printTaskPrompt("Easy Balance Checking", "book", "String");
        System.out.println("Format:\n 1000.00\\n" +
                "125 Market 125.45\\n" +
                "126 Hardware 34.95");
        String input = scan.readString();
        String res = String.valueOf(Impl6.balance(input));
        System.out.println(res);
        return res;
    }

    /**
     * Floating-point Approximation
     */
    @Override
    public String runTask15() {
        printTaskPrompt("Floating-point Approximation", "x", "double");
        double input = scan.readDouble();
        String res = String.valueOf(Impl6.f(input));
        System.out.println(res);
        return res;
    }

    /**
     * Rainfall
     */
    @Override
    public String runTask16() {
        printTaskPrompt("Rainfall", "town", "String");
        String input1 = scan.readString();
        printTaskPrompt("Rainfall", "stats", "String");
        System.out.println("Format:\n" +
                "Rome:Jan 81.2,Feb 63.2,Mar 70.3,Apr 55.7,May 53.0,Jun 36.4,Jul 17.5,Aug 27.5,Sep 60.9,Oct 117.7,Nov 111.0,Dec 97.9");
        String input2 = scan.readString();

        String res1 = String.valueOf(Impl6.mean(input1, input2));
        String res2 = String.valueOf(Impl6.variance(input1, input2));
        System.out.println("mean: " + res1 + "; variance: " + res2);
        return res1 + " " + res2;
    }

    /**
     * Ranking NBA teams
     */
    @Override
    public String runTask17() {
        printTaskPrompt("Ranking NBA teams", "result sheet", "String");
        System.out.println("Format:\n" +
                "Los Angeles Clippers 104 Dallas Mavericks 88,New York Knicks 101 Atlanta Hawks 112,Indiana Pacers 103 Memphis Grizzlies 112");
        String input1 = scan.readString();
        printTaskPrompt("Ranking NBA teams", "to find", "String");
        String input2 = scan.readString();
        String res = String.valueOf(Impl6.nbaCup(input1, input2));
        System.out.println(res);
        return res;
    }

    /**
     * Help the bookseller
     */
    @Override
    public String runTask18() {
        printTaskPrompt("Help the bookseller", "list of articles", "String[]");
        System.out.println("Format:\nABAR 200");
        String[] input1 = scan.readStringArray();
        printTaskPrompt("Help the bookseller", "list of 1st letter", "String[]");
        String[] input2 = scan.readStringArray();
        String res = String.valueOf(Impl6.stockSummary(input1, input2));
        System.out.println(res);
        return res;
    }

    /**
     * Artificial Rain
     */
    @Override
    public String runTask19() {
        printTaskPrompt("Artificial Rain", "array", "int[]");
        int[] input = scan.readIntArray();
        String res = String.valueOf(Impl5.artificialRain(input));
        System.out.println(res);
        return res;
    }

    /**
     * Gap in Primes
     */
    @Override
    public String runTask20() {
        printTaskPrompt("Gap in Primes", "gap", "int");
        int input1 = scan.readInt();
        printTaskPrompt("Gap in Primes", "m", "long");
        long input2 = scan.readLong();
        printTaskPrompt("Gap in Primes", "n", "long");
        long input3 = scan.readLong();
        String res = Arrays.toString(Impl5.gap(input1, input2, input3));
        System.out.println(res);
        return res;
    }

    /**
     * Number of trailing zeros of N!
     */
    @Override
    public String runTask21() {
        printTaskPrompt("Number of trailing zeros of N!", "n", "integer");
        int input = scan.readInt();
        String res = String.valueOf(Impl5.zeros(input));
        System.out.println(res);
        return res;
    }

    /**
     * Perimeter of squares in a rectangle
     */
    @Override
    public String runTask22() {
        printTaskPrompt("Perimeter of squares in a rectangle", "n", "BigInteger");
        BigInteger input = scan.readBigInt();
        String res = String.valueOf(Impl5.perimeter(input));
        System.out.println(res);
        return res;
    }

    /**
     * Which x for that sum
     */
    @Override
    public String runTask23() {
        printTaskPrompt("Which x for that sum", "m", "double");
        double input = scan.readDouble();
        String res = String.valueOf(Impl5.solveSum(input));
        System.out.println(res);
        return res;
    }

    /**
     * Find the smallest
     */
    @Override
    public String runTask24() {
        printTaskPrompt("Find the smallest", "n", "long");
        long input = scan.readLong();
        String res = Arrays.toString(Impl5.smallest(input));
        System.out.println(res);
        return res;
    }
}
