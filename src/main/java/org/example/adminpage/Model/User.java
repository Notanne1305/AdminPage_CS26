package org.example.adminpage.Model;

public class User {

    private int userId;
    private String username;
    private String email;
    private String password;

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId(){
        return userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}
