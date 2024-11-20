package com.project.tourbooking.entity;

public class Company {
    private int id;
    private String name;
    private float rate;
    private int numberRate;

    public Company(int id, String name, float rate, int numberRate) {
        this.id = id;
        this.name = name;
        this.numberRate = numberRate;
        this.rate = rate;
    }
    public Company(String name, float rate, int numberRate) {
        this.name = name;
        this.numberRate = numberRate;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberRate() {
        return numberRate;
    }

    public void setNumberRate(int numberRate) {
        this.numberRate = numberRate;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", rate=" + rate +
                ", numberRate=" + numberRate +
                '}';
    }
}
