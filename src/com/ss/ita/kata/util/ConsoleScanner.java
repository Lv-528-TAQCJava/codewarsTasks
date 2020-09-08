package com.ss.ita.kata.util;

import java.io.IOException;
import java.math.BigInteger;

public class ConsoleScanner implements Scanner {

    private java.util.Scanner scanner;

    @Override
    public int getInt() throws IOException {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            scanner.next();
            throw new IOException("Input string in wrong format(int)");
        }
    }

    @Override
    public long getLong() throws IOException {
        if(scanner.hasNextLong()) {
            return scanner.nextLong();
        } else {
            scanner.next();
            throw new IOException("Input string in wrong format(long)");
        }
    }

    @Override
    public int[] getIntArray() throws IOException {
        if(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] tokens = str.trim().split("\\s+");
            if(tokens[0].equals("")) {
                return new int[0];
            }

            int[] array = new int[tokens.length];
            try {
                System.out.println(tokens.length);
                for(int i = 0; i < array.length; i++) {
                    array[i] = Integer.parseInt(tokens[i]);
                }
            } catch (NumberFormatException e) {
                throw new IOException("Input string in wrong format(int[])");
            }
            return  array;
        } else {

            throw new IOException("Input string in wrong format(int[])");
        }
    }

    @Override
    public float getFloat() throws IOException {
        if(scanner.hasNextFloat()) {
            return scanner.nextFloat();
        } else {
            scanner.next();
            throw new IOException("Input string in wrong format(float)");
        }
    }

    @Override
    public double getDouble() throws IOException {
        if(scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            scanner.next();
            throw new IOException("Input string in wrong format(double)");
        }
    }

    @Override
    public double[] getDoubleArray() throws IOException {
        if(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] tokens = str.trim().split("\\s+");
            if(tokens[0].equals("")) {
                return new double[0];
            }
            double[] array = new double[tokens.length];
            try {
                for(int i = 0; i < array.length; i++) {
                    array[i] = Double.parseDouble(tokens[i]);
                }
            } catch (NumberFormatException e) {
                throw new IOException("Input string in wrong format(double[])");
            }
            return  array;
        } else {
            throw new IOException("Input string in wrong format(double[])");
        }
    }

    @Override
    public String getString() throws IOException {
        if(scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            throw new IOException("Input string in wrong format(string)");
        }
    }

    @Override
    public String[] getStringArray() throws IOException {
        if(scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String[] strings = str.trim().split("\\s+");
            if(strings[0].equals("")) {
                return new String[0];
            }

            return  strings;
        } else {
            throw new IOException("Input string in wrong format(string)");
        }
    }

    @Override
    public BigInteger getBigInt() throws IOException {
        if(scanner.hasNextBigInteger()) {
            return scanner.nextBigInteger();
        } else {
            scanner.next();
            throw new IOException("Input string in wrong format(big integer)");
        }
    }

    public ConsoleScanner()
    {
        scanner = new java.util.Scanner(System.in);
    }
}
