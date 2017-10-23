/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ust.jupiter.jupiter.fragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Generationg hash values of given values with a given value
 * @author Rustem Azimov
 */
public class Function {

    String hashText(String text ){
        return convertToSHA512(text);
    }


    private String convertToSHA512(String textToHash)
    {
        try {
            final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
            sha512.update(textToHash.getBytes());
            
            return convertByteToHex(sha512.digest());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "You need support\nContact with us";
    }  


    private  String convertByteToHex(byte data[])
    {
        StringBuilder hexData = new StringBuilder();
        for (int byteIndex = 0; byteIndex < data.length; byteIndex++)
            hexData.append(Integer.toString((data[byteIndex] & 0xff) + 0x100, 16).substring(1));

        return hexData.toString();
    }
}
