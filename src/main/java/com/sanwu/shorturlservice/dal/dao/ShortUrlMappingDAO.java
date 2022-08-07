package com.sanwu.shorturlservice.dal.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sanwu.shorturlservice.dal.entity.ShortUrlMappingDO;
import lombok.NonNull;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShortUrlMappingDAO extends BaseMapper<ShortUrlMappingDO> {

    String SHORT_URL_CODE = "short_url_code";
    String ORIGIN_URL_HASH = "origin_url_hash";
    String USER_ID = "user_id";

    default ShortUrlMappingDO queryByShortUrlCode(@NonNull String shortUrlCode) {
        QueryWrapper<ShortUrlMappingDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SHORT_URL_CODE, shortUrlCode);
        return selectOne(queryWrapper);
    }

    default ShortUrlMappingDO queryByCondition(@NonNull Long userId, @NonNull String originUrlCodeHash) {
        QueryWrapper<ShortUrlMappingDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(USER_ID, userId);
        queryWrapper.eq(ORIGIN_URL_HASH, originUrlCodeHash);
        return selectOne(queryWrapper);
    }
}
