package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.CommonOps;
import com.JBoss925.nes.utils.ConversionUtil;
import com.JBoss925.nes.utils.LogUtil;

import java.util.Arrays;

public class STAInstruction extends Instruction {

    public STAInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        LogUtil.commandLog("STA", inst);
        switch (inst[0]){
            case ((byte)0x8d):
                LogUtil.commandInfoLog("IMMEDIATE", Arrays.copyOfRange(this.inst,1,3));
                byte aRegVal = cpu.aReg;
                cpu.memory.store(CommonOps.intFromBytes(Arrays.copyOfRange(this.inst,1,3)), aRegVal);
        }
    }
}