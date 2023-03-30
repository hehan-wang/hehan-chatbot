package com.hehan.ai.chatbot.web;

import com.alibaba.cola.dto.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 鹤涵，微信：hehan4096
 * @description
 * @github <a href="https://github.com/hehan-wang">hehan</a>
 * @Copyright 公众号：程序员鹤涵
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public Response index() {
        return Response.buildSuccess();
    }
}
