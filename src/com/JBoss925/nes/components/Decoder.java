package com.JBoss925.nes.components;

import com.JBoss925.nes.instruction.*;
import com.JBoss925.nes.utils.ConversionUtil;
import com.JBoss925.nes.utils.LogUtil;

import java.util.Arrays;
import java.util.HashMap;

public class Decoder {

    private HashMap<Byte, Instruction> instructionInstances = new HashMap<>();

    public Decoder(){
        instructionInstances.put((byte)0x00, new BRKInstruction(null));
        instructionInstances.put((byte)0x10, new BPLInstruction(null));
        instructionInstances.put((byte)0x20, new JSRInstruction(null));
        instructionInstances.put((byte)0x30, new BMIInstruction(null));
        instructionInstances.put((byte)0x40, new RTIInstruction(null));
        instructionInstances.put((byte)0x50, new BVCInstruction(null));
        instructionInstances.put((byte)0x60, new RTSInstruction(null));
        instructionInstances.put((byte)0x70, new BVSInstruction(null));
        instructionInstances.put((byte)0x90, new BCCInstruction(null));
        instructionInstances.put((byte)0xa0, new LDYInstruction(null));
        instructionInstances.put((byte)0xb0, new BCSInstruction(null));
        instructionInstances.put((byte)0xc0, new CPYInstruction(null));
        instructionInstances.put((byte)0xd0, new BNEInstruction(null));
        instructionInstances.put((byte)0xe0, new CPXInstruction(null));
        instructionInstances.put((byte)0xf0, new BEQInstruction(null));

        instructionInstances.put((byte)0x01, new ORAInstruction(null));
        instructionInstances.put((byte)0x11, new ORA2Instruction(null));
        instructionInstances.put((byte)0x21, new ANDInstruction(null));
        instructionInstances.put((byte)0x31, new AND2Instruction(null));
        instructionInstances.put((byte)0x41, new EORInstruction(null));
        instructionInstances.put((byte)0x51, new EOR2Instruction(null));
        instructionInstances.put((byte)0x61, new ADCInstruction(null));
        instructionInstances.put((byte)0x71, new ADC2Instruction(null));
        instructionInstances.put((byte)0x81, new STAInstruction(null));
        instructionInstances.put((byte)0x91, new STA2Instruction(null));
        instructionInstances.put((byte)0xa1, new LDAInstruction(null));
        instructionInstances.put((byte)0xb1, new LDA2Instruction(null));
        instructionInstances.put((byte)0xc1, new CMPInstruction(null));
        instructionInstances.put((byte)0xd1, new CMP2Instruction(null));
        instructionInstances.put((byte)0xe1, new SBCInstruction(null));
        instructionInstances.put((byte)0xf1, new SBC2Instruction(null));

        instructionInstances.put((byte)0xa2, new LDXInstruction(null));

        instructionInstances.put((byte)0x24, new BITInstruction(null));
        instructionInstances.put((byte)0x84, new STYInstruction(null));
        instructionInstances.put((byte)0x94, new STY2Instruction(null));
        instructionInstances.put((byte)0xa4, new LDYInstruction(null));
        instructionInstances.put((byte)0xb4, new LDY2Instruction(null));
        instructionInstances.put((byte)0xc4, new CPYInstruction(null));
        instructionInstances.put((byte)0xe4, new CPXInstruction(null));

        instructionInstances.put((byte)0x05, new ORAInstruction(null));
        instructionInstances.put((byte)0x15, new ORA2Instruction(null));
        instructionInstances.put((byte)0x25, new ANDInstruction(null));
        instructionInstances.put((byte)0x35, new AND2Instruction(null));
        instructionInstances.put((byte)0x45, new EORInstruction(null));
        instructionInstances.put((byte)0x55, new EOR2Instruction(null));
        instructionInstances.put((byte)0x65, new ADCInstruction(null));
        instructionInstances.put((byte)0x75, new ADC2Instruction(null));
        instructionInstances.put((byte)0x85, new STAInstruction(null));
        instructionInstances.put((byte)0x95, new STA2Instruction(null));
        instructionInstances.put((byte)0xa5, new LDAInstruction(null));
        instructionInstances.put((byte)0xb5, new LDA2Instruction(null));
        instructionInstances.put((byte)0xc5, new CMPInstruction(null));
        instructionInstances.put((byte)0xd5, new CMP2Instruction(null));
        instructionInstances.put((byte)0xe5, new SBCInstruction(null));
        instructionInstances.put((byte)0xf5, new SBC2Instruction(null));

        instructionInstances.put((byte)0x06, new ASLInstruction(null));
        instructionInstances.put((byte)0x16, new ASL2Instruction(null));
        instructionInstances.put((byte)0x26, new ROLInstruction(null));
        instructionInstances.put((byte)0x36, new ROL2Instruction(null));
        instructionInstances.put((byte)0x46, new LSRInstruction(null));
        instructionInstances.put((byte)0x56, new LSR2Instruction(null));
        instructionInstances.put((byte)0x66, new RORInstruction(null));
        instructionInstances.put((byte)0x76, new ROR2Instruction(null));
        instructionInstances.put((byte)0x86, new STXInstruction(null));
        instructionInstances.put((byte)0x96, new STX2Instruction(null));
        instructionInstances.put((byte)0xa6, new LDXInstruction(null));
        instructionInstances.put((byte)0xb6, new LDX2Instruction(null));
        instructionInstances.put((byte)0xc6, new DECInstruction(null));
        instructionInstances.put((byte)0xd6, new DEC2Instruction(null));
        instructionInstances.put((byte)0xe6, new INCInstruction(null));
        instructionInstances.put((byte)0xf6, new INC2Instruction(null));

        instructionInstances.put((byte)0x08, new PHPInstruction(null));
        instructionInstances.put((byte)0x18, new CLCInstruction(null));
        instructionInstances.put((byte)0x28, new PLPInstruction(null));
        instructionInstances.put((byte)0x38, new SECInstruction(null));
        instructionInstances.put((byte)0x48, new PHAInstruction(null));
        instructionInstances.put((byte)0x58, new CLIInstruction(null));
        instructionInstances.put((byte)0x68, new PLAInstruction(null));
        instructionInstances.put((byte)0x78, new SEIInstruction(null));
        instructionInstances.put((byte)0x88, new DEYInstruction(null));
        instructionInstances.put((byte)0x98, new TYAInstruction(null));
        instructionInstances.put((byte)0xa8, new TAYInstruction(null));
        instructionInstances.put((byte)0xb8, new CLVInstruction(null));
        instructionInstances.put((byte)0xc8, new INYInstruction(null));
        instructionInstances.put((byte)0xd8, new CLDInstruction(null));
        instructionInstances.put((byte)0xe8, new INXInstruction(null));
        instructionInstances.put((byte)0xf8, new SEDInstruction(null));

        instructionInstances.put((byte)0x09, new ORAInstruction(null));
        instructionInstances.put((byte)0x19, new ORA2Instruction(null));
        instructionInstances.put((byte)0x29, new ANDInstruction(null));
        instructionInstances.put((byte)0x39, new AND2Instruction(null));
        instructionInstances.put((byte)0x49, new EORInstruction(null));
        instructionInstances.put((byte)0x59, new EOR2Instruction(null));
        instructionInstances.put((byte)0x69, new ADCInstruction(null));
        instructionInstances.put((byte)0x79, new ADC2Instruction(null));
        instructionInstances.put((byte)0x99, new STA2Instruction(null));
        instructionInstances.put((byte)0xa9, new LDAInstruction(null));
        instructionInstances.put((byte)0xb9, new LDA2Instruction(null));
        instructionInstances.put((byte)0xc9, new CMPInstruction(null));
        instructionInstances.put((byte)0xd9, new CMP2Instruction(null));
        instructionInstances.put((byte)0xe9, new SBCInstruction(null));
        instructionInstances.put((byte)0xf9, new SBC2Instruction(null));

        instructionInstances.put((byte)0x0a, new ASLAInstruction(null));
        instructionInstances.put((byte)0x2a, new ROLAInstruction(null));
        instructionInstances.put((byte)0x4a, new LSRAInstruction(null));
        instructionInstances.put((byte)0x6a, new RORAInstruction(null));
        instructionInstances.put((byte)0x8a, new TXAInstruction(null));
        instructionInstances.put((byte)0xaa, new TAXInstruction(null));
        instructionInstances.put((byte)0xba, new TSXInstruction(null));
        instructionInstances.put((byte)0xca, new DEXInstruction(null));
        instructionInstances.put((byte)0xea, new NoOpInstruction(null));

        instructionInstances.put((byte)0x2c, new BITInstruction(null));
        instructionInstances.put((byte)0x4c, new JMPInstruction(null));
        instructionInstances.put((byte)0x6c, new JMPInstruction(null));
        instructionInstances.put((byte)0x8c, new STYInstruction(null));
        instructionInstances.put((byte)0xac, new LDYInstruction(null));
        instructionInstances.put((byte)0xbc, new LDY2Instruction(null));
        instructionInstances.put((byte)0xcc, new CPYInstruction(null));
        instructionInstances.put((byte)0xec, new CPXInstruction(null));

        instructionInstances.put((byte)0x0d, new ORAInstruction(null));
        instructionInstances.put((byte)0x1d, new ORA2Instruction(null));
        instructionInstances.put((byte)0x2d, new ANDInstruction(null));
        instructionInstances.put((byte)0x3d, new AND2Instruction(null));
        instructionInstances.put((byte)0x4d, new EORInstruction(null));
        instructionInstances.put((byte)0x5d, new EOR2Instruction(null));
        instructionInstances.put((byte)0x6d, new ADCInstruction(null));
        instructionInstances.put((byte)0x7d, new ADC2Instruction(null));
        instructionInstances.put((byte)0x8d, new STAInstruction(null));
        instructionInstances.put((byte)0x9d, new STA2Instruction(null));
        instructionInstances.put((byte)0xad, new LDAInstruction(null));
        instructionInstances.put((byte)0xbd, new LDA2Instruction(null));
        instructionInstances.put((byte)0xcd, new CMPInstruction(null));
        instructionInstances.put((byte)0xdd, new CMP2Instruction(null));
        instructionInstances.put((byte)0xed, new SBCInstruction(null));
        instructionInstances.put((byte)0xfd, new SBC2Instruction(null));

        instructionInstances.put((byte)0x0e, new ASLInstruction(null));
        instructionInstances.put((byte)0x1e, new ASL2Instruction(null));
        instructionInstances.put((byte)0x2e, new ROLInstruction(null));
        instructionInstances.put((byte)0x3e, new ROL2Instruction(null));
        instructionInstances.put((byte)0x4e, new LSRInstruction(null));
        instructionInstances.put((byte)0x5e, new LSR2Instruction(null));
        instructionInstances.put((byte)0x6e, new RORInstruction(null));
        instructionInstances.put((byte)0x7e, new ROR2Instruction(null));
        instructionInstances.put((byte)0x8e, new STXInstruction(null));
        instructionInstances.put((byte)0xae, new LDXInstruction(null));
        instructionInstances.put((byte)0xbe, new LDX2Instruction(null));
        instructionInstances.put((byte)0xce, new DECInstruction(null));
        instructionInstances.put((byte)0xde, new DEC2Instruction(null));
        instructionInstances.put((byte)0xee, new INCInstruction(null));
        instructionInstances.put((byte)0xfe, new INC2Instruction(null));

    }

    public Instruction getInstruction(byte[] instruction){

        try{
            switch (Byte.toUnsignedInt(instruction[0]))
            {

                // Column 0
                case 0x00:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x10:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x20:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x30:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x40:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x50:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x60:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x70:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x90:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xa0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xc0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xd0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xe0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xf0:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));

                // Column 1
                // TODO: CHECK IF THESE LENGTHS ARE CORRECT (in parentheses on defn website)
                case 0x01:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x11:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x21:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x31:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x41:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x51:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x61:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x71:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x81:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x91:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xa1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xc1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xd1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xe1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xf1:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));

                // Column 2
                case 0xa2:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));

                // Column 4
                case 0x24:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x84:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x94:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xa4:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb4:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xc4:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xe4:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));


                // Column 5
                case 0x05:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x15:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x25:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x35:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x45:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x55:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x65:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x75:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x85:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x95:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xa5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xc5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xd5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xe5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xf5:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));


                // Column 6

                case 0x06:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x16:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x26:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x36:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x46:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x56:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x66:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x76:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x86:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x96:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xa6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xc6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xd6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xe6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xf6:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));


                // Column 8
                case 0x08:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x18:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x28:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x38:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x48:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x58:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x68:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x78:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x88:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x98:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xa8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xb8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xc8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xd8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xe8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xf8:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));


                // Column 9
                case 0x09:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x19:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x29:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x39:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x49:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x59:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x69:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x79:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x99:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xa9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xb9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xc9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xd9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xe9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xf9:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));


                // Column a
                case 0x0a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x2a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x4a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x6a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x8a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0x9a:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xaa:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xba:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xca:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));
                case 0xea:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 1));

                // Column c
                case 0x2c:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x4c:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x6c:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x8c:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xac:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xbc:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xcc:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xec:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));

                // Column d
                case 0x0d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x1d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x2d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x3d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x4d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x5d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x6d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x7d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x8d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x9d:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xad:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xbd:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xcd:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xdd:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xed:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xfd:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));



                // Column e
                case 0x0e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x1e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x2e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x3e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x4e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x5e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x6e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0x7e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0x8e:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xae:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xbe:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xce:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xde:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));
                case 0xee:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 2));
                case 0xfe:
                    return instructionInstances.get(instruction[0]).resetWithNewInst(Arrays.copyOf(instruction, 3));



                default:
                    LogUtil.defaultLog("Instruction: \"" +
                            ConversionUtil.bytesToHex(instruction)
                            + "\" not recognized!");
                    // Do No-Op and pray??
                    return instructionInstances.get(((byte)0xea)).resetWithNewInst(Arrays.copyOf(instruction, 1));
            }
        } catch (Exception e){
            LogUtil.defaultLog("Instruction: \"" +
                    ConversionUtil.bytesToHex(instruction)
                    + "\" not recognized!");
            // Do No-Op and pray??
            return instructionInstances.get(((byte)0xea)).resetWithNewInst(Arrays.copyOf(instruction, 1));
        }

    }

}
