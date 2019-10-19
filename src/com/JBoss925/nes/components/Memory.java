package com.JBoss925.nes.components;

import java.util.HashMap;

public class Memory {

    byte[] memory;


    public Memory(int sizeInBytes){
        memory = new byte[sizeInBytes];
    }

    public void store(int address, byte value){
        memory[address] = value;
    }

    public byte load(int address){
        return memory[address];
    }

}
