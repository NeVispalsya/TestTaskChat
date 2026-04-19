package com.ttc.testTaskChat.dto.createRequest;

public record CreateMessageRequest(int chatId, int userId, String txt) {
}
