package com.example.intern_1.Controller;

import com.example.intern_1.Model.Message;
import com.example.intern_1.Model.EpollUsers;
import com.example.intern_1.Service.MessageService;
import com.example.intern_1.Service.UserService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/messages")
    public List<Message> getMessages(@RequestParam Integer senderId, @RequestParam Integer receiverId) {
        EpollUsers sender = userService.getUserById(senderId);
        EpollUsers receiver = userService.getUserById(receiverId);
        return messageService.getMessagesBetweenUsers(sender, receiver);
    }

    @PostMapping("/api/messages")
    public void sendMessage(@RequestBody MessageDto messageDto) {
        EpollUsers sender = userService.getUserById(messageDto.getSenderId());
        EpollUsers receiver = userService.getUserById(messageDto.getReceiverId());
        messageService.sendMessage(sender, receiver, messageDto.getContent());
    }

    @Getter
    @Setter
    public static class MessageDto {
        private Integer senderId;
        private Integer receiverId;
        private String content;
    }
}
