package com.ss.ita.kata.implementation.ProstoLeleka;

import com.ss.ita.kata.Six;

import static java.util.stream.Stream.of;

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


    public String balance(String book) {
        String t = book.replaceAll("([^\\n. \\da-zA-Z])", "");
        String[] arr = t.split("[\\n]+");
        double current = Double.parseDouble(arr[0]);
        double total = 0;
        int count = 0;
        StringBuilder result = new StringBuilder();
        result.append("Original Balance: ").append(arr[0]);
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

        public  double f(double x) {
            return x / (1 + Math.sqrt(1 + x));
        }

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
    public double variance(String town, String strng) {
        if (town == null || town.length() == 0 || strng == null || strng.length() == 0) return -1;
        final String t = town + ":";
        final String[] a = strng.split("\n");
        String[] recs = null;
        double[] vals;
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


   public String nbaCup(String resultSheet, String toFind){
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


  public   String  stockSummary(String[] lstOfArt, String[] lstOf1stLetter){
      int sum = 0;
      boolean hasRunOnce = false;
      StringBuilder stock = new StringBuilder();
      for (String s : lstOf1stLetter) {
          for (int j = 0; j < lstOfArt.length; j++) {
              if (s.charAt(0) == lstOfArt[j].charAt(0)) {
                  sum += Integer.parseInt(lstOfArt[j].substring(lstOfArt[j].indexOf(" ") + 1));
              }
              if (j == lstOfArt.length - 1) {
                  if (!hasRunOnce) {
                      stock.append("(").append(s).append(" : ").append(sum).append(")");
                      sum = 0;
                      hasRunOnce = true;
                  } else {
                      stock.append(" - (").append(s).append(" : ").append(sum).append(")");
                      sum = 0;
                  }
              }
          }
      }
      return stock.toString();
  }

}
