package com.ss.ita.kata;

public class Runner {
    private Eight Impl8;
    private Seven Impl7;
    private Six Impl6;
    private Five Impl5;

    public Runner(String whose) {
        switch (whose) {
            case "Yuriy":
                System.out.println("Yuriy's (udzhas) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.udzhas.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.udzhas.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.udzhas.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.udzhas.FiveImpl();
            case "Ruslana":
                System.out.println("Ruslana's (rsavu98) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.rsavu98.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.rsavu98.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.rsavu98.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.rsavu98.FiveImpl();
            case "Borys":
                System.out.println("Borys' (meownjik) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.meownjik.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.meownjik.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.meownjik.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.meownjik.FiveImpl();
            case "Ilona":
                System.out.println("Ilona's (ilona) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.ilona.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ilona.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ilona.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ilona.FiveImpl();
            case "Denys":
                System.out.println("Denys' (DenysSk) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.DenysSk.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.DenysSk.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.DenysSk.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.DenysSk.FiveImpl();
            case "Solomia":
                System.out.println("Solomia's (solomiazh) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.solomiazh.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.solomiazh.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.solomiazh.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.solomiazh.FiveImpl();
            case "Bohdan H":
                System.out.println("Bohdan's H. (ProstoLeleka) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.ProstoLeleka.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.ProstoLeleka.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.ProstoLeleka.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.ProstoLeleka.FiveImpl();
            case "Bohdan D":
                System.out.println("Bohdan's D. (bodja) implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.bodja.EightImplementation();
                this.Impl7 = new com.ss.ita.kata.implementation.bodja.SevenImplementation();
                this.Impl6 = new com.ss.ita.kata.implementation.bodja.SixImplementation();
                this.Impl5 = new com.ss.ita.kata.implementation.bodja.FiveImplementation();
            default:
                System.out.println("There is no such author. Default implementation used.");
                this.Impl8 = new com.ss.ita.kata.implementation.udzhas.EightImpl();
                this.Impl7 = new com.ss.ita.kata.implementation.udzhas.SevenImpl();
                this.Impl6 = new com.ss.ita.kata.implementation.udzhas.SixImpl();
                this.Impl5 = new com.ss.ita.kata.implementation.udzhas.FiveImpl();

        }
    }
}
