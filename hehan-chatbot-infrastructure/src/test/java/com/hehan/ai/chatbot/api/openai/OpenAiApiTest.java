package com.hehan.ai.chatbot.api.openai;

import com.hehan.ai.chatbot.api.openai.model.CreateCompletionRequest;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionResponse;
import org.junit.Test;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public class OpenAiApiTest {
    @Test
    public void TestCreateCompletion() {
        CreateCompletionRequest req = new CreateCompletionRequest().setPrompt("写一个python helloworld程序");
        CreateCompletionResponse resp = OpenAiApi.createCompletion(req, "sk-1");
        System.out.println(resp);
    }
}
