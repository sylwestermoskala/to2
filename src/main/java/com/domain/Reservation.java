package com.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {

    @Id
    private int routenumber;

    private int distance;
    private String start_location;
    private String end_location;

    public Reservation() {
    }

    public Reservation(int routenumber, int distance, String start_location, String end_location) {
        this.routenumber = routenumber;
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }

    public Reservation(int distance, String start_location, String end_location) {
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }


    public int getRoutenumber() {
        return routenumber;
    }

    public void setRoutenumber(int routenumber) {
        this.routenumber = routenumber;
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
}
