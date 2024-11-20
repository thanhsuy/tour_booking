package com.project.tourbooking.entity;

public class TourBooking {
    int id;
    String nameCustomer;
    String address;
    String phone;
    String email;
    byte numberPassenger;
    String status;
    String note;
    int numberAmount;
    int idTour;

    public TourBooking(int id, String nameCustomer, String address, String phone, String email,
                       byte numberPassenger, String status, String note, int numberAmount, int idTour) {
        this.address = address;
        this.email = email;
        this.id = id;
        this.idTour = idTour;
        this.nameCustomer = nameCustomer;
        this.note = note;
        this.numberAmount = numberAmount;
        this.numberPassenger = numberPassenger;
        this.phone = phone;
        this.status = status;
    }

    public TourBooking(String nameCustomer, String address, String phone, String email,
                       byte numberPassenger, String status, String note, int numberAmount, int idTour) {
        this.address = address;
        this.email = email;
        this.idTour = idTour;
        this.nameCustomer = nameCustomer;
        this.note = note;
        this.numberAmount = numberAmount;
        this.numberPassenger = numberPassenger;
        this.phone = phone;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TourBooking{" +
                "address='" + address + '\'' +
                ", id=" + id +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", numberPassenger=" + numberPassenger +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", numberAmount=" + numberAmount +
                ", idTour=" + idTour +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getNumberAmount() {
        return numberAmount;
    }

    public void setNumberAmount(int numberAmount) {
        this.numberAmount = numberAmount;
    }

    public byte getNumberPassenger() {
        return numberPassenger;
    }

    public void setNumberPassenger(byte numberPassenger) {
        this.numberPassenger = numberPassenger;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
