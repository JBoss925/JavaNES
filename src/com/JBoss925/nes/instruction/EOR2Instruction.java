package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class EOR2Instruction extends Instruction {

    public EOR2Instruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("EOR2 " + ConversionUtil.bytesToHex(inst));
    }
}