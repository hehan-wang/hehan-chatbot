package com.hehan.ai.chatbot.domain.chat.gateway.filter;

import cn.hutool.core.lang.Pair;
import com.hehan.ai.chatbot.domain.chat.model.Question;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public interface BotFilter {
    /**
     * 过滤
     *
     * @param question 问题
     * @return true为通过过滤 false为不通过过滤
     */
    Pair<Boolean, String> doFilter(Question question);

}
