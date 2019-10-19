package com.JBoss925.nes.instruction;

import com.JBoss925.nes.components.CPU;
import com.JBoss925.nes.utils.ConversionUtil;
import com.JBoss925.nes.utils.LogUtil;

public class ASL2Instruction extends Instruction {

    public ASL2Instruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        LogUtil.commandLog("ASL2", inst);
    }
}
