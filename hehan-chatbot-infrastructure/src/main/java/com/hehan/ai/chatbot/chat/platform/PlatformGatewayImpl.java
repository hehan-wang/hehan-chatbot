package com.hehan.ai.chatbot.chat.platform;

import com.hehan.ai.chatbot.domain.chat.gateway.PlatformGateway;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PlatformGatewayImpl implements PlatformGateway {
    private final List<Platform> platformList;
    private Map<PlatformType, Platform> platformMap;

    @PostConstruct
    public void init() {
        platformMap = platformList.stream().collect(Collectors.toMap(Platform::getType, Function.identity()));
    }

    @Override
    public Collection<Question> findQuestion(PlatformType platformType) {
        return getPlatform(platformType).findQuestion();
    }

    @Override
    public boolean doReply(PlatformType platformType, Answer answer) {
        return getPlatform(platformType).doReply(answer);
    }

    public Platform getPlatform(PlatformType platformType) {
        return platformMap.getOrDefault(platformType, platformMap.get(PlatformType.demo));
    }
}
