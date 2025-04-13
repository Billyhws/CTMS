package com.ctms.ctms.repositories;

import com.ctms.ctms.models.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AgencyRepo extends JpaRepository<Agency,Long> {
    Optional<Agency> findByName(String name);
}
