package com.ttc.testTaskChat.repository;

import com.ttc.testTaskChat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    boolean existsByIdAndUsers_Id(int chatId, int userId);
    List<Chat> findByUsers_IdOrderByCreatedAtAsc(int userId);
}
