package com.ttc.testTaskChat.controller;

import com.ttc.testTaskChat.dto.createRequest.CreateMessageRequest;
import com.ttc.testTaskChat.dto.getRequest.GetAllMessageRequest;
import com.ttc.testTaskChat.entity.Message;
import com.ttc.testTaskChat.service.ChatService;
import com.ttc.testTaskChat.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    private final ChatService chatService;

    @PostMapping("/add")
    public int sendMessage(@RequestBody CreateMessageRequest createMessageRequest){
        return messageService.sendMessage(
                createMessageRequest.chatId(),
                createMessageRequest.userId(),
                createMessageRequest.txt()
        );
    }
    @PostMapping("/getAllMessages")
    public List<Message> getAllMessages(@RequestBody GetAllMessageRequest getAllMessageRequest){
        return chatService.getAllMessage(getAllMessageRequest.chatId());
    }
}