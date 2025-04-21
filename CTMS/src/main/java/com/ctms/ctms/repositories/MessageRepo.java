package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepo extends JpaRepository<Message,Long> {

    @Query("SELECT p FROM Message p WHERE p.agency.agencyId = :agencyId and p.customer.id= : customerId")
    List<Message> findByAgency_idAndCustomer_id(Long customerId,Long agencyId);
}
