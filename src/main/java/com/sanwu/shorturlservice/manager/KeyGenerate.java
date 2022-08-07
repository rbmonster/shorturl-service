package com.sanwu.shorturlservice.manager;

import com.sanwu.shorturlservice.strategy.IShortUrlCodeStrategy;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeRequestContext;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeResponseContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KeyGenerate {


    @Value("${short-url.domain:www.shorturlcode.com}")
    private String domainUrl;

    @Autowired
    private IShortUrlCodeStrategy shortUrlCodeStrategy;

    public ShortUrlCodeResponseContext generate(String originUrl) {
        return shortUrlCodeStrategy.doStrategy(new ShortUrlCodeRequestContext(originUrl, domainUrl));
    }
}
