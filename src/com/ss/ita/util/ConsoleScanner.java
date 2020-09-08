package com.ss.ita.util;

import java.math.BigInteger;

public class ConsoleScanner implements Scanner {

    private java.util.Scanner scanner;

    @Override
    public int readInt() {
        while(true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.out.println("Incorrect format(int). Try again...");
            }
        }
    }

    @Override
    public long readLong() {
        while (true) {
            if (scanner.hasNextLong()) {
                return scanner.nextLong();
            } else {
                scanner.next();
                System.out.println("Incorrect format(long). Try again...");
            }
        }
    }

    @Override
    public int[] readIntArray() {
        while(true) {
            if (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] tokens = str.trim().split("\\s+");
                if (tokens[0].equals("")) {
                    return new int[0];
                }

                int[] array = new int[tokens.length];
                try {
                    for (int i = 0; i < array.length; i++) {
                        array[i] = Integer.parseInt(tokens[i]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect format(int[]). Try again...");
                    continue;
                }
                return array;
            } else {
                System.out.println("Incorrect format(int[]). Try again...");
            }
        }
    }

    @Override
    public float readFloat() {
        while(true) {
            if (scanner.hasNextFloat()) {
                return scanner.nextFloat();
            } else {
                scanner.next();
                System.out.println("Incorrect format(float). Try again...");
            }
        }
    }

    @Override
    public double readDouble() {
        while(true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                scanner.next();
                System.out.println("Incorrect format(double). Try again...");
            }
        }
    }

    @Override
    public double[] readDoubleArray() {
        while(true) {
            if (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] tokens = str.trim().split("\\s+");
                if (tokens[0].equals("")) {
                    return new double[0];
                }
                double[] array = new double[tokens.length];
                try {
                    for (int i = 0; i < array.length; i++) {
                        array[i] = Double.parseDouble(tokens[i]);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect format(double[]). Try again...");
                    continue;
                }
                return array;
            } else {
                System.out.println("Incorrect format(double[]). Try again...");
            }
        }
    }

    @Override
    public String readString() {
        while (true) {
            if (scanner.hasNextLine()) {
                return scanner.nextLine();
            } else {
                System.out.println("Incorrect format(string). Try again...");
            }
        }
    }

    @Override
    public String[] readStringArray() {
        while (true) {
            if (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] strings = str.trim().split("\\s+");
                if (strings[0].equals("")) {
                    return new String[0];
                }

                return strings;
            } else {
                System.out.println("Incorrect format(string[]). Try again...");
            }
        }
    }

    @Override
    public BigInteger readBigInt() {
        while (true) {
            if (scanner.hasNextBigInteger()) {
                return scanner.nextBigInteger();
            } else {
                scanner.next();
                System.out.println("Incorrect format(big integer). Try again...");
            }
        }
    }

    public ConsoleScanner()
    {
        scanner = new java.util.Scanner(System.in);
    }
}
