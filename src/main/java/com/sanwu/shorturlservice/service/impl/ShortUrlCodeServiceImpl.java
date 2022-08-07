package com.sanwu.shorturlservice.service.impl;

import com.google.common.hash.HashCode;
import com.sanwu.shorturlservice.dal.dao.ShortUrlMappingDAO;
import com.sanwu.shorturlservice.dal.entity.ShortUrlMappingDO;
import com.sanwu.shorturlservice.entity.request.ShortUrlCodeRequest;
import com.sanwu.shorturlservice.manager.KeyGenerate;
import com.sanwu.shorturlservice.service.IShortUrlCodeService;
import com.sanwu.shorturlservice.strategy.context.ShortUrlCodeResponseContext;
import com.sanwu.shorturlservice.utils.MurMurHashUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.Objects;

@Service
public class ShortUrlCodeServiceImpl implements IShortUrlCodeService {

    @Autowired
    private ShortUrlMappingDAO shortUrlMappingDAO;

    @Autowired
    private KeyGenerate keyGenerate;

    @Override
    public ShortUrlMappingDO findShortUrlCode(String shortUrlCode) {
        return shortUrlMappingDAO.queryByShortUrlCode(shortUrlCode);
    }

    @Override
    public ShortUrlMappingDO createShortUrlCode(ShortUrlCodeRequest shortUrlCodeRequest){
        String originUrl = shortUrlCodeRequest.getOriginUrl();
        HashCode originUrlHash = MurMurHashUtils.hash(originUrl);
        ShortUrlMappingDO shortUrlMappingDO = shortUrlMappingDAO.queryByCondition(shortUrlCodeRequest.getUserId(), originUrlHash.toString());
        if (Objects.nonNull(shortUrlMappingDO)) {
            return shortUrlMappingDO;
        }
        ShortUrlCodeResponseContext context = keyGenerate.generate(originUrl);
        ShortUrlMappingDO shorUrlDO = createShorUrlDO(context, shortUrlCodeRequest, originUrlHash.toString());
        int insert = shortUrlMappingDAO.insert(shorUrlDO);
        Assert.isTrue(1 == insert,"");
        return shorUrlDO;
    }


    private ShortUrlMappingDO createShorUrlDO(ShortUrlCodeResponseContext context, ShortUrlCodeRequest shortUrlCodeRequest, String originUrlHash) {
        ShortUrlMappingDO mappingDO = new ShortUrlMappingDO();
        mappingDO.setUserId(shortUrlCodeRequest.getUserId());
        mappingDO.setId(context.getId());
        mappingDO.setShortUrlCode(context.getShortUrlCode());
        mappingDO.setShortUrl(context.getShortUrl());
        mappingDO.setCreatedTime(new Date());
        mappingDO.setModifiedTime(new Date());
        mappingDO.setOriginUrl(shortUrlCodeRequest.getOriginUrl());
        mappingDO.setActivityType(shortUrlCodeRequest.getActivityType());
        mappingDO.setReferenceId(shortUrlCodeRequest.getActivityId());
        mappingDO.setOriginUrlHash(originUrlHash);
        mappingDO.setVersion(0);
        return mappingDO;
    }
}
