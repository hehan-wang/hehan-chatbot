package com.hehan.ai.chatbot.scheduler;

import com.hehan.ai.chatbot.domain.chat.model.ChatBot;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@Slf4j
@Component
@Configuration
@ConfigurationProperties(prefix = "scheduler")
@Data
public class ChatBotScheduler implements SchedulingConfigurer {
    private List<SchedulerItem> list;

    public Runnable doChat(SchedulerItem item) {
        return () -> {
            long begin = System.currentTimeMillis();
            log.info("do schedule begin:{}", LocalDateTime.now());
            boolean result = ChatBot.create(item.getPlatform(), item.getAnswer()).doChat();
            log.info("do schedule end result:{} cost:{} ms", result, System.currentTimeMillis() - begin);
        };
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        log.info("configureTasks begin");
        for (SchedulerItem item : list) {
            taskRegistrar.addCronTask(doChat(item), item.getCron());
        }
        log.info("configureTasks end");
    }
}
