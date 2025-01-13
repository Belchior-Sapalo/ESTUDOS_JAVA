package com.estudosjava.exercicios.Library_manager_app.repository;

import com.estudosjava.exercicios.Library_manager_app.models.LoanModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanRepository {
    private Connection connection;

    public LoanRepository(String db_url, String db_user, String db_pass) throws SQLException {
        connection = DriverManager.getConnection(db_url, db_user, db_pass);
    }

    public void addLoan(LoanModel loanModel) throws SQLException {
        String sql = "INSERT INTO `library_manager_app`.`loan` (`id`, `userId`, `bookId`, `loanDate`, `returnDate`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, loanModel.getId());
            ps.setInt(2, loanModel.getUserId());
            ps.setInt(3, loanModel.getBookId());
            ps.setDate(4, loanModel.getLoanDate());
            ps.setDate(5, loanModel.getReturnDate());
            ps.executeUpdate();
        }
    }

    public List<LoanModel> getAllLoans() throws SQLException {
        String sql = "SELECT `id`, `userId`, `bookId`, `loanDate`, `returnDate` FROM `library_manager_app`.`loan`";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<LoanModel> listOfResults = new ArrayList<>();
            while (rs.next()) {
                LoanModel loan =  new LoanModel(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getInt("bookId"),
                        rs.getDate("loanDate"),
                        rs.getDate("returnDate")
                );
                listOfResults.add(loan);
            }
            return listOfResults;
        }
    }

    public LoanModel getLoan(int id) throws SQLException {
        String sql = "SELECT `id`, `userId`, `bookId`, `loanDate`, `returnDate` FROM `library_manager_app`.`loan` WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return new LoanModel(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getInt("bookId"),
                        rs.getDate("loanDate"),
                        rs.getDate("returnDate")
                );
            }
        }
        return null;
    }

    public List<LoanModel> getLoanByUser(int id) throws SQLException {
        String sql = "SELECT `id`, `userId`, `bookId`, `loanDate`, `returnDate` FROM `library_manager_app`.`loan` WHERE userId = ?";
        List<LoanModel> listOfResult = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LoanModel loan = new LoanModel(
                        rs.getInt("id"),
                        rs.getInt("userId"),
                        rs.getInt("bookId"),
                        rs.getDate("loanDate"),
                        rs.getDate("returnDate")
                );
                listOfResult.add(loan);
            }
            return listOfResult;
        }
    }

    public boolean returnLoan(int id) throws SQLException {
        String sql = "UPDATE `library_manager_app`.`loan` SET `returnDate` = ? WHERE (`id` = ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setDate(1, new java.sql.Date(System.currentTimeMillis()));
            ps.setInt(2, id);
            int changed = ps.executeUpdate();
            return changed > 0 ? true : false;
        }
    }
}
