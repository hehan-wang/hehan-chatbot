package com.hehan.ai.chatbot.scheduler;

import com.hehan.ai.chatbot.domain.chat.model.AnswerEngineType;
import com.hehan.ai.chatbot.domain.chat.model.PlatformType;
import lombok.Data;

/**
 * 单个任务配置
 */
@Data
public class SchedulerItem {

    private String name = "";

    private String cron = "0/30 * * * * ?";

    private AnswerEngineType answer = AnswerEngineType.openai;

    private PlatformType platform = PlatformType.zsxq;
}