package com.ttc.testTaskChat.dto.createRequest;

import java.util.List;

public record CreateChatRequest(String name, List<Integer> usersId) {
}
