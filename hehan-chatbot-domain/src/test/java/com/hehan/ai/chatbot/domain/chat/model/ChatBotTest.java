package com.hehan.ai.chatbot.domain.chat.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ChatBotTest {

    @Mock
    private Platform platform;

    @Mock
    private AnswerEngine answerEngine;

    private ChatBot chatBot;

    private Collection<Question> questions;
    private Question question;
    private Answer answer;

    @BeforeEach
    public void setUp() {
        question = new Question().setTopicId("1").setContent("Test question");
        answer = new Answer().setTopicId("1").setContent("Test answer");
        questions = Arrays.asList(question);
        chatBot = ChatBot.of(platform, answerEngine);
    }

    @Test
    public void testDoChat_whenPlatformIsNull() {
        ChatBot chatBotWithNullPlatform = ChatBot.of(null, answerEngine);
        assertFalse(chatBotWithNullPlatform.doChat());
    }

    @Test
    public void testDoChat_whenAnswerEngineIsNull() {
        ChatBot chatBotWithNullAnswerEngine = ChatBot.of(platform, null);
        assertFalse(chatBotWithNullAnswerEngine.doChat());
    }

    @Test
    public void testDoChat_whenNoQuestions() {
        when(platform.findQuestion()).thenReturn(Collections.emptyList());
        assertFalse(chatBot.doChat());
    }

    @Test
    public void testDoChat_whenAnswerIsNull() {
        when(platform.findQuestion()).thenReturn(questions);
        when(answerEngine.doAnswer(question)).thenReturn(null);
        assertFalse(chatBot.doChat());
    }

    @Test
    public void testDoChat_whenReplyFails() {
        when(platform.findQuestion()).thenReturn(questions);
        when(answerEngine.doAnswer(question)).thenReturn(answer);
        when(platform.doReply(answer)).thenReturn(false);
        assertFalse(chatBot.doChat());
    }

    @Test
    public void testDoChat_success() {
        when(platform.findQuestion()).thenReturn(questions);
        when(answerEngine.doAnswer(question)).thenReturn(answer);
        when(platform.doReply(answer)).thenReturn(true);
        assertTrue(chatBot.doChat());
    }
}
