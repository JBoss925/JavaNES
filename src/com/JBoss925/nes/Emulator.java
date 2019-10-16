package com.JBoss925.nes;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.components.ROM;

import java.util.Timer;
import java.util.TimerTask;

public class Emulator {

    public ROM rom;
    public CPU cpu;
    private static Timer clock = new Timer();
    private static int clockSpeedHz = 3;

    public Emulator(ROM rom){
        this.rom = rom;
        this.cpu = new CPU(this.rom);
    }

    public void start(){
        clock.cancel();
        clock = new Timer();
        TimerTask t = new TimerTask() {
            @Override
            public void run() {
                cpu.doCycle();
            }
        };
        clock.scheduleAtFixedRate(t, 1000/clockSpeedHz, 1000/clockSpeedHz);
    }

}
