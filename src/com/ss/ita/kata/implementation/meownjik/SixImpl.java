package com.ss.ita.kata.implementation.meownjik;

import com.ss.ita.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SixImpl implements Six {

    @Override
    public long findNb(long m) {
        long leftVol = m;
        long n;
        for(n = 1; leftVol>0; n++)
        {
            leftVol -= n * n * n; //Using Math.pow makes some troubles
        }
        if (leftVol==0)
            return n-1;
        else
            return -1;
    }

    @Override
    public String balance(String book) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(book.split("\n")));
        String origBal = clearUp(list.get(0));
        float curBal = Float.parseFloat(origBal);
        list.remove(0);

        float totalExp = (float) 0.0, avgExp = (float) 0.0;
        int count = 0;

        String res = "Original Balance: " + String.format("%.2f", curBal) + "\\r\\n";
        for (String s: list) {
            count += 1;

            String s1 = clearUp(s);
            List<String> temp = Arrays.asList(s1.split(" "));
            float price = Float.parseFloat(temp.get(temp.size()-1));
            curBal -= price;
            curBal = (float) (Math.round(curBal * 100) / 100.0);

            res += s1 + " Balance " + String.format("%.2f", curBal) + "\\r\\n";
            totalExp += price;
        }
        res = res.replace("  ", " "); //Some tests may fail if not do that
        res += "Total expense  " + String.format("%.2f", totalExp) + "\\r\\n";
        avgExp = (float) (Math.round(totalExp/count * 100) / 100.0);
        res += "Average expense  " + String.format("%.2f", avgExp);// + "\n";
        return  res;
    }
    public String clearUp(String str) {
        String str1 = "";
        for (int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if (!"!@#$%^&*()=-?,:;{}[]".contains(""+cur))
                str1 += cur;
        }
        return str1;
    }

    @Override
    public double f(double x) {
        //(sqrt(1+x)-1)*(sqrt(1+x)+1) = x => sqrt(1+x)-1 = x/(sqrt(1+x) + 1)
        return x/(Math.sqrt(1+x) + 1);
    }

    @Override
    public double mean(String town, String strng) {
        double sum = 0.0;
        int count = 0;
        HashMap<String, String> dict = getDict(strng);
        if (!dict.containsKey(town))
            return -1;
        ArrayList<String> vals = clearUp2(dict.get(town));
        for (String v : vals){
            sum += Double.parseDouble(v);
            count += 1;
        }
        return sum/count;
    }
    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean < 0)
            return mean;

        double sum = 0.0;
        int count = 0;

        HashMap<String, String> dict = getDict(strng);
        ArrayList<String> vals = clearUp2(dict.get(town));
        for (String v : vals){
            sum += Math.pow(mean - Double.parseDouble(v), 2);
            count += 1;
        }
        return sum/count;
    }
    public static HashMap<String, String> getDict(String strng) {
        HashMap<String, String> dict = new HashMap<>();
        List<String> list = Arrays.asList(strng.split("\n"));
        for (String s : list) {
            List<String> cur = Arrays.asList(s.split(":"));
            dict.put(cur.get(0), cur.get(1));
        }

        return dict;
    }
    public static ArrayList<String> clearUp2(String str) {
        String str1 = str;
        String[] months0 = {"Jan ", "Feb ", "Mar ", "Apr ", "May ", "Jun ", "Jul ", "Aug ", "Sep ", "Oct ", "Nov ", "Dec "};
        ArrayList<String> months = new ArrayList<>(Arrays.asList(months0));
        for (String month : months) {
            str1 = str1.replace(month, "");
        }
        ArrayList<String> list = new ArrayList<>(Arrays.asList(str1.split(",")));
        return list;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        HashMap<String, Integer[]> dict;
        try {
            dict = getDict2(resultSheet);
        } catch (IllegalArgumentException er)
        {
            return er.getMessage();
        }
        if ("".equals(toFind))
            return "";
        if (!dict.containsKey(toFind))
            return toFind+":This team didn't play!";
        return showStats(dict, toFind);
    }
    public static ArrayList<String> splitSheet(String resultSheet) {
        return new ArrayList<>(Arrays.asList(resultSheet.split(",")));
    }
    public static ArrayList<String> splitRecord(String record) {
        int indexOfSplit;
        boolean isSpace = false;
        for (indexOfSplit = 0; indexOfSplit < record.length(); indexOfSplit++) {
            if (isSpace && record.charAt(indexOfSplit) == ' ')
            {
                String[] res = {record.substring(0, indexOfSplit), record.substring(indexOfSplit+1)}; //+1 since we have to remove splitting space
                return new ArrayList<>(Arrays.asList(res));
            }
            if (record.charAt(indexOfSplit) == ' ')
            {
                isSpace = true;
                continue;
            }
            if (!"1234567890".contains(""+record.charAt(indexOfSplit))) {
                isSpace = false;
                continue;
            }
        }
        return new ArrayList<>();
    }
    public static HashMap<String, Integer> splitNameAndScore(String halfRecord) {
        int indexOfSplit;
        //System.out.println(halfRecord);
        for (indexOfSplit = halfRecord.length()-1; !(" ".equals(""+halfRecord.charAt(indexOfSplit))); indexOfSplit--) {;}
        //System.out.println(indexOfSplit);
        String name = halfRecord.substring(0, indexOfSplit);
        //System.out.println(name);
        int count;
        try {
            count = Integer.parseInt(halfRecord.substring(indexOfSplit+1)); //+1 since we have to remove splitting space
        } catch (NumberFormatException e) {
            count = -1;
        }
        HashMap<String, Integer> res = new HashMap<>();
        res.put(name, count);
        return res;
    }
    public static HashMap<String, Integer[]> getDict2(String resultSheet) {
        ArrayList<String> records = splitSheet(resultSheet);
        HashMap<String, Integer[]> res = new HashMap<>();
        for (String r : records) {
            ArrayList<String> curRec = splitRecord(r);
            HashMap<String, Integer> vs1;
            HashMap<String, Integer> vs2;
            try {
                vs1 = splitNameAndScore(curRec.get(0));
                vs2 = splitNameAndScore(curRec.get(1));
            } catch (IndexOutOfBoundsException er) {
                System.out.println("I've caught IllegalArgumentException");
                throw new IllegalArgumentException("Error(float number):"+r);
            }

            String name1 = vs1.keySet().iterator().next(); //get "first" (single) elem from set
            Integer score1 = vs1.get(name1);
            String name2 = vs2.keySet().iterator().next(); //get "first" (single) elem from set
            Integer score2 = vs2.get(name2);

            Integer[] temp = new Integer[] {
                    score1 > score2 ? 1 : 0, //wins
                    score1 == score2 ? 1 : 0, //draws
                    score1 < score2 ? 1 : 0, //losses
                    score1, //scored
                    score2, //conceded
                    score1 > score2 ? 3 : (score1 == score2 ? 1 : 0) //points
            };
            if (!res.containsKey(name1))
                res.put(name1, temp);
            else {
                Integer[] updating = res.get(name1);
                for (int i = 0; i < updating.length; i++) {
                    updating[i] += temp[i];
                }
                res.put(name1, updating);
            }

            temp = new Integer[] {
                    score2 > score1 ? 1 : 0, //wins
                    score2 == score1 ? 1 : 0, //draws
                    score2 < score1 ? 1 : 0, //losses
                    score2, //scored
                    score1, //conceded
                    score2 > score1 ? 3 : (score1 == score2 ? 1 : 0) //points
            };
            if (!res.containsKey(name2))
                res.put(name2, temp);
            else {
                Integer[] updating = res.get(name2);
                for (int i = 0; i < updating.length; i++) {
                    updating[i] += temp[i];
                }
                res.put(name2, updating);
            }
        }
        return res;
    }
    public static String showStats(HashMap<String, Integer[]> dict, String name) {
        Integer[] list = dict.get(name);
        return (name + ":" + String.format("W=%s;D=%s;L=%s;Scored=%s;Conceded=%s;Points=%s",
                list[0], list[1],list[2],list[3],list[4],list[5]));
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length<=0 || lstOf1stLetter.length<=0)
            return "";

        String res = "";
        HashMap<String, Integer> dict = getDict3(lstOfArt);
        for(String l : lstOf1stLetter) {
            int count = 0;
            for (String s : dict.keySet()) {
                if(l.equals(s.charAt(0)+"")){
                    count += dict.get(s);
                }
            }
            res += "("+ l + " : " + count + ") - ";
        }
        return res.substring(0, res.length()-3); //truncate final " - "
    }
    public static HashMap<String, Integer> getDict3(String[] lstOfArt) {
        HashMap<String, Integer> res = new HashMap<>();
        for(String s : lstOfArt){
            String[] split = s.split(" ");
            res.put(split[0], Integer.parseInt(split[1]));
        }
        return res;
    }
}
