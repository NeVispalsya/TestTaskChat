package com.ttc.testTaskChat.controller;

import com.ttc.testTaskChat.dto.createRequest.CreateChatRequest;
import com.ttc.testTaskChat.dto.getRequest.GetAllChatRequest;
import com.ttc.testTaskChat.entity.Chat;
import com.ttc.testTaskChat.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping("/add")
    public int createChat(@RequestBody CreateChatRequest createChatRequest){
        return chatService.createChat(createChatRequest.name(),createChatRequest.usersId());
    }

    @PostMapping("/by-user")
    public List<Chat> getAllChats(@RequestBody GetAllChatRequest getAllChatRequest){
        return chatService.getAllChatByUser(getAllChatRequest.userId());
    }
}
