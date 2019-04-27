package com.service;

import com.domain.Reservation;
import com.domain.Usersdetails;
import com.repository.QuestionsRepository;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findReservationByRoute(int routenumber) {
        return reservationRepository.findReservationByRoutenumber(routenumber);
    }

    public Reservation put(Reservation reservation){
        return reservationRepository.save(reservation);
    }
}
