package com.revature.cookieTap.models;

public class Level1 {
    private String id;
    private String userId;
    private int score;
    private double time;
    private String date;

    public Level1(String id, String userId, int score, double time, String date) {
        this.id = id;
        this.userId = userId;
        this.score = score;
        this.time = time;
        this.date = date;
    }

    public Level1() {
    }

    @Override
    public String toString() {
        return "Level1{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", score=" + score +
                ", time=" + time +
                ", date='" + date + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
