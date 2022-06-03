package com.revature.cookieTap.models;

public class User {
    private String id;
    private String username;
    private String oneId;
    private String twoId;
    private String threeId;

    public User(String id, String username, String oneId, String twoId, String threeId) {
        this.id = id;
        this.username = username;
        this.oneId = oneId;
        this.twoId = twoId;
        this.threeId = threeId;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOneId() {
        return oneId;
    }

    public void setOneId(String oneId) {
        this.oneId = oneId;
    }

    public String getTwoId() {
        return twoId;
    }

    public void setTwoId(String twoId) {
        this.twoId = twoId;
    }

    public String getThreeId() {
        return threeId;
    }

    public void setThreeId(String threeId) {
        this.threeId = threeId;
    }
}
