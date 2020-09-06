package com.ss.ita.kata.implementation.bodja;

import com.ss.ita.kata.Six;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.HashMap;

public class SixImplementation implements Six {
    @Override
    public long findNb(long m) {
        long n = 1;
        while(true)
        {
            m -= n*n*n;
            if(m == 0)
                return n;
            else if(m < 0)
                return -1;
            else
                n++;
        }
    }

    @Override
    public String balance(String book) {
        String result = "";
        String[] initialLines = book.split("\n");
        java.util.List<String> lines = new java.util.ArrayList<String>();
        //Clearing stings
        for(String str : initialLines)
        {
            String line = str.replaceAll("[^a-zA-Z0-9. ]", "").replaceAll("\\s+"," ").trim();
            if(line.length() != 0)
                lines.add(line);
        }

        double balance = Double.parseDouble(lines.get(0));
        result += "Original Balance: " + lines.get(0) + "\\r\\n";
        double expense = 0;
        for(int i = 1; i < lines.size(); i++)
        {
            String[] tokens = lines.get(i).split(" ");
            double cost = Double.parseDouble(tokens[2]);
            expense += cost;
            balance -= cost;
            result += lines.get(i) + String.format(" Balance %.2f\\r\\n", balance);
        }
        result += "Total expense  " + String.format("%.2f\\r\\n", expense);
        result += "Average expense  " + String.format("%.2f", expense/(lines.size()-1));
        return result;
    }

    @Override
    public double f(double x) {
        BigDecimal d = BigDecimal.ONE.add(BigDecimal.valueOf(x));
        return d.sqrt(new MathContext(32)).subtract(BigDecimal.ONE).doubleValue();
    }

    /**
     * Heplful method for 'mean' and 'variance'
     * @param data
     * @return
     */
    private static double[] getArray(String[] data) {
        double[] arr = new double[12];
        for(int i = 0; i < 12; i++)
            arr[i] = Double.parseDouble(data[2 + i*2]);
        return arr;
    }

    @Override
    public double mean(String town, String strng) {
        String[] lines = strng.split("\n");
        for(String line: lines)
        {
            String[] tokens = line.split("[,: ]");
            if(tokens[0].equals(town))
                return Arrays.stream(getArray(tokens)).sum()/12.0;
        }
        // If town wasn't fond
        return -1;
    }

    @Override
    public double variance(String town, String strng) {
        String[] lines = strng.split("\n");
        for(String line: lines)
        {
            String[] tokens = line.split("[,: ]");
            if(tokens[0].equals(town))
            {
                double[] data = getArray(tokens);
                double variance = 0;
                double mean = mean(town, strng);
                for (double d : data)
                    variance += Math.pow(d - mean, 2);
                return variance/data.length;
            }
        }
        // If town wasn't fond
        return -1;
    }

    /**
     * Helpful method for 'nbaCup'
     * @param match
     * @return
     */
    private static String[] splitMatch(String match) {
        String[] result = new String[] {"", "", "", ""};
        String[] words = match.split(" ");
        int index = 0;
        for(String word : words)
        {
            if(word.matches("[a-zA-Z]+"))
                result[index] += word + " ";
            else if(word.matches("[0-9.]+"))
            {
                result[++index] += word;
                index++;
            }
            else if(word.matches("[a-zA-Z0-9]+"))
                result[index] += word + " ";
        }
        for(int i = 0; i < result.length; i++)
            result[i] = result[i].trim();

        return result;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if(toFind.equals(""))
            return "";

        boolean teamExist = false;
        String[] matches = resultSheet.split(",");

        int victories = 0;
        int draws = 0;
        int defeats = 0;
        int totalScored = 0;
        int totalConceded = 0;

        for(String match : matches)
        {
            String[] tokens = splitMatch(match);
            if(tokens[0].equals(toFind) || tokens[2].equals(toFind))
            {
                teamExist = true;

                int teamIndex = 0; // Skip useless else
                int rivalIndex = 2;
                if(tokens[2].equals(toFind))
                {
                    teamIndex = 2;
                    rivalIndex = 0;
                }

                int scored = 0;
                int conceded = 0;
                try
                {
                    scored = Integer.parseInt(tokens[teamIndex+1]);
                    totalScored += scored;

                    conceded = Integer.parseInt(tokens[rivalIndex+1]);
                    totalConceded += conceded;

                }
                catch(NumberFormatException e)
                {
                    return "Error(float number):" + match;
                }

                if(scored > conceded)
                    victories++;
                else if(scored < conceded)
                    defeats++;
                else
                    draws++;
            }
        }
        if(!teamExist)
            return toFind + ":This team didn't play!";

        int sum = victories*3 + draws;
        return toFind + ":W=" + victories + ";D=" + draws + ";L=" + defeats +
                ";Scored=" + totalScored + ";Conceded=" + totalConceded + ";Points=" + sum;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if(lstOfArt.length == 0 || lstOf1stLetter.length == 0)
            return "";

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for(String art : lstOf1stLetter)
            dict.put(art, 0);

        StringBuilder result = new StringBuilder();
        for(String book : lstOfArt)
            for(String key : dict.keySet())
                if(book.startsWith(key))
                    dict.replace(key, dict.get(key) + Integer.parseInt(book.replaceAll("[^0-9]", "")));

        for(String key : dict.keySet())
            result.append("(" + key + " : " + dict.get(key) + ") - ");

        return result.toString().replaceAll(" - $", "");
    }
}
