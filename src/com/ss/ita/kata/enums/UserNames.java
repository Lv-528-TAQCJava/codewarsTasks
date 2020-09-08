package com.ss.ita.kata.enums;

public enum UserNames {
    YURIY("Yuriy"),
    RUSLANA("Ruslana"),
    BORYS("Borys"),
    ILONA("Ilona"),
    DENYS("Denys"),
    SOLOMIA("Solomia"),
    BOHDAN_H("Bohdan H"),
    BOHDAN_D("Bohdan D");

    private String name;

    UserNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
