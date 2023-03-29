package com.hehan.ai.chatbot.domain.chat.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@AllArgsConstructor
public enum PlatformType {
    none("默认"),
    zsxq("知识星球"),
    ;
    @Getter
    private final String name;
}
