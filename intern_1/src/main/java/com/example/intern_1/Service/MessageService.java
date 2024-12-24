package com.example.intern_1.Service;


import com.example.intern_1.Model.Message;
import com.example.intern_1.Model.EpollUsers;
import com.example.intern_1.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getMessagesBetweenUsers(EpollUsers sender, EpollUsers receiver) {
        return messageRepository.findBySenderAndReceiver(sender, receiver);
    }

    public void sendMessage(EpollUsers sender, EpollUsers receiver, String content) {
        Message message = new Message();
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setContent(content);
        message.setTimestamp(LocalDateTime.now());
        messageRepository.save(message);
    }
}
