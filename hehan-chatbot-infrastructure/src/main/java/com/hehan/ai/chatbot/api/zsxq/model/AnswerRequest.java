package com.hehan.ai.chatbot.api.zsxq.model;

import cn.hutool.core.collection.ListUtil;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Data
@Accessors(chain = true)
public class AnswerRequest {

    private String topicId;

    private ReqData req_data;

    @Data
    @Accessors(chain = true)
    public static class ReqData {

        private String text;

        private List<String> image_ids = ListUtil.empty();

        private Boolean silenced;
    }
}
