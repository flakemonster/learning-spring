package com.rmkbom.lil.learningspring.data;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RESERVATION")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESERVATION_ID")
    private Long reservationId;

    @Column(name = "ROOM_ID")
    private Long roomID;

    @Column(name = "GUEST_ID")
    private Long guestId;

    @Column(name = "RES_DATE")
    private Date date;

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getRoomID() {
        return roomID;
    }

    public void setRoomID(Long roomID) {
        this.roomID = roomID;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", roomID='" + roomID + '\'' +
                ", guestId='" + guestId + '\'' +
                ", date=" + date +
                '}';
    }

}
