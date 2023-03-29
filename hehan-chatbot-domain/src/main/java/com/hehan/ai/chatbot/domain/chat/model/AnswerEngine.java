package com.hehan.ai.chatbot.domain.chat.model;

import com.alibaba.cola.domain.Entity;
import com.hehan.ai.chatbot.domain.chat.gateway.AnswerEngineGateway;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 回答引擎实体
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
public class AnswerEngine {
    private final AnswerEngineGateway answerEngineGateway;
    private AnswerEngineType answerEngineType;

    public Answer doAnswer(Question question) {
        return answerEngineGateway.doAnswer(answerEngineType, question);
    }
}
