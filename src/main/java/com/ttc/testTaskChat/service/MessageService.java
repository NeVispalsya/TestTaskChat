package com.ttc.testTaskChat.service;

import com.ttc.testTaskChat.entity.Chat;
import com.ttc.testTaskChat.entity.Message;
import com.ttc.testTaskChat.entity.User;
import com.ttc.testTaskChat.exception.NotFoundException;
import com.ttc.testTaskChat.repository.ChatRepository;
import com.ttc.testTaskChat.repository.MessageRepository;
import com.ttc.testTaskChat.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final ChatRepository chatRepository;
    private  final UserRepository userRepository;
    public MessageService(MessageRepository messageRepository,
                          ChatRepository chatRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public int sendMessage(int chatId, int userId, String txt){
        if (!chatRepository.existsByIdAndUsers_Id(chatId, userId)) {
            throw new NotFoundException("User not in this chat");
        }
        Chat chat = chatRepository.getReferenceById(chatId);
        User user = userRepository.getReferenceById(userId);
        Message message = new Message(chat,user,txt);
        return messageRepository.save(message).getId();

    }
}
