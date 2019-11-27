package com.iotsensors.lab2.model;

import java.sql.Time;
import java.util.Date;

public class Sensor {

    private String id;
    private String name;
    private String type;
    private Date date;
    private Time time;
    private float lat;
    private float lng;
    private String measurement;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    @Override
    public String toString() {
        return "SensorController{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", lat=" + lat +
                ", lng=" + lng +
                ", measurement='" + measurement + '\'' +
                '}';
    }
}
