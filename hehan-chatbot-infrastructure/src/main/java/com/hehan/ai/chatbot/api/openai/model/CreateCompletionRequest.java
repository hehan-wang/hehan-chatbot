package com.hehan.ai.chatbot.api.openai.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
@Accessors(chain = true)
public class CreateCompletionRequest {

    /**
     * 模型
     */
    private String model = ModelConstant.TEXT_DAVINCI_003;

    /**
     * 提示词
     */
    private String prompt;

    private Integer max_tokens = 1024;

    private Integer temperature = 0;

    private Integer top_p;

    private Integer n;

    private Boolean stream;

    private Integer logprobs;

    private String stop;

}
