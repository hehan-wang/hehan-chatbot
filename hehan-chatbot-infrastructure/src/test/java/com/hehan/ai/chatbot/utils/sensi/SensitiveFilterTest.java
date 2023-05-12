package com.hehan.ai.chatbot.utils.sensi;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled
public class SensitiveFilterTest {

    @Test
    public void testFilter() throws Exception {

        // 使用默认单例（加载默认词典）
        SensitiveFilter filter = SensitiveFilter.DEFAULT;
        // 待过滤的句子
        String sentence = "我玩法沦功";
        // 进行过滤
        String filted = filter.filter(sentence, '*');

        // 如果未过滤，则返回输入的String引用
        if (!sentence.equals(filted)) {
            // 句子中有敏感词
            System.out.println(filted);
        }

    }
}
