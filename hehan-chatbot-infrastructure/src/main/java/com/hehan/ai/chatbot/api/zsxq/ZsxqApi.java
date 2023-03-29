package com.hehan.ai.chatbot.api.zsxq;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.alibaba.cola.exception.BizException;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerRequest;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerResponse;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsRequest;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsResponse;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
public class ZsxqApi {

    private static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:109.0) Gecko/20100101 Firefox/111.0";

    /**
     * 获取主题列表
     */
    public static ListTopicsResponse listTopics(ListTopicsRequest request, String cookie) {
        String groupId = request.getGroupId();
        if (StrUtil.isBlank(groupId)) {
            throw new BizException("no groupId");
        }
        if (StrUtil.isBlank(cookie)) {
            throw new BizException("no cookie");
        }
        String url = String.format("https://api.zsxq.com/v2/groups/%s/topics", groupId);
        Map<String, Object> stringObjectMap = BeanUtil.beanToMap(request);
        String query = URLUtil.buildQuery(stringObjectMap, StandardCharsets.UTF_8);
        String result = HttpRequest.get(url)
                .header("cookie", cookie)
                .header("user-agent", USER_AGENT)
                .body(query)
                .execute()
                .body();
        return JSONUtil.toBean(result, ListTopicsResponse.class);
    }

    /**
     * 回答问题
     */
    public static AnswerResponse reply(AnswerRequest request, String cookie) {
        String topicId = request.getTopicId();
        if (StrUtil.isBlank(topicId)) {
            throw new BizException("no topicId");
        }
        if (StrUtil.isBlank(cookie)) {
            throw new BizException("no cookie");
        }
        String url = String.format("https://api.zsxq.com/v2/topics/%s/answer", topicId);
        String json = JSONUtil.toJsonStr(request);
        String result = HttpRequest.post(url)
                .header("cookie", cookie)
                .header("user-agent", USER_AGENT)
                .body(json)
                .execute()
                .body();
        return JSONUtil.toBean(result, AnswerResponse.class);
    }
}

