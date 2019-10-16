package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class ROLAInstruction extends Instruction {

    public ROLAInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("ROLA " + ConversionUtil.bytesToHex(inst));
    }
}
