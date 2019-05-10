package com.config.service;

import com.config.domain.Reservation;
import com.config.domain.Routes;
import com.config.domain.Usersdetails;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {

    @Autowired
    private RestTemplate restTemplate;

    public void addReservation(Reservation reservation) throws URISyntaxException {
        URI uri = new URI("http://localhost:8181/addReservation");

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Reservation> request = new HttpEntity<>(reservation, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
    }

    public Map<String, Object> getDetailsReser(int id) throws Exception {
        URI uri = new URI("http://localhost:8181/reservation/"+id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id", id);

        ResponseEntity<Reservation> response = restTemplate.getForEntity(uri, Reservation.class);
        map.add("responseReservation", response.getBody());
        return map.toSingleValueMap();
    }

    public Map<String, String> addReservation2(String id, String date, String distance, String start_location, String end_location) throws URISyntaxException {
        URI uri = new URI("http://localhost:8181/addReservation");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", id);
        map.add("date", date);
        map.add("distance", distance);
        map.add("start_location", start_location);
        map.add("end_location", end_location);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        map.add("addReservation", response.getBody());
        return map.toSingleValueMap();
    }

    public List<Reservation> getReservations() throws Exception {
        URI uri = new URI("http://localhost:8181/reservation");
        String data = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(data,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Reservation.class));
    }

    public Reservation addd(Reservation reservation) throws Exception {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

        HttpEntity<Reservation> request = new HttpEntity<Reservation>(reservation, headers);

        return restTemplate.postForObject("http://localhost:8181/addReservation", request, Reservation.class);
    }
}
