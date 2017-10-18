package com.ust.jupiter.jupiter.primitives;


public class DeviceState {
    private int blockNumber;
    private int latestBlockNumber;
    private int maxStorageSpace;
    private int currentStorageSpace;
    private Boolean isCUMember;

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public int getMaxStorageSpace() {
        return maxStorageSpace;
    }

    public void setMaxStorageSpace(int maxStorageSpace) {
        this.maxStorageSpace = maxStorageSpace;
    }

    public int getCurrentStorageSpace() {
        return currentStorageSpace;
    }

    public void setCurrentStorageSpace(int currentStorageSpace) {
        this.currentStorageSpace = currentStorageSpace;
    }

    public Boolean getCUMember() {
        return isCUMember;
    }

    public void setCUMember(Boolean CUMember) {
        isCUMember = CUMember;
    }
    public int getLatestBlockNumber() {
        return latestBlockNumber;
    }

    public void setLatestBlockNumber(int latestBlockNumber) {
        this.latestBlockNumber = latestBlockNumber;
    }


}
