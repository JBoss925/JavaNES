package com.JBoss925.nes.components;

import com.JBoss925.nes.instruction.*;
import com.JBoss925.nes.utils.ConversionUtil;

import java.util.Arrays;

public class Decoder {

    public static Instruction getInstruction(byte[] instruction){
        switch (ConversionUtil.byteToHex(instruction[0]))
        {
            case "78":
                return new SEIInstruction(Arrays.copyOf(instruction, 1));
            case "d8":
                return new CLDInstruction(Arrays.copyOf(instruction, 1));
            case "a9":
                return new LDAInstruction(Arrays.copyOf(instruction, 2));
            case "10":
                return new BPLInstruction(Arrays.copyOf(instruction, 2));
            case "8d":
                return new STAInstruction(Arrays.copyOf(instruction, 2));
            default:
                System.out.println("Instruction: \"" +
                        ConversionUtil.bytesToHex(instruction)
                + "\" not recognized!");
                return new NoOpInstruction(Arrays.copyOf(instruction, 1));
        }
    }

}
