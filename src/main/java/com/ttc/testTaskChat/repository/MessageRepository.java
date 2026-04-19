package com.ttc.testTaskChat.repository;

import com.ttc.testTaskChat.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByChatIdOrderByCreatedAtAsc(int chatId);
}
