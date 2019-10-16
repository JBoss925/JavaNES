package com.JBoss925.nes.utils;

public class ConversionUtil {


    public static String bytesToHex(byte[] hashInBytes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }

    public static String byteToHex(byte b) {
        return String.format("%02x", b);
    }


}
