package com.hehan.ai.chatbot.api.zsxq;

import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsRequest;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsResponse;
import org.junit.Test;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public class ZSXQApiTest {
    @Test
    public void testListTopics() {
        String cookie = "";
        ListTopicsRequest req = new ListTopicsRequest().setGroupId("48884855812548");
        ListTopicsResponse response = ZsxqApi.listTopics(req, cookie);
        System.out.println(response);
    }
}
