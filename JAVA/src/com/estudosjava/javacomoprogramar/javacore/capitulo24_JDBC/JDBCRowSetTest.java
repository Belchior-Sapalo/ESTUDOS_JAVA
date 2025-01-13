package com.estudosjava.javacomoprogramar.javacore.capitulo24_JDBC;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class JDBCRowSetTest {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/books";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try(JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet()){
            rowSet.setUrl(DATABASE_URL);
            rowSet.setUsername(USER);
            rowSet.setPassword(PASSWORD);
            rowSet.setCommand("select * from `books`.`autor`");
            rowSet.execute();

            ResultSetMetaData rsmd = rowSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.printf("Authors Table of Books Database:%n%n");

            for (int i = 1; i <= columnCount; i++)
                System.out.printf("%-8s\t", rsmd.getColumnName(i));
            System.out.println();

            while (rowSet.next()) {
                for(int i = 1; i <= columnCount; i++)
                    System.out.printf("%-8s\t", rowSet.getObject(i));
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
