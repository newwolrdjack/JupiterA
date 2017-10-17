package com.ust.jupiter.jupiter.primitives;


import java.util.List;

public class ConsensusUnit {
    public String address;
    public String id;
    private Boolean CUType;
    private int maxCUmember;
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

    public int getMaxCUmember() {
        return maxCUmember;
    }

    public void setMaxCUmember(int maxCUmember) {
        this.maxCUmember = maxCUmember;
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


}
