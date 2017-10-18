package com.ust.jupiter.jupiter.primitives;


import java.util.Date;
import java.util.List;

public class ConsensusUnit {
    public String address;
    public String name;
    public String id;
    private Boolean CUType;
    private Date buildDate;
    private int maxCUMember;
    private int latestBlockNumber;
    private List<String> currentActiveAddress;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getCUType() {
        return CUType;
    }

    public void setCUType(Boolean CUType) {
        this.CUType = CUType;
    }

    public int getMaxCUMember() {
        return maxCUMember;
    }

    public void setMaxCUMember(int maxCUMember) {
        this.maxCUMember = maxCUMember;
    }

    public List<String> getCurrentActiveAddress() {
        return currentActiveAddress;
    }

    public void setCurrentActiveAddress(List<String> currentActiveAddress) {
        this.currentActiveAddress = currentActiveAddress;
    }

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

    public Date getBuildDate() {
        return buildDate;
    }

    public void setBuildDate(Date buildDate) {
        this.buildDate = buildDate;
    }

    public int getLatestBlockNumber() {
        return latestBlockNumber;
    }

    public void setLatestBlockNumber(int latestBlockNumber) {
        this.latestBlockNumber = latestBlockNumber;
    }
}
