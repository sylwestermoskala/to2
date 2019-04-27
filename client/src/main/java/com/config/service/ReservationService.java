package com.config.service;

import com.config.domain.Reservation;
import com.config.domain.Usersdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@Service
public class ReservationService {

    @Autowired
    private RestTemplate restTemplate;

//    public Map<String, String> addReservation(int route_number, int distance, String start_location, String end_location) throws URISyntaxException {
//        URI uri = new URI("http://localhost:8181/route/reservation");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("route_number", Integer.toString(route_number));
//        map.add("distance", Integer.toString(distance));
//        map.add("start_location", start_location);
//        map.add("end_location", end_location);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
//        map.add("responseReservation", response.getBody());
//        return map.toSingleValueMap();
//    }


//    public void addReservation(int route_number, int distance, String start_location, String end_location) throws URISyntaxException {
//        URI uri = new URI("http://localhost:8181/route/reservation");
//
//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("route_number", Integer.toString(route_number));
//        headers.add("distance", Integer.toString(distance));
//        headers.add("start_location", start_location);
//        headers.add("end_location", end_location);
//
//        HttpEntity<?> request = new HttpEntity<Object>(headers);
//        restTemplate.postForEntity(uri, request, String.class);
//    }

    //dziala ale 00000/////////

    public void addReservation(Reservation reservation) throws URISyntaxException {
        URI uri = new URI("http://localhost:8181/route/reservation");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Reservation> request = new HttpEntity<>(reservation, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
    }


//    public void addReservation(Reservation reservation) throws URISyntaxException {
//        URI uri = new URI("http://localhost:8181/route/reservation");
//        RestTemplate template = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
//        map.add("route_number", Integer.toString(reservation.getRoute_number()));
//        map.add("distance", Integer.toString(reservation.getDistance()));
//        map.add("start_location", reservation.getStart_location());
//        map.add("end_location", reservation.getEnd_location());
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity=
//                new HttpEntity<MultiValueMap<String, String>>(map, headers);
//
//        restTemplate.postForEntity(uri, requestEntity, String.class);
//    }


    //////////////good/////////
    public Map<String, Object> getDetailsReser(String routenumber) throws Exception {
        URI uri = new URI("http://localhost:8181/reservation/"+routenumber);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("route_number", routenumber);

        ResponseEntity<Reservation> response = restTemplate.getForEntity(uri, Reservation.class);
        map.add("responseReservation", response.getBody());
        return map.toSingleValueMap();
    }
//
//    public Map<String, String> addReservation(String routenumber, String distance, String start_location, String end_location) throws URISyntaxException {
//        URI uri = new URI("http://localhost:8181/route/reservation");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("route_number", routenumber);
//        map.add("distance", distance);
//        map.add("start_location", start_location);
//        map.add("end_location", end_location);
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
//        ResponseEntity<String> response = restTemplate.postForEntity(uri, request, String.class);
//        map.add("responseReservation", response.getBody());
//        return map.toSingleValueMap();
//    }
}
