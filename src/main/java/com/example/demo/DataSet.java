package com.example.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalTime;

public class DataSet {


    private int id;
    private double heartBeatRate;
    private double bloodOxygenConcentration;
    private int signalStrength;
    private double acceleration;
    private double altitude;
    private double longitude;
    private double latitude;

    private Timestamp uTCTimeStamp;
    private int satellite;

    public double getHeartBeatRate() {
        return heartBeatRate;
    }

    public void setHeartBeatRate(double heartBeatRate) {
        this.heartBeatRate = heartBeatRate;
    }

    public double getBloodOxygenConcentration() {
        return bloodOxygenConcentration;
    }

    public void setBloodOxygenConcentration(double bloodOxygenConcentration) {
        this.bloodOxygenConcentration = bloodOxygenConcentration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }

    public int getSatellite() {
        return satellite;
    }

    public void setSatellite(int satellite) {
        this.satellite = satellite;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Timestamp getuTCTimeStamp() {
        return uTCTimeStamp;
    }

    public void setuTCTimeStamp(Timestamp uTCTimeStamp) {
        this.uTCTimeStamp = uTCTimeStamp;
    }
}
