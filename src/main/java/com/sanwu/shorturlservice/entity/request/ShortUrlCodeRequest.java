package com.sanwu.shorturlservice.entity.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ShortUrlCodeRequest {

    @NotNull(message = "userId null")
    private Long userId;

    @NotBlank(message = "originUrl blank")
    private String originUrl;

    private String activityType;

    private long activityId;

}
