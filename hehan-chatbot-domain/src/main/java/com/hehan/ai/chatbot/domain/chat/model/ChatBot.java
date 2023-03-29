package com.hehan.ai.chatbot.domain.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */

@Slf4j
@Data
@AllArgsConstructor(staticName = "of")
public class ChatBot {

    private Platform platform;
    private AnswerEngine answerEngine;

    public boolean doChat() {
        if (platform == null) {
            log.error("platform is null");
            return false;
        }
        if (answerEngine == null) {
            log.error("answerEngine is null");
            return false;
        }
        //1.收到问题
        Question question = platform.findQuestion();
        //2.进行回答
        Answer answer = answerEngine.doAnswer(question);
        //3.回复答案
        return platform.doReply(answer);
    }
}
