package com.hehan.ai.chatbot.domain.chat.model;

import com.alibaba.cola.domain.Entity;
import com.hehan.ai.chatbot.domain.chat.gateway.PlatformGateway;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Collection;

/**
 * 平台实体
 *
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
@Entity
@RequiredArgsConstructor
@Accessors(chain = true)
public class Platform {
    private final PlatformGateway platformGateway;
    private PlatformType platformType;

    public Collection<Question> findQuestion() {
        return platformGateway.findQuestion(platformType);
    }

    public boolean doReply(Answer answer) {
        return platformGateway.doReply(platformType, answer);
    }
}
