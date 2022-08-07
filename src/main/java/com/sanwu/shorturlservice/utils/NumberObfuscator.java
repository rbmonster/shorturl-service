package com.sanwu.shorturlservice.utils;

public class NumberObfuscator {

    private NumberObfuscator() {

    }

    public static long obfuscate(long num, long mask) {
        long sid = (num & 0xffff_ff00_0000_0000L);
        sid += (num & 0x0000_0000_0000_00ffL) << 16;
        sid += (num & 0x0000_0000_00ff_0000L) >> 16;
        sid += (num & 0x0000_0000_ff00_0000L) << 8;
        sid += (num & 0x0000_00ff_0000_0000L) >> 8;
        sid += (num & 0x0000_0000_0000_0f00L) << 4;
        sid += (num & 0x0000_0000_0000_f000L) >> 4;
        sid ^= mask;
        return sid;
    }

    public static long deObfuscate(long num, long mask) {
        num ^= mask;
        long id = (num & 0xffff_ff00_0000_0000L);
        id += (num & 0x0000_0000_00ff_0000L) >> 16;
        id += (num & 0x0000_0000_0000_00ffL) << 16;
        id += (num & 0x0000_00ff_0000_0000L) >> 8;
        id += (num & 0x0000_0000_ff00_0000L) << 8;
        id += (num & 0x0000_0000_0000_f000L) >> 4;
        id += (num & 0x0000_0000_0000_0f00L) << 4;
        return id;
    }

}
