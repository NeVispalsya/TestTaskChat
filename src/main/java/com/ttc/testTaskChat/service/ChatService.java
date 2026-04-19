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

import java.util.List;


@Service
public class ChatService {
    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public ChatService(ChatRepository chatRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }
    @Transactional
    public int createChat(String name, List<Integer> usersId){
        List<User> u =userRepository.findAllById(usersId);
        if (u.size() != usersId.size()) {
            throw new NotFoundException("Someone users not found");
        }
        Chat chat = new Chat();
        chat.setName(name);
        chat.setUsers(u);
        return chatRepository.save(chat).getId();
    }
    public Chat findChatById(int id){
        return chatRepository.findById(id).
                orElseThrow(()-> new NotFoundException("Not founds chat"));
    }
    public List<Message> getAllMessage(int chatId){
        return messageRepository.findByChatIdOrderByCreatedAtAsc(chatId);

    }
    public List<Chat> getAllChatByUser(int userId){
        return chatRepository.findByUsers_IdOrderByCreatedAtAsc(userId);
    }
}
