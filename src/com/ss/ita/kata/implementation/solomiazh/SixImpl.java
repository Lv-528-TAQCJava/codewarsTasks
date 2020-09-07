package com.ss.ita.kata.implementation.solomiazh;

import com.ss.ita.kata.Six;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {

    @Override
    public long findNb(long m) {

        long i = 0;
        long sum = 0;
        while (sum < m) {
            i++;
            sum += i * i * i;
        }
        if (sum == m) return i;
        else return -1;
    }

    @Override
    public String balance(String book) {

        DecimalFormat myFormatter = new DecimalFormat("#.00");
        String clean = book.replaceAll("([^\\n. \\da-zA-Z])", "").replaceAll(" +", " ");
        String[] array = clean.split("[\\n]+");
        double total = 0;
        double balance = Double.parseDouble(array[0]);
        System.out.println(balance);
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(myFormatter.format(balance)).append("\\r\\n");
        for (int i = 1; i < array.length; i++) {
            balance -= Double.parseDouble(array[i].split("\\s+")[2]);
            total += Double.parseDouble(array[i].split("\\s+")[2]);
            String output = myFormatter.format(balance);

            result.append(array[i].trim()).append(" Balance ").append(output).append("\\r\\n");
        }
        String ave = myFormatter.format(total / (array.length - 1));
        return result.append("Total expense  ").append(myFormatter.format(total)).append("\\r\\n").append("Average expense  ").append(ave).toString();
    }


    @Override
    public double f(double x) {

        return x / (1.0 + Math.sqrt((1.0 + x)));
    }

    @Override
    public double mean(String town, String strng) {

        String[] array = strng.split("[\\n]+");
        int i = 0;
        for (; i < array.length; i++) {
            if (array[i].split(":")[0].equals(town)) {
                String str = array[i];
                Pattern pattern = Pattern.compile(" \\d+.\\d+");
                Matcher matcher = pattern.matcher(str);
                double sum = 0;
                while (matcher.find()) {
                    sum += Double.parseDouble(matcher.group());
                }
                return sum / 12;
            }
        }
        return -1;
    }


    @Override
    public double variance(String town, String strng) {
        String[] array = strng.split("[\\n]+");
        int i = 0;
        for (; i < array.length; i++) {
            if (array[i].split(":")[0].equals(town)) {
                String str = array[i];
                Pattern pattern = Pattern.compile(" \\d+.\\d+");
                Matcher matcher = pattern.matcher(str);
                double sum = 0;
                double difference;
                while (matcher.find()) {
                    difference = Double.parseDouble(matcher.group()) - mean(town, strng);
                    sum += difference * difference;
                }
                return sum / 12;
            }
        }
        return -1;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {

        Pattern pattern = Pattern.compile("([\\w\\s]+)\\s(\\d+)\\s([\\w\\s]+)\\s(\\d+)");
        if (toFind.equals("")) return "";
        String[] match = resultSheet.split(",");
        int w = 0;
        int d = 0;
        int l = 0;
        int score = 0;
        int conceded = 0;
        int localSCore;
        int localConceded;
        for (String s : match) {
            if (s.contains(".")) return "Error(float number):" + s;
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                if (matcher.group(1).equals(toFind)) {
                    localSCore = Integer.parseInt(matcher.group(2).trim());
                    localConceded = Integer.parseInt(matcher.group(4).trim());
                    if (localSCore > localConceded) {
                        w++;
                    } else if (localSCore == localConceded) {
                        d++;
                    } else l++;
                    score += localSCore;
                    conceded += localConceded;

                } else if (matcher.group(3).equals(toFind)) {
                    localSCore = Integer.parseInt(matcher.group(4).trim());
                    localConceded = Integer.parseInt(matcher.group(2).trim());
                    if (localSCore > localConceded) {
                        w++;
                    } else if (localSCore == localConceded) {
                        d++;
                    } else l++;
                    score += localSCore;
                    conceded += localConceded;
                }
            }
        }
        if (w == 0 && l == 0 && d == 0) return toFind + ":This team didn't play!";
        int point = w * 3 + d;
        return toFind + ":W=" + w + ";D=" + d + ";L=" + l + ";Scored=" + score + ";Conceded=" + conceded + ";Points=" + point;
    }


    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)  {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (String m : lstOf1stLetter) {
            int temp = 0;
            for (String l : lstOfArt) {
                if (l.charAt(0) == m.charAt(0)) {
                    temp += Integer.parseInt(l.split(" ")[1]);
                }
            }
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(m).append(" : ").append(temp).append(")");
        }
        return result.toString();
    }
}

