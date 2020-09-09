package com.ss.ita.util;

import com.ss.ita.enums.UserNames;

public class Menu {

    private final Scanner scanner;

    private final IRunner runner;

    public Menu() {
        runner = new Runner();
        scanner = new ConsoleScanner();
    }

    /**
     * Provides list of tasks in the specified kata level
     *
     * @param kata kyu level of kata (from 8 to 5)
     */
    private static String[] tasksList(int kata) {
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
     *
     * @return string with instructions
     */
    private static void printTasks() {
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
        System.out.println(tasksOutput.toString());
    }

    private static void printUserNames() {
        StringBuilder userNamesOutput = new StringBuilder();
        userNamesOutput.append("The following user names are available:\r\n");
        for (UserNames name : UserNames.values()) {
            userNamesOutput.append(name.getId() + " " + name.getName() + " " + name.getNick()  + "\r\n");
        }
        System.out.println(userNamesOutput.toString());
    }

    private void runTask() {
        printTasks();
        System.out.print("Select task to run: ");
        int id;
        do {
            id = scanner.readInt();
        } while (id > 25 || id < 1);

        try {
            switch (id) {
                case 1: runner.runTask1(); break;
                case 2: runner.runTask2(); break;
            }
        } catch (NullPointerException e) {
            System.out.println("Set implementation first!");
        }
    }

    public void run() {
        System.out.println(" 0 - exit\n 1 - show user names\n 2 - set user\n 3 - pick method");
        Scanner scanner = new ConsoleScanner();
        while (true) {
            int id = scanner.readInt();
            switch (id) {
                case 0:
                    return;
                case 1: {
                    printUserNames();
                    break;
                }
                case 2: {
                    setUserImplementation();
                    break;
                }
                case 3: {
                    runTask();
                    break;
                }
            }
            System.out.println(" 0 - exit\n 1 - show user names\n 2 - set user\n 3 - pick method");
        }
    }

    private void setUserImplementation() {
        System.out.print("Select id of user: ");
        UserNames user;
        do {
            printUserNames();
            int id = scanner.readInt();
            user = UserNames.getById(id);
        } while (user.equals(null));

        runner.setImplementation(user);
    }
}
