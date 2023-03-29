package com.hehan.ai.chatbot.chat.platform;

import cn.hutool.core.collection.ListUtil;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Service
public class DefaultPlatform implements Platform {

    @Override
    public Collection<Question> findQuestion() {
        return ListUtil.of(new Question().setContent("im default question"));
    }

    @Override
    public boolean doReply(Answer answer) {
        log.info("using default platform ,answer:{}", answer);
        return true;
    }

    @Override
    public PlatformType getType() {
        return PlatformType.none;
    }
}
