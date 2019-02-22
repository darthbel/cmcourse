package com.felipebelgine.cmcourse.enums;

public enum PaymentStatus {

    PENDING(1, "Pending"),
    DONE(2, "Done"),
    CANCELED(3, "Canceled");

    private int cod;
    private String desc;

    PaymentStatus(int cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public int getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }

    public static PaymentStatus toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }

        for (PaymentStatus x : PaymentStatus.values()) {
            if(cod.equals(x.getCod())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + cod);
    }
}
