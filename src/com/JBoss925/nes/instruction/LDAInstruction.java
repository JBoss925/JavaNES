package com.JBoss925.nes.instruction;

        import com.JBoss925.nes.components.CPU;
        import com.JBoss925.nes.utils.ConversionUtil;

public class LDAInstruction extends Instruction {

    public LDAInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        System.out.println("LDA " + ConversionUtil.bytesToHex(inst));
    }
}