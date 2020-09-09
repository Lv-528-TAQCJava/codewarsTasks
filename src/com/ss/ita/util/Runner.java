package com.ss.ita.util;

import com.ss.ita.enums.UserNames;
import com.ss.ita.enums.UserNicks;
import com.ss.ita.kata.Eight;
import com.ss.ita.kata.Five;
import com.ss.ita.kata.Seven;
import com.ss.ita.kata.Six;

public class Runner implements IRunner {
    private Eight Impl8;
    private Seven Impl7;
    private Six Impl6;
    private Five Impl5;

    public Runner(UserNames whose) {
        setImplementation(whose);
    }

    public Runner() { }

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
        System.out.println(whose.getName() + "'s (" + UserNicks.values()[whose.ordinal()].getName() + ") implementation used.");
    }

    /**
     * Keep Hydrated!
     */
    @Override
    public String runTask1() {
        return  String.valueOf(Impl8.liters(8));
    }

    /**
     * Volume of cuboid
     */
    @Override
    public String runTask2() {
        return null;
    }

    /**
     * Miles per gallon to kilometers per liter
     */
    @Override
    public String runTask3() {
        return null;
    }

    /**
     * To square root or no to square
     */
    @Override
    public String runTask4() {
        return null;
    }

    /**
     * Count of positives / sum of negatives
     */
    @Override
    public String runTask5() {
        return null;
    }

    /**
     * String to number
     */
    @Override
    public String runTask6() {
        return null;
    }

    /**
     * Wilson primes
     */
    @Override
    public String runTask7() {
        return null;
    }

    /**
     * Formatting decimal places
     */
    @Override
    public String runTask8() {
        return null;
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
