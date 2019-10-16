package com.JBoss925.nes.components;

import com.JBoss925.nes.instruction.*;
import com.JBoss925.nes.utils.ConversionUtil;
import org.omg.CORBA.ARG_IN;

import java.util.Arrays;

public class Decoder {

    public static Instruction getInstruction(byte[] instruction){
        switch (ConversionUtil.byteToHex(instruction[0]))
        {

            // Column 0
            case "00":
                return new BRKInstruction(Arrays.copyOf(instruction, 1));
            case "10":
                return new BPLInstruction(Arrays.copyOf(instruction, 2));
            case "20":
                return new JSRInstruction(Arrays.copyOf(instruction, 2));
            case "30":
                return new BMIInstruction(Arrays.copyOf(instruction, 2));
            case "40":
                return new RTIInstruction(Arrays.copyOf(instruction, 1));
            case "50":
                return new BVCInstruction(Arrays.copyOf(instruction, 2));
            case "60":
                return new RTSInstruction(Arrays.copyOf(instruction, 1));
            case "70":
                return new BVSInstruction(Arrays.copyOf(instruction, 2));
            case "90":
                return new BCCInstruction(Arrays.copyOf(instruction, 2));
            case"a0":
                return new LDYInstruction(Arrays.copyOf(instruction, 2));
            case "b0":
                return new BCSInstruction(Arrays.copyOf(instruction, 2));
            case "c0":
                return new CPYInstruction(Arrays.copyOf(instruction, 2));
            case "d0":
                return new BNEInstruction(Arrays.copyOf(instruction, 2));
            case "e0":
                return new CPXInstruction(Arrays.copyOf(instruction, 2));
            case "f0":
                return new BEQInstruction(Arrays.copyOf(instruction, 2));

            // Column 1
            // TODO: CHECK IF THESE LENGTHS ARE CORRECT (in parentheses on defn website)
            case "01":
                return new ORAInstruction(Arrays.copyOf(instruction, 2));
            case "11":
                return new ORA2Instruction(Arrays.copyOf(instruction, 3));
            case "21":
                return new ANDInstruction(Arrays.copyOf(instruction, 2));
            case "31":
                return new AND2Instruction(Arrays.copyOf(instruction, 3));
            case "41":
                return new EORInstruction(Arrays.copyOf(instruction, 2));
            case "51":
                return new EOR2Instruction(Arrays.copyOf(instruction, 3));
            case "61":
                return new ADCInstruction(Arrays.copyOf(instruction, 2));
            case "71":
                return new ADC2Instruction(Arrays.copyOf(instruction, 3));
            case "81":
                return new STAInstruction(Arrays.copyOf(instruction, 2));
            case "91":
                return new STA2Instruction(Arrays.copyOf(instruction, 3));
            case "a1":
                return new LDAInstruction(Arrays.copyOf(instruction, 2));
            case "b1":
                return new LDA2Instruction(Arrays.copyOf(instruction, 3));
            case "c1":
                return new CMPInstruction(Arrays.copyOf(instruction, 2));
            case "d1":
                return new CMP2Instruction(Arrays.copyOf(instruction, 3));
            case "e1":
                return new SBCInstruction(Arrays.copyOf(instruction, 2));
            case "f1":
                return new SBC2Instruction(Arrays.copyOf(instruction, 3));

            // Column 2
            case "a2":
                return new LDXInstruction(Arrays.copyOf(instruction, 2));

            // Column 4
            case "24":
                return new BITInstruction(Arrays.copyOf(instruction, 2));
            case "84":
                return new STYInstruction(Arrays.copyOf(instruction, 2));
            case "94":
                return new STY2Instruction(Arrays.copyOf(instruction, 3));
            case "a4":
                return new LDYInstruction(Arrays.copyOf(instruction, 2));
            case "b4":
                return new LDY2Instruction(Arrays.copyOf(instruction, 3));
            case "c4":
                return new CPYInstruction(Arrays.copyOf(instruction, 2));
            case "e4":
                return new CPXInstruction(Arrays.copyOf(instruction, 2));


            // Column 5
            case "05":
                return new ORAInstruction(Arrays.copyOf(instruction, 2));
            case "15":
                return new ORA2Instruction(Arrays.copyOf(instruction, 3));
            case "25":
                return new ANDInstruction(Arrays.copyOf(instruction, 2));
            case "35":
                return new AND2Instruction(Arrays.copyOf(instruction, 3));
            case "45":
                return new EORInstruction(Arrays.copyOf(instruction, 2));
            case "55":
                return new EOR2Instruction(Arrays.copyOf(instruction, 3));
            case "65":
                return new ADCInstruction(Arrays.copyOf(instruction, 2));
            case "75":
                return new ADC2Instruction(Arrays.copyOf(instruction, 3));
            case "85":
                return new STAInstruction(Arrays.copyOf(instruction, 2));
            case "95":
                return new STA2Instruction(Arrays.copyOf(instruction, 3));
            case "a5":
                return new LDAInstruction(Arrays.copyOf(instruction, 2));
            case "b5":
                return new LDA2Instruction(Arrays.copyOf(instruction, 3));
            case "c5":
                return new CMPInstruction(Arrays.copyOf(instruction, 2));
            case "d5":
                return new CMP2Instruction(Arrays.copyOf(instruction, 3));
            case "e5":
                return new SBCInstruction(Arrays.copyOf(instruction, 2));
            case "f5":
                return new SBC2Instruction(Arrays.copyOf(instruction, 3));


            // Column 6

            case "06":
                return new ASLInstruction(Arrays.copyOf(instruction, 2));
            case "16":
                return new ASL2Instruction(Arrays.copyOf(instruction, 3));
            case "26":
                return new ROLInstruction(Arrays.copyOf(instruction, 2));
            case "36":
                return new ROL2Instruction(Arrays.copyOf(instruction, 3));
            case "46":
                return new LSRInstruction(Arrays.copyOf(instruction, 2));
            case "56":
                return new LSR2Instruction(Arrays.copyOf(instruction, 3));
            case "66":
                return new RORInstruction(Arrays.copyOf(instruction, 2));
            case "76":
                return new ROR2Instruction(Arrays.copyOf(instruction, 3));
            case "86":
                return new STXInstruction(Arrays.copyOf(instruction, 2));
            case "96":
                return new STX2Instruction(Arrays.copyOf(instruction, 3));
            case "a6":
                return new LDXInstruction(Arrays.copyOf(instruction, 2));
            case "b6":
                return new LDX2Instruction(Arrays.copyOf(instruction, 3));
            case "c6":
                return new DECInstruction(Arrays.copyOf(instruction, 2));
            case "d6":
                return new DEC2Instruction(Arrays.copyOf(instruction, 3));
            case "e6":
                return new INCInstruction(Arrays.copyOf(instruction, 2));
            case "f6":
                return new INC2Instruction(Arrays.copyOf(instruction, 3));


            // Column 8
            case "08":
                return new PHPInstruction(Arrays.copyOf(instruction, 1));
            case "18":
                return new CLCInstruction(Arrays.copyOf(instruction, 1));
            case "28":
                return new PLPInstruction(Arrays.copyOf(instruction, 1));
            case "38":
                return new SECInstruction(Arrays.copyOf(instruction, 1));
            case "48":
                return new PHAInstruction(Arrays.copyOf(instruction, 1));
            case "58":
                return new CLIInstruction(Arrays.copyOf(instruction, 1));
            case "68":
                return new PLAInstruction(Arrays.copyOf(instruction, 1));
            case "78":
                return new SEIInstruction(Arrays.copyOf(instruction, 1));
            case "88":
                return new DEYInstruction(Arrays.copyOf(instruction, 1));
            case "98":
                return new TYAInstruction(Arrays.copyOf(instruction, 1));
            case "a8":
                return new TAYInstruction(Arrays.copyOf(instruction, 1));
            case "b8":
                return new CLVInstruction(Arrays.copyOf(instruction, 1));
            case "c8":
                return new INYInstruction(Arrays.copyOf(instruction, 1));
            case "d8":
                return new CLDInstruction(Arrays.copyOf(instruction, 1));
            case "e8":
                return new INXInstruction(Arrays.copyOf(instruction, 1));
            case "f8":
                return new SEDInstruction(Arrays.copyOf(instruction, 1));


            // Column 9
            case "09":
                return new ORAInstruction(Arrays.copyOf(instruction, 2));
            case "19":
                return new ORA2Instruction(Arrays.copyOf(instruction, 3));
            case "29":
                return new ANDInstruction(Arrays.copyOf(instruction, 2));
            case "39":
                return new AND2Instruction(Arrays.copyOf(instruction, 3));
            case "49":
                return new EORInstruction(Arrays.copyOf(instruction, 2));
            case "59":
                return new EOR2Instruction(Arrays.copyOf(instruction, 3));
            case "69":
                return new ADCInstruction(Arrays.copyOf(instruction, 2));
            case "79":
                return new ADC2Instruction(Arrays.copyOf(instruction, 3));
            case "99":
                return new STA2Instruction(Arrays.copyOf(instruction, 3));
            case "a9":
                return new LDAInstruction(Arrays.copyOf(instruction, 2));
            case "b9":
                return new LDA2Instruction(Arrays.copyOf(instruction, 3));
            case "c9":
                return new CMPInstruction(Arrays.copyOf(instruction, 2));
            case "d9":
                return new CMP2Instruction(Arrays.copyOf(instruction, 3));
            case "e9":
                return new SBCInstruction(Arrays.copyOf(instruction, 2));
            case "f9":
                return new SBC2Instruction(Arrays.copyOf(instruction, 3));


            // Column a
            case "0a":
                return new ASLAInstruction(Arrays.copyOf(instruction, 1));
            case "2a":
                return new ROLAInstruction(Arrays.copyOf(instruction, 1));
            case "4a":
                return new LSRAInstruction(Arrays.copyOf(instruction, 1));
            case "6a":
                return new RORAInstruction(Arrays.copyOf(instruction, 1));
            case "8a":
                return new TXAInstruction(Arrays.copyOf(instruction, 1));
            case "9a":
                return new TXSInstruction(Arrays.copyOf(instruction, 1));
            case "aa":
                return new TAXInstruction(Arrays.copyOf(instruction, 1));
            case "ba":
                return new TSXInstruction(Arrays.copyOf(instruction, 1));
            case "ca":
                return new DEXInstruction(Arrays.copyOf(instruction, 1));
            case "ea":
                return new NoOpInstruction(Arrays.copyOf(instruction, 1));

            // Column c
            case "2c":
                return new BITInstruction(Arrays.copyOf(instruction, 2));
            case "4c":
                return new JMPInstruction(Arrays.copyOf(instruction, 2));
            case "6c":
                return new JMPInstruction(Arrays.copyOf(instruction, 2));
            case "8c":
                return new STYInstruction(Arrays.copyOf(instruction, 2));
            case "ac":
                return new LDYInstruction(Arrays.copyOf(instruction, 2));
            case "bc":
                return new LDY2Instruction(Arrays.copyOf(instruction, 3));
            case "cc":
                return new CPYInstruction(Arrays.copyOf(instruction, 2));
            case "ec":
                return new CPXInstruction(Arrays.copyOf(instruction, 2));


            // Column d
            case "0d":
                return new ORAInstruction(Arrays.copyOf(instruction, 2));
            case "1d":
                return new ORA2Instruction(Arrays.copyOf(instruction, 3));
            case "2d":
                return new ANDInstruction(Arrays.copyOf(instruction, 2));
            case "3d":
                return new AND2Instruction(Arrays.copyOf(instruction, 3));
            case "4d":
                return new EORInstruction(Arrays.copyOf(instruction, 2));
            case "5d":
                return new EOR2Instruction(Arrays.copyOf(instruction, 3));
            case "6d":
                return new ADCInstruction(Arrays.copyOf(instruction, 2));
            case "7d":
                return new ADC2Instruction(Arrays.copyOf(instruction, 3));
            case "8d":
                return new STAInstruction(Arrays.copyOf(instruction, 2));
            case "9d":
                return new STA2Instruction(Arrays.copyOf(instruction, 3));
            case "ad":
                return new LDAInstruction(Arrays.copyOf(instruction, 2));
            case "bd":
                return new LDA2Instruction(Arrays.copyOf(instruction, 3));
            case "cd":
                return new CMPInstruction(Arrays.copyOf(instruction, 2));
            case "dd":
                return new CMP2Instruction(Arrays.copyOf(instruction, 3));
            case "ed":
                return new SBCInstruction(Arrays.copyOf(instruction, 2));
            case "fd":
                return new SBC2Instruction(Arrays.copyOf(instruction, 3));



             // Column e
            case "0e":
                return new ASLInstruction(Arrays.copyOf(instruction, 2));
            case "1e":
                return new ASL2Instruction(Arrays.copyOf(instruction, 3));
            case "2e":
                return new ROLInstruction(Arrays.copyOf(instruction, 2));
            case "3e":
                return new ROL2Instruction(Arrays.copyOf(instruction, 3));
            case "4e":
                return new LSRInstruction(Arrays.copyOf(instruction, 2));
            case "5e":
                return new LSR2Instruction(Arrays.copyOf(instruction, 3));
            case "6e":
                return new RORInstruction(Arrays.copyOf(instruction, 2));
            case "7e":
                return new ROR2Instruction(Arrays.copyOf(instruction, 3));
            case "8e":
                return new STXInstruction(Arrays.copyOf(instruction, 2));
            case "ae":
                return new LDXInstruction(Arrays.copyOf(instruction, 2));
            case "be":
                return new LDX2Instruction(Arrays.copyOf(instruction, 3));
            case "ce":
                return new DECInstruction(Arrays.copyOf(instruction, 2));
            case "de":
                return new DEC2Instruction(Arrays.copyOf(instruction, 3));
            case "ee":
                return new INCInstruction(Arrays.copyOf(instruction, 2));
            case "fe":
                return new INC2Instruction(Arrays.copyOf(instruction, 3));



            default:
                System.out.println("Instruction: \"" +
                        ConversionUtil.bytesToHex(instruction)
                + "\" not recognized!");
                return new NoOpInstruction(Arrays.copyOf(instruction, 1));
        }
    }

}
