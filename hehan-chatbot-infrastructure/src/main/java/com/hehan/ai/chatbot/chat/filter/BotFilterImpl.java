package com.hehan.ai.chatbot.chat.filter;

import cn.hutool.core.lang.Pair;
import com.hehan.ai.chatbot.domain.chat.gateway.filter.BotFilter;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import com.hehan.ai.chatbot.utils.sensi.SensitiveFilter;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class BotFilterImpl implements BotFilter {
    @Override
    public Pair<Boolean, String> doFilter(Question question) {
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        String before = question.getContent();
        String after = filter.filter(before, '*');
        // 句子中有敏感词
        if (!before.equals(after)) {
            log.info("句子中有敏感词：{}", before);
            return Pair.of(false, "您的问题中有敏感词，请重新输入");
        }
        return Pair.of(true, after);
    }
}
