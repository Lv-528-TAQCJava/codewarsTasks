package com.ss.ita.enums;

public enum UserNames {
    YURIY(1L, "Yuriy", "udzhas"),
    RUSLANA(2L, "Ruslana", "rsavu98"),
    BORYS(3L, "Borys", "meownjik"),
    ILONA(4L, "Ilona", "ilona"),
    DENYS(5L, "Denys", "DenysSk"),
    SOLOMIA(6L, "Solomia", "solomiazh"),
    BOHDAN_H(7L, "Bohdan H", "ProstoLeleka"),
    BOHDAN_D(8L, "Bohdan D", "bodja");

    private final String name;

    private final Long id;

    private final String nick;

    UserNames(Long id, String name, String nick) {
        this.name = name;
        this.id = id;
        this.nick = nick;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getNick() {
        return nick;
    }

    public static UserNames getById(int id) {
        for(UserNames user : values()) {
            if(user.id.equals(id))
                return user;
        }
        return null;
    }
}
