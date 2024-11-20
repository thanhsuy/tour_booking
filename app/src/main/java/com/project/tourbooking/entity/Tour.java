package com.project.tourbooking.entity;

import java.util.Date;

public class Tour {
    private int id;
    private String nameTour;
    private float price;
    private String describe;
    private String service;
    private String picture1;
    private String picture2;
    private String picture3;
    private String picture4;
    private Date startDate;
    private Date endDate;
    private String location;
    private String city;
    private String lat;
    private String ing;
    private byte numberPassengerLeft;
    private int idCompany;

    public Tour(int idTour, String nameTour, float price, String describe, String service, String picture1,
                String picture2, String picture3, String picture4, Date startDate, Date endDate,
                String location, String city, String lat, String ing, byte numberPassengerLeft, int idCompany) {
        this.describe = describe;
        this.endDate = endDate;
        this.idCompany = idCompany;
        this.id = idTour;
        this.ing = ing;
        this.lat = lat;
        this.location = location;
        this.city = city;
        this.nameTour = nameTour;
        this.numberPassengerLeft = numberPassengerLeft;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.picture4 = picture4;
        this.price = price;
        this.service = service;
        this.startDate = startDate;
    }

    public Tour(String nameTour, float price, String describe, String service, String picture1,
                String picture2, String picture3, String picture4, Date startDate, Date endDate,
                String location, String city, String lat, String ing, byte numberPassengerLeft, int idCompany) {
        this.describe = describe;
        this.endDate = endDate;
        this.idCompany = idCompany;
        this.ing = ing;
        this.lat = lat;
        this.location = location;
        this.city = city;
        this.nameTour = nameTour;
        this.numberPassengerLeft = numberPassengerLeft;
        this.picture1 = picture1;
        this.picture2 = picture2;
        this.picture3 = picture3;
        this.picture4 = picture4;
        this.price = price;
        this.service = service;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "describe='" + describe + '\'' +
                ", idTour=" + id +
                ", nameTour='" + nameTour + '\'' +
                ", price=" + price +
                ", service='" + service + '\'' +
                ", picture1='" + picture1 + '\'' +
                ", picture2='" + picture2 + '\'' +
                ", picture3='" + picture3 + '\'' +
                ", picture4='" + picture4 + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", location='" + location + '\'' +
                ", city='" + city + '\'' +
                ", lat='" + lat + '\'' +
                ", ing='" + ing + '\'' +
                ", numberPassengerLeft=" + numberPassengerLeft +
                ", idCompany=" + idCompany +
                '}';
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNameTour() {
        return nameTour;
    }

    public void setNameTour(String nameTour) {
        this.nameTour = nameTour;
    }

    public byte getNumberPassengerLeft() {
        return numberPassengerLeft;
    }

    public void setNumberPassengerLeft(byte numberPassengerLeft) {
        this.numberPassengerLeft = numberPassengerLeft;
    }

    public String getPicture1() {
        return picture1;
    }

    public void setPicture1(String picture1) {
        this.picture1 = picture1;
    }

    public String getPicture2() {
        return picture2;
    }

    public void setPicture2(String picture2) {
        this.picture2 = picture2;
    }

    public String getPicture3() {
        return picture3;
    }

    public void setPicture3(String picture3) {
        this.picture3 = picture3;
    }

    public String getPicture4() {
        return picture4;
    }

    public void setPicture4(String picture4) {
        this.picture4 = picture4;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
