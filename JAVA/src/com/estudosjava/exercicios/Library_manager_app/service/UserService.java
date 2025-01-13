package com.estudosjava.exercicios.Library_manager_app.service;

import com.estudosjava.exercicios.Library_manager_app.models.UserModel;
import com.estudosjava.exercicios.Library_manager_app.repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signIn(UserModel user) throws SQLException {
        userRepository.signIn(user);
    }

    public UserModel login(String email, String pass) throws SQLException {
        return userRepository.logIn(email, pass);
    }

    public List<UserModel> getUserByUserName(String username) throws SQLException {
        return userRepository.getUserByUserName(username);
    }

    public UserModel getUserById(int id) throws SQLException {
        return userRepository.getUserById(id);
    }

    public List<UserModel> getAllUsers() throws SQLException {
        return userRepository.getAllUsers();
    }
}
