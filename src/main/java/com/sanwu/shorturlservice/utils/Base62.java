package com.sanwu.shorturlservice.utils;

import java.util.Objects;

public class Base62 {

    private static final int BASE = 62;

    private static final String TO_BASE_62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String toBase62(long num) {
        StringBuilder sb = new StringBuilder();
        do {
            int i = (int) (num % 62);
            sb.append(TO_BASE_62.charAt(i));
            num = num / 62L;
        } while (num > 0);

        return sb.reverse().toString();
    }

    public static long fromBase62(String base62) {
        Objects.requireNonNull(base62, "base62 cannot be null");
        char[] chars = base62.toCharArray();
        long num = 0L;
        for (int i = 0; i < chars.length; i++) {
            int x = chars.length - i - 1;
            num += TO_BASE_62.indexOf(chars[i]) * pow(BASE, x);
        }
        return num;
    }

    private static long pow(long base, long x) {
        long value = 1;
        while (x > 0) {
            value = value * base;
            x--;
        }
        return value;
    }

}
