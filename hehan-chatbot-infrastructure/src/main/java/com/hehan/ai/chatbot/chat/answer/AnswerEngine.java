package com.hehan.ai.chatbot.chat.answer;

import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.Question;

/**
 * 回答引擎策略接口
 *
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public interface AnswerEngine {
    Answer doAnswer(Question question);

    AnswerEngineType getType();
}
