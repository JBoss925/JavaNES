package com.JBoss925.nes.components;

import com.JBoss925.nes.instruction.Instruction;

import java.util.BitSet;

public class CPU {

    public ROM rom;
    public Decoder decoder;
    public int pc;
    public byte xReg;
    public byte yReg;
    public byte aReg;
    public StatusFlags pReg;
    public byte spReg;
    public Memory memory;

    public CPU(ROM rom){
        this.rom = rom;
        this.decoder = new Decoder();
        this.pc = rom.headerLength;
        this.memory = new Memory(0xFFFF + 1);
        initRegisters();
    }

    private void initRegisters(){
        BitSet flagSet = new BitSet(); // set to 0011 0100
        flagSet.set(0, false);
        flagSet.set(1, false);
        flagSet.set(2, true);
        flagSet.set(3, true);
        flagSet.set(4, false);
        flagSet.set(5, true);
        flagSet.set(6, false);
        flagSet.set(7, false);
        pReg = new StatusFlags(flagSet);
        xReg = (byte)0;
        yReg = (byte)0;
        aReg = (byte)0;
        spReg = (byte)0xFD;
        // init memory state
        this.memory.store(0x4017, (byte)0x00);
        this.memory.store(0x4015, (byte)0x00);
        for(int add = 0x4000; add <= 0x400F; add++){
            this.memory.store(add, (byte)0x00);
        }
        for(int add = 0x4010; add <= 0x4013; add++){
            this.memory.store(add, (byte)0x00);
        }
    }

    public void doCycle(){
        byte[] instructionBytes = rom.getInstruction(this.pc, 3);
        Instruction inst = this.decoder.getInstruction(instructionBytes);
        inst.process(this);
        this.pc+=inst.inst.length;
    }

}
