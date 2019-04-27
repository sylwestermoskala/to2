package com.repository;

import com.domain.Questions;
import com.domain.Reservation;
import com.domain.Routes;
import com.domain.Usersdetails;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {
//    Reservation findByRouteNumber(Integer RouteNumber);
//    Usersdetails findByEmail(String email);
    Reservation findReservationByRoutenumber(int route_number);
}
