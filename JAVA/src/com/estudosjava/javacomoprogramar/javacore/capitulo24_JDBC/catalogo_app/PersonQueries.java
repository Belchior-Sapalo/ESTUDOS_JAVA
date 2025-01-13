package com.estudosjava.javacomoprogramar.javacore.capitulo24_JDBC.catalogo_app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/addressBook";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private Connection connection;
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    public PersonQueries() {
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            selectAllPeople = connection.prepareStatement("SELECT * FROM Addresses");
            selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Addresses WHERE lastName = ?");
            insertNewPerson = connection.prepareStatement("INSERT INTO Addresses (firstName, lastName, email, phoneNumber) VALUES (?, ?, ?, ?)");
        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    public List<Person> getAllPeople(){
        List<Person> results = null;
        ResultSet resultSet = null;

        try {
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<Person>();

            while (resultSet.next()){
                results.add( new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
                close();
            }
        }

        return results;
    }

    public List<Person> getPeopleByLastName(String lastName){
        List<Person> results = null;
        ResultSet resultSet = null;

        try {
            selectPeopleByLastName.setString(1, lastName);
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList<>();

            while (resultSet.next()){
                results.add( new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("email"),
                        resultSet.getString("phoneNumber")
                ));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
                close();
            }
        }
        return results;
    }

    public int insertNewPerson(String firstName, String lastName, String email, String phoneNumber){
        int result = 0;

        try {
            insertNewPerson.setString(1, firstName);
            insertNewPerson.setString(2, lastName);
            insertNewPerson.setString(3, email);
            insertNewPerson.setString(4, phoneNumber);
            result = insertNewPerson.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            close();
        }
        return result;
    }

    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
