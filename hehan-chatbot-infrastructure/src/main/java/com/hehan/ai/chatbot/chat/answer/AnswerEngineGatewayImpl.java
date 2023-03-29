package com.hehan.ai.chatbot.chat.answer;

import com.hehan.ai.chatbot.domain.chat.gateway.AnswerEngineGateway;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
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
public class AnswerEngineGatewayImpl implements AnswerEngineGateway {
    private final List<AnswerEngine> answerEngineList;
    private Map<AnswerEngineType, AnswerEngine> answerEngineMap;

    @PostConstruct
    public void init() {
        answerEngineMap = answerEngineList.stream().collect(Collectors.toMap(AnswerEngine::getType, Function.identity()));
    }

    @Override
    public Answer doAnswer(AnswerEngineType answerEngineType, Question question) {
        return getAnswerEngine(answerEngineType).doAnswer(question);
    }

    public AnswerEngine getAnswerEngine(AnswerEngineType answerEngineType) {
        return answerEngineMap.getOrDefault(answerEngineType, answerEngineMap.get(AnswerEngineType.none));
    }
}
