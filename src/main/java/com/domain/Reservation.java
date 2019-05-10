package com.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    private int id;
    private String date;
    private int distance;
    private String start_location;
    private String end_location;

    public Reservation() {
    }

    public Reservation(int id, String date, int distance, String start_location, String end_location) {
        this.id = id;
        this.date = date;
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }

    public Reservation(String date, int distance, String start_location, String end_location) {
        this.date = date;
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getStart_location() {
        return start_location;
    }

    public void setStart_location(String start_location) {
        this.start_location = start_location;
    }

    public String getEnd_location() {
        return end_location;
    }

    public void setEnd_location(String end_location) {
        this.end_location = end_location;
    }

//    @Id
//    private String id;
//
//    private String distance;
//    private String start_location;
//    private String end_location;
//
//    public Reservation() {
//    }
//
//    public Reservation(String id, String distance, String start_location, String end_location) {
//        this.id = id;
//        this.distance = distance;
//        this.start_location = start_location;
//        this.end_location = end_location;
//    }
//
//    public Reservation(String distance, String start_location, String end_location) {
//        this.distance = distance;
//        this.start_location = start_location;
//        this.end_location = end_location;
//    }
//
//
//    public String getRoutenumber() {
//        return id;
//    }
//
//    public void setRoutenumber(String routenumber) {
//        this.id = routenumber;
//    }
//
//    public String getDistance() {
//        return distance;
//    }
//
//    public void setDistance(String distance) {
//        this.distance = distance;
//    }
//
//    public String getStart_location() {
//        return start_location;
//    }
//
//    public void setStart_location(String start_location) {
//        this.start_location = start_location;
//    }
//
//    public String getEnd_location() {
//        return end_location;
//    }
//
//    public void setEnd_location(String end_location) {
//        this.end_location = end_location;
//    }
}
