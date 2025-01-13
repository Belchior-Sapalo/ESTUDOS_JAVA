package com.estudosjava.exercicios.Library_manager_app.repository;

import com.estudosjava.exercicios.Library_manager_app.models.UserModel;
import com.estudosjava.exercicios.Library_manager_app.models.UserRoleEnum;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private Connection connection;

    public UserRepository(String db_url, String db_user, String db_pass) throws SQLException {
        connection = DriverManager.getConnection(db_url, db_user, db_pass);
    }

    public void signIn(UserModel user) throws SQLException {
        String sql = "INSERT INTO `library_manager_app`.`user` (`id`, `username`, `useremail`, `pass`, `role`) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getRole().getValue());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public UserModel logIn(String email, String pass) throws SQLException {
        String sql = "SELECT `id`, `username`, `useremail`, `pass`, `role` FROM `library_manager_app`.`user` WHERE `useremail` = ? AND `pass` = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int role = rs.getInt("role");
                UserModel user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("useremail"),
                        rs.getString("pass"),
                        choiseRole(role)
                );
                return user;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public UserModel getUserById(int id) throws SQLException {
        String sql = "SELECT `id`, `username`, `useremail`, `pass`, `role` FROM `library_manager_app`.`user` WHERE `id` = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int role = rs.getInt("role");
                UserRoleEnum userRole = UserRoleEnum.CLIENT;
                switch (role) {
                    case 1:
                        userRole = UserRoleEnum.ADMIN;
                        break;
                    case 2:
                        userRole = UserRoleEnum.CLIENT;
                        break;
                }
                UserModel user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("useremail"),
                        rs.getString("pass"),
                        userRole
                );
                return user;
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return null;
    }

    public List<UserModel> getUserByUserName(String username) throws SQLException {
        String sql = "SELECT `id`, `username`, `useremail`, `pass`, `role` FROM `library_manager_app`.`user` WHERE `username` = ?";
        List<UserModel> listOfResults = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int role = rs.getInt("role");
                UserModel user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("useremail"),
                        rs.getString("pass"),
                        choiseRole(role)
                );
                listOfResults.add(user);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return listOfResults;
    }


    public List<UserModel> getAllUsers() throws SQLException {
        String sql = "SELECT `id`, `username`, `useremail`, `pass`, `role` FROM `library_manager_app`.`user`";
        List<UserModel> listOfResults = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int role = rs.getInt("role");
                UserModel user = new UserModel(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("useremail"),
                        rs.getString("pass"),
                        choiseRole(role)
                );
                listOfResults.add(user);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return listOfResults;
    }

    private UserRoleEnum choiseRole(int roleValue){
        UserRoleEnum userRole = UserRoleEnum.CLIENT;
        switch (roleValue) {
            case 1:
                userRole = UserRoleEnum.ADMIN;
                break;
            case 2:
                userRole = UserRoleEnum.CLIENT;
                break;
        }
        return userRole;
    }
}
