package com.hehan.ai.chatbot.chat.platform;

import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;

import java.util.Collection;

/**
 * 平台策略接口
 *
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public interface Platform {
    Collection<Question> findQuestion();

    boolean doReply(Answer answer);

    PlatformType getType();
}
