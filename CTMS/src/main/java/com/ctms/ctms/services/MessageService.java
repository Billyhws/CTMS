package com.ctms.ctms.services;

import com.ctms.ctms.models.Message;
import com.ctms.ctms.models.message_type;
import com.ctms.ctms.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepository;

    public Message sendMessageFromCustomer(Long customerId, Long agencyId, String content) {
        Message msg = new Message();
        msg.setSender_type(message_type.CUSTOMER);
        msg.setCustomer_id(customerId);
        msg.setAgency_id(agencyId);
        msg.setContent(content);
        msg.setTimestamp(LocalDateTime.now());

        return messageRepository.save(msg);
    }

    public Message sendMessageFromAgency(Long agencyId, Long customerId, String content) {
        Message msg = new Message();
        msg.setSender_type(message_type.AGENCY);
        msg.setCustomer_id(customerId);
        msg.setAgency_id(agencyId);
        msg.setContent(content);
        msg.setTimestamp(LocalDateTime.now());

        return messageRepository.save(msg);
    }

    public List<Message> getConversation(Long customerId, Long agencyId) {
        return messageRepository.findByAgency_idAndCustomer_id(customerId,agencyId);
    }
}
