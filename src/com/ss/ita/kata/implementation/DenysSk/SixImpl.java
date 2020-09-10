package com.ss.ita.kata.implementation.DenysSk;

import com.ss.ita.kata.Six;

import java.text.DecimalFormat;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long n;
        for(n = 1; m > 0; n++) {
            m =- (long)Math.pow(n,3);
        }
        if(m == 0) return n-1;
        else return -1;
    }

    @Override
    public String balance(String book) {
        DecimalFormat myFormatter = new DecimalFormat("#.00");
        String clean = book.replaceAll("([^\\n. \\da-zA-Z])", "").replaceAll(" +", " ");
        String[] arr = clean.split("[\\n]+");
        double total = 0;
        double balance = Double.parseDouble(arr[0]);
        System.out.println(balance);

        StringBuilder res = new StringBuilder();
        res.append("Initial Balance: ").append(myFormatter.format(balance)).append("\\r\\n");
        for (int i = 1; i < arr.length; i++)
        {
            balance -= Double.parseDouble(arr[i].split("\\s+")[2]);
            total += Double.parseDouble(arr[i].split("\\s+")[2]);
            String output = myFormatter.format(balance);
            res.append(arr[i].trim()).append(" Balance ").append(output).append("\\r\\n");
        }
        String av = myFormatter.format(total / (arr.length - 1));
        return res.append("Total expense  ").append(myFormatter.format(total)).append("\\r\\n").append("Average expense  ").append(av).toString();
    }

    @Override
    public double f(double x) {
        return x / (1.0 + Math.sqrt((1.0 + x)));
    }

    @Override
    public double mean(String town, String strng) {
        double sum = 0.0;
        String[] townRecords = null;
        String[] data = strng.split("\n");
        for(String str : data){
            if (str.startsWith(town)){
                townRecords = str.replaceAll("[a-zA-Zа-яА-Я]|\\:", "").split(",");
            }
        }
        if (townRecords == null || townRecords.length == 0) {
            return -1;
        }
        for(String record : townRecords) {
            sum += Double.parseDouble(record);
        }
        return sum / 12;
    }

    @Override
    public double variance(String town, String strng) {
        double sum = 0;
        String[] townRecords = null;
        String[] data = strng.split("\n");
        for(String str : data){
            if (str.startsWith(town)){
                townRecords = str.replaceAll("[a-zA-Zа-яА-Я]|\\:", "").split(",");
            }
        }
        if (townRecords == null || townRecords.length == 0) {
            return -1;
        }
        for(String records : townRecords) {
            sum += Double.parseDouble(records);
        }
        double avr = sum / 12;
        sum = 0;
        for(String record : townRecords){
            sum += Math.pow(Double.parseDouble(record) - avr, 2);
        }
        double result = Math.sqrt(sum / 12);
        return result * result;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return null;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        String result = "";
        for (String n : lstOf1stLetter) {
            int tmp = 0;
            for (String l : lstOfArt) {
                if (l.charAt(0) == n.charAt(0)) {
                    tmp += Integer.parseInt(l.split(" ")[1]);
                }
            }
            if (!result.isEmpty()) {
                result += " - ";
            }
            result += "(" + n + " : " + tmp + ")";
        }
        return result;
    }
}
