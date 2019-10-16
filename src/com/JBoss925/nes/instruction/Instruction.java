package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;

public abstract class Instruction {

    public byte[] inst;

    public abstract void process(CPU cpu);
    public String getName(){
        return this.getClass().getSimpleName();
    }


}
