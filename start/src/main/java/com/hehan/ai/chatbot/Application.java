package com.hehan.ai.chatbot;

import cn.hutool.extra.spring.SpringUtil;
import com.hehan.ai.chatbot.config.OpenAiConfig;
import com.hehan.ai.chatbot.config.ZsxqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@Slf4j
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.hehan.ai.chatbot", "com.alibaba.cola"})
public class Application implements CommandLineRunner {

    public static void main(String[] args) throws UnknownHostException {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        Environment env = context.getEnvironment();
        log.info("\n----------------------------------------------------------\n\t"
                        + "Application '{}' is running! Access URLs:\n\t"
                        + "Local: \t\thttp://localhost:{}\n\t"
                        + "External: \thttp://{}:{}\n\t"
                        + "Profile: \t{}\n\t"
                        + "----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                env.getProperty("server.port"),
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                String.join(",", env.getActiveProfiles()));
    }

    @Override
    public void run(String... args) throws Exception {
        OpenAiConfig openAiConfig = SpringUtil.getBean(OpenAiConfig.class);
        ZsxqConfig zsxqConfig = SpringUtil.getBean(ZsxqConfig.class);
        log.info("open ai config {}", zsxqConfig);
        log.info("zsxq config {}", openAiConfig);
    }
}
