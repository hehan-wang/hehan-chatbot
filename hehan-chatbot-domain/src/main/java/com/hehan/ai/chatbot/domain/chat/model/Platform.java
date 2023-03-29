package com.hehan.ai.chatbot.domain.chat.model;

import com.hehan.ai.chatbot.domain.chat.gateway.PlatformGateway;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
@AllArgsConstructor
public class Platform {
    private PlatformGateway platformGateway;
    private PlatformType platformType;

    public Question findQuestion() {
        return platformGateway.findQuestion(platformType);
    }

    public boolean doReply(Answer answer) {
        return platformGateway.doReply(platformType, answer);
    }
}
