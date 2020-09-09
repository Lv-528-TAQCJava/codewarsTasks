package com.ss.ita.enums;

public enum UserNicks {
    YURIY("udzhas"),
    RUSLANA("rsavu98"),
    BORYS("meownjik"),
    ILONA("ilona"),
    DENYS("DenysSk"),
    SOLOMIA("solomiazh"),
    BOHDAN_H("ProstoLeleka"),
    BOHDAN_D("bodja");

    private String name;

    UserNicks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
