package com.ctms.ctms.controllers;

import com.ctms.ctms.models.Agency;
import com.ctms.ctms.models.Customer;
import com.ctms.ctms.models.Message;
import com.ctms.ctms.repositories.AgencyRepo;
import com.ctms.ctms.repositories.CustomerRepo;
import com.ctms.ctms.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private AgencyRepo agencyRepo;
    @Autowired
    private CustomerRepo customerRepo;

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
    @GetMapping("/{agencyId}/unread-messages-count")
    public ResponseEntity<Integer> getUnreadMessagesCountForAgency(@PathVariable Long agencyId) {
        Agency agency = agencyRepo.findById(agencyId).orElseThrow(() -> new RuntimeException("Agency not found"));;
        return ResponseEntity.ok(agency.getUnreadMessagesCount());
    }
    @GetMapping("/{customerId}/unread-messages-count")
    public ResponseEntity<Integer> getUnreadMessagesCountForCustomer(@PathVariable Long customerId) {
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));;
        return ResponseEntity.ok(customer.getUnreadMessagesCount());
    }

    @PutMapping("/{agencyId}/mark-messages-read")
    public ResponseEntity<Void> markMessagesAsReadForAgency(@PathVariable Long agencyId) {
        messageService.markMessagesAsReadForAgency(agencyId);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/{customerId}/mark-messages-read")
    public ResponseEntity<Void> markMessagesAsReadForCustomer(@PathVariable Long customerId) {
        messageService.markMessagesAsReadForCustomer(customerId);
        return ResponseEntity.ok().build();
    }


}
