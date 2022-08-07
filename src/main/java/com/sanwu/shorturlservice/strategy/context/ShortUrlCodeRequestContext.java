package com.sanwu.shorturlservice.strategy.context;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ShortUrlCodeRequestContext {

    private String originUrl;

    private String domainUrl;
}
