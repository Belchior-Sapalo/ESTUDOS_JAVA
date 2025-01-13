package com.estudosjava.exercicios.Books_manager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepositoryDB implements BookDAO{
    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/books_manager";
    private final String DATABASE_USER = "root";
    private final String DATABASE_PASSWORD = "";
    private Connection connection;
    private static List<Book> listOfResults;

    public BookRepositoryDB() {
        try {
            connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addBook(Book book) throws SQLException {
        String sql = "INSERT INTO `books_manager`.`book` (`id`, `title`, `author`, `price`) VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "0");
            preparedStatement.setString(2, book.getTitle());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public Book getBook(int id) throws SQLException {
        String sql = "SELECT * FROM `books_manager`.`book` WHERE `id` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Book(
                            resultSet.getInt("id"),
                            resultSet.getString("title"),
                            resultSet.getString("author"),
                            resultSet.getDouble("price")
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {
        String sql = "SELECT id, title, author, price FROM `books_manager`.`book`";
        listOfResults = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listOfResults.add(
                            new Book(
                                    resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("author"),
                                    resultSet.getDouble("price")
                            )
                    );
                }
            }
        }
        return listOfResults;
    }

    @Override
    public void updateBook(Book book) throws SQLException {
        String sql = "UPDATE `books_manager`.`book` SET `title` = ?, `author` = ?, `price` = ? WHERE (`id` = ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.setInt(4, book.getId());
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM `books_manager`.`book` WHERE `id` = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public List<Book> getBooksByAuthorOrTitle(String key) throws SQLException {
        String sql = "SELECT id, title, author, price FROM `books_manager`.`book` WHERE `author` = ? OR `title` = ?";
        listOfResults = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, key);
            preparedStatement.setString(2, key);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    listOfResults.add(
                            new Book(
                                    resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("author"),
                                    resultSet.getDouble("price")
                            )
                    );
                }
            }
        }
        return listOfResults;
    }
}
