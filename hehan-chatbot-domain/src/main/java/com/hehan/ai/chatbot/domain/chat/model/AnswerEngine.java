package com.hehan.ai.chatbot.domain.chat.model;

import com.hehan.ai.chatbot.domain.chat.gateway.AnswerEngineGateway;
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
public class AnswerEngine {
    private AnswerEngineGateway answerEngineGateway;
    private AnswerEngineType answerEngineType;

    public Answer doAnswer(Question question) {
        return answerEngineGateway.doAnswer(answerEngineType, question);
    }
}
