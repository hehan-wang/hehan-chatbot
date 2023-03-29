package com.hehan.ai.chatbot.chat.answer;

import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Service
public class DefaultAnswerEngine implements AnswerEngine {
    @Override
    public Answer doAnswer(Question question) {
        log.info("using default answer engine question:{}", question);
        return new Answer().setContent("im default answer");
    }

    @Override
    public AnswerEngineType getType() {
        return AnswerEngineType.none;
    }
}
