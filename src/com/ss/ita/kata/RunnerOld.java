package com.ss.ita.kata;

public class RunnerOld {
    private Eight Impl8;
    private Seven Impl7;
    private Six Impl6;
    private Five Impl5;

    public RunnerOld(String whose) {
        SetImplementation(whose);
    }

    public void SetImplementation(String whose) {
        switch (whose) {
            case "Yuriy":
                System.out.println("Yuriy's (udzhas) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.udzhas.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.udzhas.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.udzhas.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.udzhas.FiveImpl();
                break;
            case "Ruslana":
                System.out.println("Ruslana's (rsavu98) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.rsavu98.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.rsavu98.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.rsavu98.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.rsavu98.FiveImpl();
                break;
            case "Borys":
                System.out.println("Borys' (meownjik) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.meownjik.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.meownjik.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.meownjik.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.meownjik.FiveImpl();
                break;
            case "Ilona":
                System.out.println("Ilona's (ilona) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.ilona.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ilona.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ilona.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ilona.FiveImpl();
                break;
            case "Denys":
                System.out.println("Denys' (DenysSk) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.DenysSk.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.DenysSk.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.DenysSk.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.DenysSk.FiveImpl();
                break;
            case "Solomia":
                System.out.println("Solomia's (solomiazh) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.solomiazh.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.solomiazh.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.solomiazh.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.solomiazh.FiveImpl();
                break;
            case "Bohdan H":
                System.out.println("Bohdan's H. (ProstoLeleka) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.ProstoLeleka.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ProstoLeleka.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ProstoLeleka.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ProstoLeleka.FiveImpl();
                break;
            case "Bohdan D":
                System.out.println("Bohdan's D. (bodja) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.bodja.EightImplementation();
                this.Impl7 = new com.ss.ita.kata.implementation.bodja.SevenImplementation();
                this.Impl6 = new com.ss.ita.kata.implementation.bodja.SixImplementation();
                this.Impl5 = new com.ss.ita.kata.implementation.bodja.FiveImplementation();
                break;
            default:
                System.out.println("There is no such author. Default implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.udzhas.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.udzhas.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.udzhas.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.udzhas.FiveImpl();
                break;

        }
    }

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
    public static String docs() {
        String doc = "The following methods are available:\r\n";
        int count = 0; //The overall number of method/task
        for (int i = 8; i >= 5; i--) {
            doc += "\tFrom the kata of " + i + " kyu:\r\n";
            String[] l = tasksList(i);
            for (int j = 0; j < l.length; j++) {
                doc += "\t\t" + ++count + ". " + l[j] + "\r\n";
            }
        }
        return doc;
    }
}
