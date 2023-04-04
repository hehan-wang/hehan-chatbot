package com.hehan.ai.chatbot.config;

import com.hehan.ai.chatbot.api.openai.model.ModelConstant;
import com.plexpt.chatgpt.entity.chat.ChatCompletion;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Configuration
@ConfigurationProperties(prefix = "openai")
@Data
public class OpenAiConfig {
    /**
     * 模型
     */
    private String model = ChatCompletion.Model.GPT_3_5_TURBO.getName();

    /**
     * apiKey
     */
    private String apiKey;
}
