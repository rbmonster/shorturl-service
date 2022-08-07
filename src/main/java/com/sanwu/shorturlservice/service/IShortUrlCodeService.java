package com.sanwu.shorturlservice.service;

import com.sanwu.shorturlservice.dal.entity.ShortUrlMappingDO;
import com.sanwu.shorturlservice.entity.request.ShortUrlCodeRequest;

public interface IShortUrlCodeService {

    ShortUrlMappingDO findShortUrlCode(String shortUrlCode);

    ShortUrlMappingDO createShortUrlCode(ShortUrlCodeRequest shortUrlCodeRequest);
}
