package com.sanwu.shorturlservice.config;

import com.sanwu.shorturlservice.entity.constant.ShortUrlStrategy;
import com.sanwu.shorturlservice.strategy.IShortUrlCodeStrategy;
import com.sanwu.shorturlservice.strategy.impl.ShortUrlCodeIdStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShortUrlCodeConfig {

    @Value("${short-url.strategy:ID}")
    private ShortUrlStrategy shortUrlStrategy;

    @Bean
    public IShortUrlCodeStrategy shortUrlCodeStrategy() {
        switch (shortUrlStrategy){
            case ID:
                return new ShortUrlCodeIdStrategy();
            case HASH:
                //TODO
                throw new IllegalArgumentException("");
            default:
                return new ShortUrlCodeIdStrategy();
        }
    }
}
