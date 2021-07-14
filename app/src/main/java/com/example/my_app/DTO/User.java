package com.example.my_app.DTO;

public class User {
    private String name;
    private String email;
    private String mobieBumber;
    private String password;

    public User(String name, String email, String mobieBumber, String password) {
        this.name = name;
        this.email = email;
        this.mobieBumber = mobieBumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobieBumber() {
        return mobieBumber;
    }

    public void setMobieBumber(String mobieBumber) {
        this.mobieBumber = mobieBumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
