package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Message;
import com.ctms.ctms.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/message/send/customer")
    public ResponseEntity<Message> customerSend(@RequestParam Long customerId,
                                                @RequestParam Long agencyId,
                                                @RequestBody String content) {
        return ResponseEntity.ok(messageService.sendMessageFromCustomer(customerId, agencyId, content));
    }

    @PostMapping("/message/send/agency")
    public ResponseEntity<Message> agencySend(@RequestParam Long agencyId,
                                              @RequestParam Long customerId,
                                              @RequestBody String content) {
        return ResponseEntity.ok(messageService.sendMessageFromAgency(agencyId, customerId, content));
    }

    @GetMapping("/message/conversation")
    public ResponseEntity<List<Message>> conversation(@RequestParam Long customerId,
                                                      @RequestParam Long agencyId) {
        return ResponseEntity.ok(messageService.getConversation(customerId, agencyId));
    }
}
