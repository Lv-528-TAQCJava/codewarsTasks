package com.ss.ita.kata.implementation.ProstoLeleka;

public class SixImpl implements Six {
    @Override
    public long findNb(long m){
        long sum = 0;
        long n = 0;
        while (sum < m) {
            n++;
            sum += n*n*n;
        }
        if (sum == m) {
            return n;
        } else {
            return -1;
        }
    }

    @Override
    public static String balance(String book) {
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("[\\n]+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: " + arr[0]);
        for (int i = 1; i < arr.length; i++) {
            count++;
            String[] line = arr[i].split("[ ]+");
            current -= Double.parseDouble(line[2]);
            total += Double.parseDouble(line[2]);
            String u = String.format("\\r\\n%s %s %s Balance %.2f", line[0], line[1], line[2], current);
            result.append(u);
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", total, total / count));
        return result.toString();
    }

        public static double f(double x) {
            return x / (1 + Math.sqrt(1 + x));
        }

}
