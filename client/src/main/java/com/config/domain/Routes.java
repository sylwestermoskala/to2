package com.config.domain;


import java.sql.Date;

public class Routes{

    private int id;
    private int distance;
    private String start_location;
    private String end_location;

    public Routes() {
    }

    public Routes(int distance, String start_location, String end_location) {
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
