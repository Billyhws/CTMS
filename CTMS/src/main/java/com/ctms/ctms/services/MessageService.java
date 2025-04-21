package com.ctms.ctms.services;

import com.ctms.ctms.models.Agency;
import com.ctms.ctms.models.Customer;
import com.ctms.ctms.models.Message;
import com.ctms.ctms.models.message_type;
import com.ctms.ctms.repositories.AgencyRepo;
import com.ctms.ctms.repositories.CustomerRepo;
import com.ctms.ctms.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepo messageRepository;
    @Autowired
    private AgencyRepo agencyRepository;
    @Autowired
    private CustomerRepo customerRepository;

    public Message sendMessageFromCustomer(Long customerId, Long agencyId, String content) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Agency agency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        agency.setUnreadMessagesCount(agency.getUnreadMessagesCount() + 1);
        agencyRepository.save(agency);

        Message msg = new Message();
        msg.setSender_type(message_type.CUSTOMER);
        msg.setContent(content);
        msg.setCustomer(customer);
        msg.setAgency(agency);

        return messageRepository.save(msg);
    }

    public Message sendMessageFromAgency(Long agencyId, Long customerId, String content) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        Agency agency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        customer.setUnreadMessagesCount(customer.getUnreadMessagesCount() + 1);
        customerRepository.save(customer);

        Message msg = new Message();
        msg.setSender_type(message_type.AGENCY);
        msg.setContent(content);
        msg.setTimestamp(LocalDateTime.now());
        msg.setCustomer(customer);
        msg.setAgency(agency);

        return messageRepository.save(msg);
    }

    public void markMessagesAsReadForAgency(Long agencyId) {
        Agency agency = agencyRepository.findById(agencyId)
                .orElseThrow(() -> new RuntimeException("Agency not found"));

        agency.setUnreadMessagesCount(0);
        agencyRepository.save(agency);
    }
    public void markMessagesAsReadForCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        customer.setUnreadMessagesCount(0);
        customerRepository.save(customer);
    }

    public List<Message> getConversation(Long customerId, Long agencyId) {
        return messageRepository.findByAgency_idAndCustomer_id(customerId, agencyId);
    }
}
