package com.ttc.testTaskChat;

import com.ttc.testTaskChat.entity.Chat;
import com.ttc.testTaskChat.entity.Message;
import com.ttc.testTaskChat.entity.User;
import com.ttc.testTaskChat.repository.ChatRepository;
import com.ttc.testTaskChat.repository.MessageRepository;
import com.ttc.testTaskChat.repository.UserRepository;
import com.ttc.testTaskChat.service.MessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class TestTaskChatApplicationTests {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Test
    void createUser_success(){
        User user = new User();
        user.setUsername("test_user");
        user = userRepository.save(user);
        Optional<User> savedUsers = userRepository.findById(user.getId());
        assertTrue(savedUsers.isPresent());
        assertEquals("test_user", savedUsers.get().getUsername());
    }

    @Test
    void createChat_success(){
        User user = new User();
        user.setUsername("test_user");
        user = userRepository.save(user);

        Chat chat = new Chat();
        chat.setName("test_chat");
        chat.setUsers(List.of(user));
        chat = chatRepository.save(chat);

        Optional<Chat> savedChats = chatRepository.findById(chat.getId());
        assertTrue(savedChats.isPresent());
        assertEquals("test_chat", savedChats.get().getName());
        assertEquals(chat.getId(), savedChats.get().getId());
        assertEquals(user.getId(), savedChats.get().getUsers().getFirst().getId());
    }

    @Test
    void sendMessage_success() {
        User user = new User();
        user.setUsername("test_user");
        user = userRepository.save(user);

        Chat chat = new Chat();
        chat.setName("test_chat");
        chat.setUsers(List.of(user));
        chat = chatRepository.save(chat);

        int messageId = messageService.sendMessage(chat.getId(), user.getId(),"hello");
        Optional<Message> savedMessage = messageRepository.findById(messageId);

        assertTrue(savedMessage.isPresent());
        assertEquals("hello", savedMessage.get().getText());
        assertEquals(chat.getId(), savedMessage.get().getChat().getId());
        assertEquals(user.getId(), savedMessage.get().getAuthor().getId());
    }

}
