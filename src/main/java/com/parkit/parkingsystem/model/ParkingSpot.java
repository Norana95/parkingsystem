package com.parkit.parkingsystem.model;

import com.parkit.parkingsystem.constants.ParkingType;
import lombok.Generated;

public class ParkingSpot {
    private int number;
    private ParkingType parkingType;
    private boolean isAvailable;

    public ParkingSpot(int number, ParkingType parkingType, boolean isAvailable) {
        this.number = number;
        this.parkingType = parkingType;
        this.isAvailable = isAvailable;
    }

    @Generated
    public int getId() {
        return number;
    }

    @Generated
    public void setId(int number) {
        this.number = number;
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    @Generated
    public void setParkingType(ParkingType parkingType) {
        this.parkingType = parkingType;
    }

    @Generated
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingSpot that = (ParkingSpot) o;
        return number == that.number;
    }

    @Generated
    @Override
    public int hashCode() {
        return number;
    }
}
