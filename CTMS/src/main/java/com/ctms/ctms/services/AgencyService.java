package com.ctms.ctms.services;

import com.ctms.ctms.exception.AgencyNotFoundException;
import com.ctms.ctms.models.Agency;
import com.ctms.ctms.repositories.AgencyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AgencyService {

    @Autowired
    private AgencyRepo agencyRepo;

    public Agency updateAgency(Agency agency1,Long id) {

        Agency agency = agencyRepo.findById(id)
                .orElseThrow(() -> new AgencyNotFoundException("Agency not found"));

        agency.setName(agency1.getName());
        agency.setAddress(agency1.getAddress());
        agency.setPhone(agency1.getPhone());
        agency.setEmail(agency1.getEmail());
        agency.setPassword(agency1.getPassword());

        return agencyRepo.save(agency);

    }

    public String deleteAgency(Long id) {
        Agency agency = agencyRepo.findById(id).orElseThrow(() -> new AgencyNotFoundException("Agency with ID " + id + " not found"));
        agencyRepo.delete(agency);
        return "Agency deleted successfully.";
    }

    public List<Agency> getAllAgencies() {
        List<Agency> agency = agencyRepo.findAll();

        if (agency.isEmpty()) {
            throw new AgencyNotFoundException("No agency found.");
        }

        return agency;
    }

    public Agency addAgency(Agency agency) {
        return agencyRepo.save(agency);
    }

    public  Agency getAgencyById(Long id){
        Agency agency = agencyRepo.findById(id).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
        return agency;
    }

    public  Agency getAgencyByName(String name){
        Agency agency = agencyRepo.findByName(name).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
        return agency;
    }




}
