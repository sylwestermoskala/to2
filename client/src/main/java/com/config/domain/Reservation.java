package com.config.domain;

public class Reservation {


//    private Integer id;
    private int id;
    private String date;
    private int distance;
    private String start_location;
    private String end_location;

    public Reservation() {
    }

    public Reservation(int id, String date, int distance, String start_location, String end_location) {
        this.id = id;
        this.date=date;
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }

    public Reservation(String date, int distance, String start_location, String end_location) {
        this.date=date;
        this.distance = distance;
        this.start_location = start_location;
        this.end_location = end_location;
    }

//    @JsonIgnore
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }


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

}
