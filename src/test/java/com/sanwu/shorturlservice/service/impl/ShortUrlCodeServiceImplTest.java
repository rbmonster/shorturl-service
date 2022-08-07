package com.sanwu.shorturlservice.service.impl;

import com.sanwu.shorturlservice.dal.entity.ShortUrlMappingDO;
import com.sanwu.shorturlservice.entity.request.ShortUrlCodeRequest;
import com.sanwu.shorturlservice.service.IShortUrlCodeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class ShortUrlCodeServiceImplTest {

    @Autowired
    private IShortUrlCodeService shortUrlCodeService;

    @Test
     void findShortUrlCode() {
        ShortUrlMappingDO shortUrlMappingDO = shortUrlCodeService.findShortUrlCode("sadf");
        Assert.assertNull("", shortUrlMappingDO);
    }

    @Test
    void createShortUrlCode() {
        ShortUrlCodeRequest request = new ShortUrlCodeRequest();
        request.setOriginUrl("https://www.google.com.hk/search?q=spring+mybatis-plus+h2+test&newwindow=1&biw=1440&bih=674&ei=7LPvYpTgHae3mAWA17qoDA&ved=0ahUKEwiUhq2Z4bT5AhWnG6YKHYCrDsUQ4dUDCA4&uact=5&oq=spring+mybatis-plus+h2+test&gs_lcp=Cgdnd3Mtd2l6EAM6BwgAEEcQsAM6BggAEB4QBzoICAAQHhAIEAc6CggAEB4QCBAHEAo6BAgAEB46BggAEB4QCEoECEEYAEoECEYYAFC0C1jPLGDiLmgDcAF4AIABoAGIAesPkgEEMC4xNJgBAKABAcgBCsABAQ&sclient=gws-wiz");
        request.setUserId(1123112349393203L);
        ShortUrlMappingDO shortUrlCode = shortUrlCodeService.createShortUrlCode(request);
        Assert.assertNotNull("create not null", shortUrlCode);
    }

}