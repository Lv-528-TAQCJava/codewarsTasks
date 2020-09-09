package com.ss.ita.util;
import com.ss.ita.enums.UserNames;

public class Menu {
    /**
     * Provides list of tasks in the specified kata level
     * @param kata kyu level of kata (from 8 to 5)
     */
    public static String[] tasksList(int kata) {
        switch (kata) {
            case 8:
                return new String[]{
                        "Keep Hydrated!",
                        "Volume of a cuboid",
                        "Miles per gallon to kilometers per liter",
                        "To square root or no to square",
                        "Count of positives / sum of negatives",
                        "Convert a String to a Number!",
                        "Willson primes",
                        "Formatting decimal places",
                        "Find numbers which are divisible by given number"
                };

            case 7:
                return new String[]{
                        "Looking for a benefactor",
                        "Sum of the first nth term of Series",
                        "Where is Vasya?"
                };
            case 6:
                return new String[]{
                        "Build a pile of Cubes",
                        "Easy balance checking",
                        "Floating-point Approximation (I)",
                        "Rainfall",
                        "Ranking NBA",
                        "Help the bookseller!"
                };
            case 5:
                return new String[]{
                        "Artificial Rain",
                        "Gap in Primes",
                        "Trailing zeros in factorial",
                        "Perimeter of squares in a rectangle",
                        "Which x for that sum?",
                        "Find the smallest"
                };
            default:
                return new String[]{};
        }
    }
    /**
     * Provides instructions on usage
     * @return string with instructions
     */
    public static String getTasks() {
        StringBuilder tasksOutput = new StringBuilder();
        tasksOutput.append("The following methods are available:\r\n");
        int count = 0; //The overall number of method/task
        for (int i = 8; i >= 5; i--) {
            tasksOutput.append("\tFrom the kata of " + i + " kyu:\r\n");
            String[] l = tasksList(i);
            for (int j = 0; j < l.length; j++) {
                tasksOutput.append("\t\t" + ++count + ". " + l[j] + "\r\n");
            }
        }
        return tasksOutput.toString();
    }

    public static String getUserNames(){
        StringBuilder userNamesOutput = new StringBuilder();
        userNamesOutput.append("The following user names are available:\r\n");
        for(UserNames name : UserNames.values())
        {
            userNamesOutput.append(name.getName() + "\r\n");
        }
        return userNamesOutput.toString();
    }

}
