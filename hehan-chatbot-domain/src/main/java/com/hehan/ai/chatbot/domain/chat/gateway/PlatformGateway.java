package com.hehan.ai.chatbot.domain.chat.gateway;

import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public interface PlatformGateway {
    Question findQuestion(PlatformType platformType);

    boolean doReply(PlatformType platformType, Answer answer);
}
