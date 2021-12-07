package com.example.ratelimiter.model;

public class PhoneReport {
    private int idPhone;
    private String name;
    private int year;
    private int count;
    private String description;

    public int getId() {
        return idPhone;
    }

    public void setId(int idPhone) {
        this.idPhone = idPhone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
