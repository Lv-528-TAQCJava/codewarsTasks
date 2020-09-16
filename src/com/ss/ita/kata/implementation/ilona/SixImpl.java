package com.ss.ita.kata.implementation.ilona;

import com.ss.ita.kata.Six;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long total = 0;
        while (total < m) {
            n++;
            total += n * n * n;
        }
        return total == m ? n : -1;
    }

    @Override
    public String balance(String book) {
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

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return values(town, strng).stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(-1);
    }

    @Override
    public double variance(String town, String strng) {
        double theMean = mean(town, strng);

        return values(town, strng).stream()
                .map(d -> Math.pow(d - theMean, 2))
                .mapToDouble(Double::doubleValue)
                .average().orElse(-1);
    }

    public static List<Double> values(String town, String strng) {
        Optional<String> line = Arrays.stream(strng.split("\n"))
                .filter(s -> s.startsWith(town + ":"))
                .findAny();

        if (line.isPresent()) {
            String myline = line.get().substring(line.get().indexOf(":") + 1);
            return Arrays.stream(myline.split(","))
                    .map(s -> s.substring(s.indexOf(" ")))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
        } else {
            return new LinkedList<Double>();
        }
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        List<String> games = stream(resultSheet.split(",")).filter(x -> x.contains(toFind + " ")).collect(Collectors.toList());
        if (toFind.isEmpty()) {
            return "";
        }
        if (games.isEmpty()) {
            return toFind + ":This team didn't play!";
        }
        List<String[]> teams = games.stream().map(game -> game.split("\\s\\d+(\\W|$)")).collect(Collectors.toList());
        List<Integer[]> scores = games.stream()
                .map(game -> stream(game.split(" "))
                        .filter(x -> x.matches("\\d+"))
                        .map(Integer::valueOf).toArray(Integer[]::new))
                .collect(Collectors.toList());
        int wins = 0, draws = 0, lose = 0, scored = 0, conceded = 0, points = 0;
        for (int i = 0; i < teams.size(); i++) {
            try {
                boolean draw = scores.get(i)[0] == scores.get(i)[1];
            } catch (ArrayIndexOutOfBoundsException e) {
                return "Error(float number):" + games.get(i);
            }
            boolean teamFirst = teams.get(i)[0].equals(toFind);
            if (teamFirst) {
                scored += scores.get(i)[0];
                conceded += scores.get(i)[1];
            } else {
                scored += scores.get(i)[1];
                conceded += scores.get(i)[0];
            }
            if (scores.get(i)[0] == scores.get(i)[1]) {
                draws++;
                points++;
            } else if (scores.get(i)[0] < scores.get(i)[1]) {
                if (teamFirst) {
                    lose++;
                } else {
                    wins++;
                    points += 3;
                }
            } else {
                if (teamFirst) {
                    wins++;
                    points += 3;
                } else {
                    lose++;
                }
            }
        }
        return String.format(toFind + ":W=%s;D=%s;L=%s;Scored=%s;Conceded=%s;Points=%s",
                wins, draws, lose, scored, conceded, points);
    }


    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        int sum = 0;
        boolean hasRunOnce = false;
        String stock = "";
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            for (int j = 0; j < lstOfArt.length; j++) {
                if (lstOf1stLetter[i].charAt(0) == lstOfArt[j].charAt(0)) {
                    sum += Integer.parseInt(lstOfArt[j].substring(lstOfArt[j].indexOf(" ") + 1));
                }
                if (j == lstOfArt.length - 1) {
                    if (!hasRunOnce) {
                        stock += "(" + lstOf1stLetter[i] + " : " + sum + ")";
                        sum = 0;
                        hasRunOnce = true;
                    } else {
                        stock += " - (" + lstOf1stLetter[i] + " : " + sum + ")";
                        sum = 0;
                    }
                }
            }
        }
        return stock;
    }
}
