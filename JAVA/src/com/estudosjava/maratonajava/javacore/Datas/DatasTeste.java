package com.estudosjava.maratonajava.javacore.Datas;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatasTeste {
    public static void main(String[] args) {

        Calendar c = Calendar.getInstance();
        DateFormat[] dformat = new DateFormat[6];
        dformat[0] = DateFormat.getInstance();
        dformat[1] = DateFormat.getDateInstance();
        dformat[2] = DateFormat.getDateInstance(DateFormat.SHORT);
        dformat[3] = DateFormat.getDateInstance(DateFormat.LONG);
        dformat[4] = DateFormat.getDateInstance(DateFormat.FULL);
        dformat[5] = DateFormat.getDateInstance(DateFormat.MEDIUM);

        for(DateFormat df : dformat) {
            System.out.println(df.format(c.getTime()));
        }

    }
}
