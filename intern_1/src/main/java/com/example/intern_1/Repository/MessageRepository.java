package com.example.intern_1.Repository;

import com.example.intern_1.Model.Message;
import com.example.intern_1.Model.EpollUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndReceiver(EpollUsers sender, EpollUsers receiver);
}