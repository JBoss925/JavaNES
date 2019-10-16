package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;

public class NoOpInstruction extends Instruction {

    public NoOpInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("NoOp " + ConversionUtil.bytesToHex(inst));
    }
}