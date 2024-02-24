package com.example.demo;

import java.sql.Timestamp;

public class CamelRaceModel {

    private double heartBeatRate;
    private double bloodOxygenConcentration;
    private double temperature;
    private double signalStrength;
    private double acceleration;
    private double magneticOrientation;
    private double altitude;
    private int batteryLevel;
    private double longitude;
    private double latitude;
    private Timestamp uTCTimeStamp;
    private int uniqueIdentifier;

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

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(double signalStrength) {
        this.signalStrength = signalStrength;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getMagneticOrientation() {
        return magneticOrientation;
    }

    public void setMagneticOrientation(double magneticOrientation) {
        this.magneticOrientation = magneticOrientation;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
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

    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(int uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
