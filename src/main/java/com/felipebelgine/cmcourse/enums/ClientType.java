package com.felipebelgine.cmcourse.enums;

public enum ClientType {

    NATURALPERSON(1, "Natural Person"),
    LEGALPERSON(2, "Legal Person");

    private int cod;
    private String desc;

    ClientType(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static ClientType toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (ClientType x : ClientType.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + cod);
    }
}
