package com.hehan.ai.chatbot.api.openai;

import com.hehan.ai.chatbot.api.openai.model.CreateCompletionRequest;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionResponse;
import com.plexpt.chatgpt.ChatGPT;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import com.plexpt.chatgpt.entity.chat.ChatCompletionResponse;
import com.plexpt.chatgpt.entity.chat.Message;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Ignore
public class OpenAiApiTest {
    @Test
    public void TestCreateCompletion() {
        CreateCompletionRequest req = new CreateCompletionRequest().setPrompt("写一个python helloworld程序");
        CreateCompletionResponse resp = OpenAiApi.createCompletion(req, "sk-1");
        System.out.println(resp);
    }

    @Test
    public void test1() {
        ChatGPT chatGPT = ChatGPT.builder()
                .apiKeyList(Arrays.asList(
                        "sk-1",
                        "sk-2"))
                .apiHost("https://api.openai.com/") //反向代理地址
                .build()
                .init();
        Message message = Message.of("写一段七言绝句诗，题目是：火锅！");
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .messages(Collections.singletonList(message))
                .maxTokens(3000)
                .temperature(0.9)
                .build();
        ChatCompletionResponse chatCompletionResponse = chatGPT.chatCompletion(chatCompletion);
        System.out.println(chatCompletionResponse);

        String answer = chatCompletionResponse.getChoices().stream()
                .map(e -> e.getMessage().getContent())
                .collect(Collectors.joining());
        System.out.println(answer);
    }
}
