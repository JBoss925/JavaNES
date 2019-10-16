package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class ASLAInstruction extends Instruction {

    public ASLAInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("ASLA " + ConversionUtil.bytesToHex(inst));
    }
}
