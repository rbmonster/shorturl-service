package com.sanwu.shorturlservice.strategy;

import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeRequestContext;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeResponseContext;

public interface IShortUrlCodeStrategy {

    ShortUrlCodeResponseContext doStrategy(ShortUrlCodeRequestContext requestContext);

}
