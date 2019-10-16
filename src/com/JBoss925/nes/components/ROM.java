package com.JBoss925.nes.components;

import com.JBoss925.nes.utils.ConversionUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class ROM {

    public byte[] bytes;
    public byte[] programBytes;
    public int headerLength = 16;
    public int numBlocks = 2; // TODO: pull from header
    public static int KB_SIZE = 1024;

    public ROM(File romFile) throws IOException {
       bytes = Files.readAllBytes(romFile.toPath());
       programBytes = Arrays.copyOfRange(bytes, headerLength, headerLength + (numBlocks * 16 * KB_SIZE));
    }

    public byte getByte(int address){
        return bytes[address];
    }

    public String getByteHex(int address){
        return ConversionUtil.byteToHex(bytes[address]);
    }

    public byte[] getInstruction(int address, int length){
        return Arrays.copyOfRange(bytes, address, address + length);
    }

}
