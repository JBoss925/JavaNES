package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class STY2Instruction extends Instruction {

    public STY2Instruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("STY2 " + ConversionUtil.bytesToHex(inst));
    }
}
