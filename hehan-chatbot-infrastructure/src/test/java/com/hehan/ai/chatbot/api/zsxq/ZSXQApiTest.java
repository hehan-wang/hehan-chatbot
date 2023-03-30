package com.hehan.ai.chatbot.api.zsxq;

import cn.hutool.json.JSONUtil;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerRequest;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerResponse;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsRequest;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsResponse;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Ignore
public class ZSXQApiTest {
    String cookie = "";

    @Test
    public void testListTopics() {
        ListTopicsRequest req = new ListTopicsRequest().setGroupId("48884855812548");
        ListTopicsResponse response = ZsxqApi.listTopics(req, cookie);
        System.out.println(JSONUtil.toJsonStr(response));
    }

    @Test
    public void testReply() {
        String topicId = "181452811588542";
        String content = "测试回复";
        AnswerRequest req = new AnswerRequest()
                .setTopicId(topicId)
                .setReq_data(new AnswerRequest.ReqData().setText(content).setSilenced(false));
        AnswerResponse response = ZsxqApi.reply(req, cookie);
        System.out.println(JSONUtil.toJsonStr(response));
    }
}
