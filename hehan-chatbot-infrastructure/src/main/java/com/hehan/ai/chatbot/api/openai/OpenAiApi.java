package com.hehan.ai.chatbot.api.openai;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.cola.exception.BizException;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionRequest;
import com.hehan.ai.chatbot.api.openai.model.CreateCompletionResponse;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public class OpenAiApi {

    /**
     * 补全
     */
    public static CreateCompletionResponse createCompletion(CreateCompletionRequest request, String openAiApiKey) {
        if (StrUtil.isBlank(openAiApiKey)) {
            throw new BizException("no openAiApiKey");
        }
        String url = "https://api.openai.com/v1/completions";
        String json = JSONUtil.toJsonStr(request);
        String result = HttpRequest.post(url)
                .header("Authorization", "Bearer " + openAiApiKey)
                .body(json)
                .execute()
                .body();
        return JSONUtil.toBean(result, CreateCompletionResponse.class);
    }
}
