package com.example.ratelimiter.model;

public class ManufacturerReport {
    private int idManuafacturer;
    private String name;
    private int year;
    private String country;
    private int phoneId;

    public int getId() {
        return idManuafacturer;
    }

    public void setId(int idManuafacturer) {
        this.idManuafacturer = idManuafacturer;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }
}
