package com.hehan.ai.chatbot.chat.answer;

import com.hehan.ai.chatbot.api.openai.OpenAiApi;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionRequest;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionResponse;
import com.hehan.ai.chatbot.config.OpenAiConfig;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
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
public class OpenAiAnswerEngine implements AnswerEngine {
    private final OpenAiConfig openAiConfig;

    @Override
    public Answer doAnswer(Question question) {
        CreateCompletionRequest req = new CreateCompletionRequest()
                .setPrompt(question.getContent())
                .setModel(openAiConfig.getModel());
        CreateCompletionResponse resp = OpenAiApi.createCompletion(req, openAiConfig.getApiKey());
        log.info("using openai answer engine question:{}, req:{} resp:{}", question, req, resp);
        List<CreateCompletionResponse.ChoicesItem> choicesItemList = resp.getChoices();
        String answer = choicesItemList.stream()
                .map(CreateCompletionResponse.ChoicesItem::getText)
                .collect(Collectors.joining());
        return new Answer().setTopicId(question.getTopicId()).setContent(answer);
    }

    @Override
    public AnswerEngineType getType() {
        return AnswerEngineType.openai;
    }
}
