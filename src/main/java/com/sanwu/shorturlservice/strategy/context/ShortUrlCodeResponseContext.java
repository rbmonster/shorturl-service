package com.sanwu.shorturlservice.strategy.context;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShortUrlCodeResponseContext {

    private Long id;

    private String shortUrlCode;

    private String shortUrl;
}
