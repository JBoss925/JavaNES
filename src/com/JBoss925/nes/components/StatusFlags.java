package com.JBoss925.nes.components;

import java.util.BitSet;

public class StatusFlags {

    BitSet flags;

    // Constructors

    public StatusFlags(BitSet init){
        this.flags = init;
    }

    public StatusFlags(){
        this.flags = new BitSet();
    }

    // Setters

    public void setCarry(boolean value){
        flags.set(0, value);
    }

    public void setZero(boolean value){
        flags.set(1, value);
    }

    public void setInterrupt(boolean value){
        flags.set(2, value);
    }

    public void setDecimal(boolean value){
        flags.set(3, value);
    }

    public void setStack1(boolean value){
        flags.set(4, value);
    }

    public void setStack2(boolean value){
        flags.set(5, value);
    }

    public void setOverflow(boolean value){
        flags.set(6, value);
    }

    public void setNegative(boolean value){
        flags.set(7, value);
    }

    // Getters

    public boolean getCarry(){
        return flags.get(0);
    }

    public boolean getZero(){
        return flags.get(1);
    }

    public boolean getInterrupt(){
        return flags.get(2);
    }

    public boolean getDecimal(){
        return flags.get(3);
    }

    public boolean getStack1(){
        return flags.get(4);
    }

    public boolean getStack2(){
        return flags.get(5);
    }

    public boolean getOverflow(){
        return flags.get(6);
    }

    public boolean getNegative(){
        return flags.get(7);
    }

}
