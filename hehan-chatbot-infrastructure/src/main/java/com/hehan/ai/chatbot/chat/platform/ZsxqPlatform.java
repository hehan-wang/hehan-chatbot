package com.hehan.ai.chatbot.chat.platform;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import com.hehan.ai.chatbot.api.zsxq.ZsxqApi;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerRequest;
import com.hehan.ai.chatbot.api.zsxq.model.AnswerResponse;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsRequest;
import com.hehan.ai.chatbot.api.zsxq.model.ListTopicsResponse;
import com.hehan.ai.chatbot.config.ZsxqConfig;
import com.hehan.ai.chatbot.domain.chat.model.Answer;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import com.hehan.ai.chatbot.domain.chat.model.Question;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
public class ZsxqPlatform implements Platform {
    private final ZsxqConfig zsxqConfig;

    @Override
    public Collection<Question> findQuestion() {
        ListTopicsRequest listTopicsRequest = new ListTopicsRequest().setGroupId(zsxqConfig.getGroupId());
        ListTopicsResponse listTopicsResponse = ZsxqApi.listTopics(listTopicsRequest, zsxqConfig.getCookie());
        log.info("listTopics req:{} resp:{}", listTopicsRequest, listTopicsResponse);
        List<ListTopicsResponse.TopicsItem> topics = listTopicsResponse.getRespData().getTopics();
        if (CollUtil.isEmpty(topics)) {
            return ListUtil.empty();
        }
        return topics.stream()
                .map(e -> new Question()
                        .setContent(e.getQuestion().getText())
                        .setTopicId(e.getTopicId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean doReply(Answer answer) {
        AnswerRequest req = new AnswerRequest()
                .setTopicId(answer.getTopicId())
                .setReq_data(new AnswerRequest.ReqData()
                        .setSilenced(zsxqConfig.getSilenced())
                        .setText(answer.getContent()));
        AnswerResponse resp = ZsxqApi.reply(req, zsxqConfig.getCookie());
        log.info("reply req:{} resp:{}", req, resp);
        return resp.isSucceeded();
    }

    @Override
    public PlatformType getType() {
        return PlatformType.zsxq;
    }
}
