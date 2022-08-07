package com.sanwu.shorturlservice.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_short_url_mapping")
public class ShortUrlMappingDO {

    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private String activityType;

    private Long referenceId;

    private String shortUrlCode;

    private String shortUrl;

    private String originUrl;

    private String originUrlHash;

    private Date createdTime;

    private Date modifiedTime;

    @Version
    private Integer version;

}
