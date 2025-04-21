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
        return agencyRepo.findById(id).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
    }

    public  Agency getAgencyByName(String name){
        return agencyRepo.findByName(name).orElseThrow(() -> new AgencyNotFoundException("Agency not found"));
    }

    /*
    public User register(User user) {
        if(checkIfUserExist(user.getEmail())) {
            throw new UserAlreadyExistException("User already exists for this email");
        }
        user.setPasswordHash(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        sendRegistrationConfirmationEmail(user);
        return newUser;
    }

    public boolean checkIfUserExist(String email){
        return userRepository.findByEmail(email) != null;
    }


    public void sendRegistrationConfirmationEmail(User user) {
        SecureToken secureToken = secureTokenService.createSecureToken();
        secureToken.setUser(user);
        secureTokenRepository.save(secureToken);

        AccountVerificationEmailContext emailContext = new AccountVerificationEmailContext();
        emailContext.init(user);
        emailContext.setToken(secureToken.getToken());
        emailContext.buildVerificationUrl(baseURL, secureToken.getToken());
        try {
            emailService.sendMail(emailContext);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String token) {
        SecureToken secureToken = secureTokenService.findByToken(token);
        if(Objects.isNull(secureToken) || !StringUtils.equals(token, secureToken.getToken()) || secureToken.isExpired()) {
            throw new InvalidTokenException("Token has expired or not valid");
        }

        User user = userRepository.getOne(secureToken.getUser().getId());
        if(Objects.isNull(user)){
            throw new InvalidTokenException("User does not exist");
        }

        user.setAccountVerified(true);
        userRepository.save(user);

        secureTokenService.removeToken(secureToken);
        return  true;
    }

}*/




}
