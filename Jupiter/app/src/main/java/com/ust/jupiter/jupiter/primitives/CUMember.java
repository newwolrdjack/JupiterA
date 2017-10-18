package com.ust.jupiter.jupiter.primitives;

/**
 * Created by User on 18/10/2017.
 */

public class CUMember {
    private String address;
    private Boolean status;
    private int latestBlockNumber;
    private int totalBlockNumber;
    private double totalStorageSpace;
    private double currentStorageSpace;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getLatestBlockNumber() {
        return latestBlockNumber;
    }

    public void setLatestBlockNumber(int latestBlockNumber) {
        this.latestBlockNumber = latestBlockNumber;
    }

    public int getTotalBlockNumber() {
        return totalBlockNumber;
    }

    public void setTotalBlockNumber(int totalBlockNumber) {
        this.totalBlockNumber = totalBlockNumber;
    }

    public double getTotalStorageSpace() {
        return totalStorageSpace;
    }

    public void setTotalStorageSpace(double totalStorageSpace) {
        this.totalStorageSpace = totalStorageSpace;
    }

    public double getCurrentStorageSpace() {
        return currentStorageSpace;
    }

    public void setCurrentStorageSpace(double currentStorageSpace) {
        this.currentStorageSpace = currentStorageSpace;
    }
}
