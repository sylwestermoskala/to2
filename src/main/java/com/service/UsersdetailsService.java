package com.service;

import com.domain.Usersdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repository.UsersdetailsRepository;


@Service
public class UsersdetailsService {

    @Autowired
    private UsersdetailsRepository usersdetailsRepository;

    public Usersdetails getDetailsOfUserByEmail(String email){
        return usersdetailsRepository.findByEmail(email);
    }

    public Usersdetails adduserdetails(Usersdetails usersdetails) {
        return usersdetailsRepository.save(usersdetails);
    }
}
