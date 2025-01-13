package com.estudosjava.javacomoprogramar.javacore.capitulo10_Polimorfismo_Interface.Binterfaces.classes;

public class Date {
    private int month;
    private int day;
    private int year;

    private static final int[] daysPerMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(int month, int day, int year) {
        if(month <= 0 || month > 12)
            throw new IllegalArgumentException("Invalid month");
        if(day <= 0 || day > daysPerMonth[month] && !(month == 2 && day == 29))
            // verifique no ano bissexto se o mês é 2 e o dia é 29
        if((month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))))
            throw new IllegalArgumentException("Invalid year");
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }


}
