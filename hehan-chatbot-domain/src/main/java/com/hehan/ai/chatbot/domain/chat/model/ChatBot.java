package com.hehan.ai.chatbot.domain.chat.model;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.cola.domain.DomainFactory;
import com.alibaba.cola.domain.Entity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Collection;

/**
 * 聊天机器人聚合根
 *
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Data
@RequiredArgsConstructor(staticName = "of")
@Entity
public class ChatBot {
    private final Platform platform;
    private final AnswerEngine answerEngine;


    public boolean doChat() {
        if (platform == null) {
            log.error("platform is null");
            return false;
        }
        if (answerEngine == null) {
            log.error("answerEngine is null");
            return false;
        }
        boolean res = true;
        //1.收到问题
        Collection<Question> questions = platform.findQuestion();
        if (CollUtil.isEmpty(questions)) {
            log.info("no question");
            return false;
        }

        for (Question question : questions) {
            //2.进行回答
            // 问题之间随机暂停1-3s
            ThreadUtil.sleep(1000L + RandomUtil.randomInt(0, 2000));
            Answer answer = answerEngine.doAnswer(question);
            if (answer == null) {
                log.error("answer is null");
                res = false;
                continue;
            }
            answer.setTopicId(question.getTopicId());
            //3.回复答案
            res &= platform.doReply(answer);
        }
        return res;
    }

    public static ChatBot create(PlatformType platformType, AnswerEngineType answerEngineType) {
        Platform platform = DomainFactory.create(Platform.class).setPlatformType(platformType);
        AnswerEngine answerEngine = DomainFactory.create(AnswerEngine.class).setAnswerEngineType(answerEngineType);
        return of(platform, answerEngine);
    }

}
