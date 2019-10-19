package com.JBoss925.nes.utils;

import com.oracle.tools.packager.Log;

import java.util.logging.Level;
import java.util.logging.Logger;

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
