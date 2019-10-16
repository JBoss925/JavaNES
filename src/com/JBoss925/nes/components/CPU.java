package com.JBoss925.nes.components;

import com.JBoss925.nes.instruction.Instruction;

public class CPU {

    ROM rom;
    int pc;

    public CPU(ROM rom){
        this.rom = rom;
        this.pc = rom.headerLength;
    }

    public void doCycle(){
        byte[] instructionBytes = rom.getInstruction(this.pc, 3);
        Instruction inst = Decoder.getInstruction(instructionBytes);
        inst.process(this);
        this.pc+=inst.inst.length;
    }

}
