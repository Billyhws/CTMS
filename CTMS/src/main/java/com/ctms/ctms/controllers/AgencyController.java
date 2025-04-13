package com.ctms.ctms.controllers;

import com.ctms.ctms.models.*;
import com.ctms.ctms.services.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @PostMapping("/agencies")
    public ResponseEntity<Agency> addAgencyHandler(@RequestBody Agency agency) {
        return new ResponseEntity<>(agencyService.addAgency(agency), HttpStatus.CREATED);
    }

    @DeleteMapping("/agency/{id}")
    public ResponseEntity<String> deleteAgencyHandler(@PathVariable("id") Long id) {
        return new ResponseEntity<>(agencyService.deleteAgency(id), HttpStatus.OK);
    }

    @GetMapping("/agencies")
    public ResponseEntity<List<Agency>> getAllAgenciesHandler() {
        return new ResponseEntity<>(agencyService.getAllAgencies(), HttpStatus.OK);
    }

    @PutMapping("/agency/{id}")
    public ResponseEntity<Agency> updateAgencyHandler(@RequestBody() Agency agency, @PathVariable("id") Long id) {
        return new ResponseEntity<>(agencyService.updateAgency(agency,id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Agency> getAgencyByNameHandler(@PathVariable("name") String name){
        return new ResponseEntity<>(agencyService.getAgencyByName(name), HttpStatus.OK);
    }

    @GetMapping("/agency/{id}")
    public ResponseEntity<Agency> getAgencyHandler(@PathVariable("id") Long id){
        return new ResponseEntity<>(agencyService.getAgencyById(id), HttpStatus.OK);
    }

}
