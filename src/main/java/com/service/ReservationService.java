package com.service;

import com.domain.Reservation;
import com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public Reservation findReservationByRoute(int id) {
        return reservationRepository.findReservationById(id);
    }

    public Reservation addreservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservations() {
        List<Reservation> result = new ArrayList<>();
        Iterable<Reservation> iterable =  reservationRepository.findAll();
        iterable.forEach(e-> result.add(e));
        return result;
    }

}
