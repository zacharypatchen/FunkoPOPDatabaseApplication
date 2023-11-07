package com.example.funkopopdatabaseapplication;

public class FunkoPOPItem {
    private int id;
    private String popName;
    private int popNumber;
    private String popType;
    private String fandom;
    private boolean on;
    private String ultimate;
    private double price;

    // Constructor
    public FunkoPOPItem(int id, String popName, int popNumber, String popType,
                        String fandom, boolean on, String ultimate, double price) {
        this.id = id;
        this.popName = popName;
        this.popNumber = popNumber;
        this.popType = popType;
        this.fandom = fandom;
        this.on = on;
        this.ultimate = ultimate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getPopName() {
        return popName;
    }

    public int getPopNumber() {
        return popNumber;
    }

    public String getPopType() {
        return popType;
    }

    public String getFandom() {
        return fandom;
    }

    public boolean isOn() {
        return on;
    }

    public String getUltimate() {
        return ultimate;
    }

    public double getPrice() {
        return price;
    }
}
