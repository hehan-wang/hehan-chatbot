package com.hehan.ai.chatbot.chat.answer;

import cn.hutool.core.util.StrUtil;
import com.hehan.ai.chatbot.config.OpenAiConfig;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collections;
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
    private ChatGPT chatGPT;

    private ChatCompletion.Model model = ChatCompletion.Model.GPT_3_5_TURBO;

    @PostConstruct
    public void init() {
        List<String> keys = StrUtil.split(openAiConfig.getApiKey(), ",");
        chatGPT = ChatGPT.builder()
                .apiKeyList(keys)
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();
        model = Arrays.stream(ChatCompletion.Model.values())
                .filter(e -> e.getName().equals(openAiConfig.getModel()))
                .findFirst().orElseThrow(() -> new RuntimeException("model not found"));
        log.info("openai init success model:{} keys:{}", model, keys);
    }

    @Override
    public Answer doAnswer(Question question) {
        Message message = Message.of(question.getContent());
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Collections.singletonList(message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();
        ChatCompletionResponse chatCompletionResponse = chatGPT.chatCompletion(chatCompletion);
        String answer = chatCompletionResponse.getChoices().stream()
                .map(e -> e.getMessage().getContent())
                .collect(Collectors.joining());
        return new Answer().setTopicId(question.getTopicId()).setContent(answer);
    }

    @Override
    public AnswerEngineType getType() {
        return AnswerEngineType.openai;
    }
}
