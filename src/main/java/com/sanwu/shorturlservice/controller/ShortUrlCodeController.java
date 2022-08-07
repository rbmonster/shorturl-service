package com.sanwu.shorturlservice.controller;

import com.sanwu.shorturlservice.dal.entity.ShortUrlMappingDO;
import com.sanwu.shorturlservice.entity.request.ShortUrlCodeRequest;
import com.sanwu.shorturlservice.entity.vo.ShortUrlCodeVO;
import com.sanwu.shorturlservice.service.IShortUrlCodeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/t")
public class ShortUrlCodeController {

    @Autowired
    private IShortUrlCodeService shortUrlCodeService;

    @GetMapping("/{shortUrlCode}")
    public void open(@PathVariable("shortUrlCode") String shortUrlCode, HttpServletResponse response) throws IOException {
        ShortUrlMappingDO shortUrlMappingDO = shortUrlCodeService.findShortUrlCode(shortUrlCode);
        if (Objects.isNull(shortUrlCode)) {
            log.warn("short url code cannot be null or empty");
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return;
        }
        if (StringUtils.isNotEmpty(shortUrlMappingDO.getActivityType())) {
            // async dispatch event
        }
        response.setStatus(HttpStatus.FOUND.value());
        response.sendRedirect(shortUrlMappingDO.getShortUrl());
    }

    @PostMapping
    public ShortUrlCodeVO create(@RequestBody ShortUrlCodeRequest request) {
        ShortUrlMappingDO shortUrlCode = shortUrlCodeService.createShortUrlCode(request);
        return new ShortUrlCodeVO(shortUrlCode.getShortUrlCode(), shortUrlCode.getShortUrl());
    }
}
