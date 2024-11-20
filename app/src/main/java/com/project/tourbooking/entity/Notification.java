package com.project.tourbooking.entity;

import java.util.Date;

public class Notification {
    private int id;
    private Date announceDate;
    private int idTourBooking;

    public Notification(int id, Date announceDate, int idTourBooking) {
        this.id = id;
        this.announceDate = announceDate;
        this.idTourBooking = idTourBooking;
    }

    public Notification(Date announceDate, int idTourBooking) {
        this.announceDate = announceDate;
        this.idTourBooking = idTourBooking;
    }

    public Date getAnnounceDate() {
        return announceDate;
    }

    public void setAnnounceDate(Date announceDate) {
        this.announceDate = announceDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTourBooking() {
        return idTourBooking;
    }

    public void setIdTourBooking(int idTourBooking) {
        this.idTourBooking = idTourBooking;
    }


}
