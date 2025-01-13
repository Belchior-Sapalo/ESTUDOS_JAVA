package com.estudosjava.javacomoprogramar.javacore.capitulo24_JDBC;

import java.sql.*;

public class DisplayAutores {
    public static void main(String[] args) {
        final String DATABASE_URL = "jdbc:mysql://localhost:3306/books";
        final String DATABASE_USER = "root";
        final String DATABASE_PASSWORD = "";
        final String SELECT_QUERY = "select id, firstName, lastName from `books`.`autor`";

        try(
                Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
        ){
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            System.out.printf("Authors Table of Books Database:%n%n");

            for (int i = 1; i <= columnCount; i++)
                System.out.printf("%-8s\t", rsmd.getColumnName(i));
            System.out.println();

            while (resultSet.next()) {
                for(int i = 1; i <= columnCount; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                System.out.println();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
