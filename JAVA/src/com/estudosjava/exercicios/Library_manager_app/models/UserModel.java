package com.estudosjava.exercicios.Library_manager_app.models;

public class UserModel {
    private int id;
    private String username;
    private String email;
    private String password;
    private UserRoleEnum role;

    public UserModel(int id, String username, String email, String password, UserRoleEnum role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    public String toString(){
        return String.format("User: %s, %s: %s, %s: %s, %s: %s", this.getId(), "Name", this.getUsername(), "Email", this.getEmail(), "Role", this.getRole());
    }
}
