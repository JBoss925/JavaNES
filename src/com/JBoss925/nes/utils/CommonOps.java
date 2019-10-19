package com.JBoss925.nes.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class CommonOps {

    public static int intFromBytes(byte[] bytesBigEndian){
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4);
        byteBuffer.order(ByteOrder.BIG_ENDIAN);
        for(int i = 0; i < 4 - bytesBigEndian.length; i++){
            byteBuffer.put((byte)0x00);
        }
        for(byte b : bytesBigEndian){
            byteBuffer.put(b);
        }
        byteBuffer.flip();
        return byteBuffer.getInt();
    }

}
