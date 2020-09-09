package com.ss.ita.kata.implementation.udzhas;
import static java.util.stream.Stream.of;
import com.ss.ita.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        int n = 0;
        do {
            m = m - (long) Math.pow(n++ + 1d, 3d);
        } while (m > 0);
        return (m == 0) ? n : -1;
    }

    @Override
    public String balance(String book) {
        StringBuilder result = new StringBuilder();
        String[] splittedBook = book.replaceAll("[^a-zA-Z0-9 \\n.]","").replaceAll(" {2,}", " ").split("\n");
        double balance = Double.parseDouble(splittedBook[0]);
        double expense = 0;
        result.append("Original Balance: ").append(String.format("%1$.2f", balance)).append("\\r\\n");
        for(int i = 1; i < splittedBook.length; i++) {
            String[] splittedItem = splittedBook[i].split(" ");
            double itemExpense = Double.parseDouble(splittedItem[splittedItem.length - 1]);
            balance -= itemExpense;
            expense += itemExpense;
            result.append(splittedBook[i].trim()).append(" Balance ").append(String.format("%1$.2f", balance)).append("\\r\\n");
        }
        result.append("Total expense  ").append(String.format("%1$.2f", expense)).append("\\r\\n");
        result.append("Average expense  ").append(String.format("%1$.2f", expense / (splittedBook.length - 1)));

        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        if (town == null || town.length() == 0 || strng == null || strng.length() == 0) return -1;
        final String t = town + ":";
        final String[] a = strng.split("\n");
        String[] recs = null;
        int l;
        double sum = 0;

        for (String str : a) {
            if (str.startsWith(t)) {
                recs = str.split(":")[1].split(",");
                break;
            }
        }
        if (recs == null || recs.length == 0) return -1;

        l = recs.length;
        for (int i = 0; i < l; i++) {
            sum += Double.parseDouble(recs[i].split(" ")[1]);
        }

        return sum / l;
    }

    @Override
    public double variance(String town, String strng) {
        if (town == null || town.length() == 0 || strng == null || strng.length() == 0) return -1;
        final String t = town + ":";
        final String[] a = strng.split("\n");
        String[] recs = null;
        double[] vals = null;
        int l;
        double temp;
        double sum = 0;

        for (String str : a) {
            if (str.startsWith(t)) {
                recs = str.split(":")[1].split(",");
                break;
            }
        }
        if (recs == null || recs.length == 0) return -1;

        l = recs.length;
        vals = new double[l];
        for (int i = 0; i < l; i++) {
            vals[i] = temp = Double.parseDouble(recs[i].split(" ")[1]);
            sum += temp;
        }

        temp = sum / l;
        sum = 0;
        for (int i = 0; i < l; i++) {
            sum += Math.pow(vals[i] - temp, 2);
        }
        temp = Math.sqrt(sum / l);

        return temp * temp;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        int wins = 0, losses = 0, draws = 0, scored = 0, conceded = 0;
        for (String match : of(resultSheet.split(",")).filter(s -> s.contains(toFind)).toArray(String[]::new)) {
            if (match.contains(".")) {
                return "Error(float number):" + match;
            }

            String[] teams = match.substring(0, match.lastIndexOf(' ')).replaceAll(" \\d+ ", "@").split("@");
            if (teams[0].equals(toFind) || teams[1].equals(toFind)) {

                int pointsA = Integer.parseInt(match.substring(match.lastIndexOf(' ') + 1));
                int pointsB = Integer.parseInt(match.substring(teams[0].length() + 1, match.indexOf(teams[1]) - 1));
                if (match.startsWith(toFind)) {
                    int temp = pointsA;
                    pointsA = pointsB;
                    pointsB = temp;
                }

                scored += pointsA;
                conceded += pointsB;

                if (pointsA > pointsB) {
                    wins++;
                } else if (pointsA < pointsB) {
                    losses++;
                } else {
                    draws++;
                }
            }
        }
        return toFind + (scored + conceded > 0 ? ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + (3 * wins + draws) : ":This team didn't play!");
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)  {
            return "";
        }
        String result = "";
        for (String m : lstOf1stLetter) {
            int temp = 0;
            for (String l : lstOfArt) {
                if (l.charAt(0) == m.charAt(0)) {
                    temp += Integer.parseInt(l.split(" ")[1]);
                }
            }
            if (!result.isEmpty()) {
                result += " - ";
            }
            result += "(" + m + " : " + temp + ")";
        }
        return result;
    }
}
