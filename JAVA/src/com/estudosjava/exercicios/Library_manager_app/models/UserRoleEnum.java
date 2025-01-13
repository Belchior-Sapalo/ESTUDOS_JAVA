package com.estudosjava.exercicios.Library_manager_app.models;

public enum UserRoleEnum {
    ADMIN(1), CLIENT(2);
    private int value;

    UserRoleEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
