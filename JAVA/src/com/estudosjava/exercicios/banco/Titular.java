package com.estudosjava.exercicios.banco;

import java.util.ArrayList;

public class Titular {
    private String firtName;
    private String lastName;
    private String BI;

    public Titular(String firtName, String lastName, String BI) {
        this.firtName = firtName;
        this.lastName = lastName;
        this.BI = BI;
    }

    public String getFirtName() {
        return firtName;
    }

    public void setFirtName(String firtName) {
        this.firtName = firtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBI() {
        return BI;
    }

    public void setBI(String BI) {
        this.BI = BI;
    }

    @Override
    public String toString(){
        return String.format(
                "%s %s (%s)",
                getFirtName(),
                getLastName(),
                getBI()
        );
    }
}
