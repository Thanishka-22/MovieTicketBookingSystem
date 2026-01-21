package com.wipro.mbs.entity;

public class User {
    private String userId;
    private String name;
    private String contactNumber;

    public User(String userId, String name, String contactNumber) {
        this.userId = userId;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getUserId() {
        return userId;
    }
}
