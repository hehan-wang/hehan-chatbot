package com.hehan.ai.chatbot.domain.chat.model;

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
public class Question {
    private String topicId;
    private String content;
}
