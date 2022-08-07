package com.sanwu.shorturlservice.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UrlShortener {

    private final long mask;

    @Autowired
    public UrlShortener(@Value("${shorturl.mask:20220825}") long mask) {
        this.mask = mask;
    }

    public String toShortCode(long sequenceNum) {
        long obfuscated = NumberObfuscator.obfuscate(sequenceNum, mask);
        return Base62.toBase62(obfuscated);
    }

    public long fromShortCode(String shortCode) {
        Objects.requireNonNull(shortCode, "short code cannot be null");
        long obfuscated = Base62.fromBase62(shortCode);
        return NumberObfuscator.deObfuscate(obfuscated, mask);
    }

}
