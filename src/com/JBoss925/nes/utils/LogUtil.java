package com.JBoss925.nes.utils;

public class LogUtil {

    public static boolean isDebug = true;

    public static void commandLog(String cmd, byte[] inst){
        if(!isDebug)
            return;
        System.out.println("|");
        System.out.println("|");
        System.out.println("├--- " + cmd.toUpperCase() + " " + ConversionUtil.bytesToHex(inst));
    }

    public static void commandInfoLog(String info, byte[] inst){
        if(!isDebug)
            return;
        System.out.println("|     |    ");
        System.out.println("|     └--- " + info + " " + ConversionUtil.bytesToHex(inst));
    }

    public static void defaultLog(String msg){
        System.out.println("|");
        System.out.println("|");
        System.out.println("├--- " + msg);
    }

}
