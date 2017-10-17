package com.ust.jupiter.jupiter.utils;

import java.util.UUID;



public class CommonUtils {
    public final static byte userAddress = 1;

    public String generateCUAddress() {
        return UUID.randomUUID().toString();
    }

    public String generateAddress() {
        return UUID.randomUUID().toString();
    }


}
