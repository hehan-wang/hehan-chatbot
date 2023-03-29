package com.hehan.ai.chatbot.api.zsxq.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
@Accessors(chain = true)
public class ListTopicsRequest {

    /**
     * 星球 id
     */
    private String groupId;

    /**
     * 主题范围
     */
    private String scope = "unanswered_questions";

    /**
     * 单页数量
     */
    private Integer count = 20;

}
