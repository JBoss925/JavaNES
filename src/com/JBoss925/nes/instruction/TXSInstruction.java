package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class TXSInstruction extends Instruction {

    public TXSInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("TXS " + ConversionUtil.bytesToHex(inst));
    }
}