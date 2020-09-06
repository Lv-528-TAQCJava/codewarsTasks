package com.ss.ita.kata;

/**
 * For kata of 6 kyu
 */
public interface Six {

    /**
     * Build a pile of Cubes
     * @param m
     * @return
     */
    long findNb(long m);

    /**
     * Easy Balance Checking
     * @param book
     * @return
     */
    String balance(String book);

    /**
     * Floating-point Approximation
     * @param x
     * @return
     */
    double f(double x);

    /**
     * Rainfall(mean)
     * @param town
     * @param strng
     * @return
     */
    double mean(String town, String strng);

    /**
     * Rainfall(variance)
     * @param town
     * @param strng
     * @return
     */
    double variance(String town, String strng);

    /**
     * Ranking NBA teams
     * @param resultSheet
     * @param toFind
     * @return
     */
    String nbaCup(String resultSheet, String toFind);

    /**
     * Help the bookseller
     * @param lstOfArt
     * @param lstOf1stLetter
     * @return
     */
    String stockSummary(String[] lstOfArt, String[] lstOf1stLetter);

}
