package com.sanwu.shorturlservice.strategy.impl;

import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import com.sanwu.shorturlservice.strategy.IShortUrlCodeStrategy;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeRequestContext;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeResponseContext;
import com.sanwu.shorturlservice.utils.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;

public class ShortUrlCodeIdStrategy implements IShortUrlCodeStrategy {

    private final DefaultIdentifierGenerator defaultIdentifierGenerator = new DefaultIdentifierGenerator();

    @Autowired
    private UrlShortener urlShortener;

    @Override
    public ShortUrlCodeResponseContext doStrategy(ShortUrlCodeRequestContext requestContext) {
        long sequence = defaultIdentifierGenerator.nextId(null);
        String shortCode = urlShortener.toShortCode(sequence);
        String domainUrl = requestContext.getDomainUrl();
        return ShortUrlCodeResponseContext.builder()
                .id(sequence)
                .shortUrlCode(shortCode)
                .shortUrl(domainUrl + shortCode)
                .build();
    }

}
