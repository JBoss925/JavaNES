package com.JBoss925.nes.utils;

import sun.jvm.hotspot.utilities.Bits;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.BitSet;

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

    public static byte bitwiseAnd(byte byte1, byte byte2){
        BitSet b1 = BitSet.valueOf(new byte[]{byte1});
        BitSet b2 = BitSet.valueOf(new byte[]{byte2});
        BitSet result = new BitSet();
        for(int i = 0; i < b1.length(); i++){
            result.set(i, (b1.get(i) && b2.get(i)));
        }
        return result.toByteArray()[0];
    }

}
