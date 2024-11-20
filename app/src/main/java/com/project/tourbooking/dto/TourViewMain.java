package com.project.tourbooking.dto;

public class TourViewMain {
    private String tourName;
    private String companyName;
    private String price;
    private int imageResId;

    public TourViewMain(String tourName, String companyName, String price, int imageResId) {
        this.tourName = tourName;
        this.companyName = companyName;
        this.price = price;
        this.imageResId = imageResId;
    }

    public String getTourName() {
        return tourName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResId() {
        return imageResId;
    }
}
