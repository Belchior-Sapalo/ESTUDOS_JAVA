package com.estudosjava.exercicios.Library_manager_app.repository;

import com.estudosjava.exercicios.Library_manager_app.models.BookModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private Connection connection;

    public BookRepository(String db_url, String db_user, String db_pass) throws SQLException {
        connection = DriverManager.getConnection(db_url, db_user, db_pass);
    }

    public void addBook(BookModel book) throws SQLException {
        String sql = "INSERT INTO `library_manager_app`.`book` (`id`, `title`, `author`, `price`, `availability`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, book.getId());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setDouble(4, book.getPrice());
            ps.setBoolean(5, book.getAvailability());
            ps.executeUpdate();
        }
    }

    public BookModel getBookById(int id) throws SQLException {
        String sql = "SELECT `id`, `title`, `author`, `price`, `availability` FROM `library_manager_app`.`book` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new BookModel(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getBoolean("availability")
                );
            }
        }
        return null;
    }

    public List<BookModel> getBookByTitleOrAuthor(String key) throws SQLException {
        String sql = "SELECT `id`, `title`, `author`, `price`, `availability` FROM `library_manager_app`.`book` WHERE title = ? OR author = ?";
        List<BookModel> listOfResults = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, key);
            ps.setString(2, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookModel book = new BookModel(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getBoolean("availability")
                );
                listOfResults.add(book);
            }
            return listOfResults;
        }
    }

    public List<BookModel> getAllBooks() throws SQLException {
        String sql = "SELECT `id`, `title`, `author`, `price`, `availability` FROM `library_manager_app`.`book`";
        List<BookModel> listOfResults = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BookModel book = new BookModel(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getDouble("price"),
                        rs.getBoolean("availability")
                );
                listOfResults.add(book);
            }
            return listOfResults;
        }
    }

    public void updateBook(BookModel book) throws SQLException {
        String sql = "UPDATE `library_manager_app`.`book` SET `title` = ?, `author` = ?, `price` = ?, `availability` = ? WHERE (`id` = ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setDouble(3, book.getPrice());
            ps.setBoolean(4, book.getAvailability());
            ps.setInt(5, book.getId());
            ps.executeUpdate();
        }
    }

    public void deleteBook(int id) throws SQLException {
        String sql = "DELETE FROM `library_manager_app`.`book` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}
