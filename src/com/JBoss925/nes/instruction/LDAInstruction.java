package com.JBoss925.nes.instruction;

        import com.JBoss925.nes.components.CPU;
        import com.JBoss925.nes.utils.LogUtil;

public class LDAInstruction extends Instruction {

    public LDAInstruction(byte[] inst){
        this.inst = inst;
    }

    @Override
    public void process(CPU cpu) {
        LogUtil.commandLog("LDA", inst);

        switch (inst[0]){
            // Load immediate
            case ((byte)0xa9):
                LogUtil.commandInfoLog("IMMEDIATE", new byte[]{inst[1]});
                cpu.aReg = inst[1];
        }
    }
}