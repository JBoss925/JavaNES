package com.JBoss925.nes.components;

public class PPU {

    private CPU cpuInstance;
    private int zeroIndex;

    public PPU(CPU pairedCPU, int zeroIndex){
        this.cpuInstance = pairedCPU;
        this.zeroIndex = zeroIndex;
    }

}
