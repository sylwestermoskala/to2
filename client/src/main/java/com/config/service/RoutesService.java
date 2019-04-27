package com.config.service;

import com.config.domain.Routes;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class RoutesService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Routes> getRoute() throws Exception {
        URI uri = new URI("http://localhost:8181/routes");
        String data = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(data);
        return objectMapper.readValue(data,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Routes.class));
    }

    //////////////

    public Map<String, Object> getRouteById(String id) throws Exception {
        URI uri = new URI("http://localhost:8181/routes/"+id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id", id);

        ResponseEntity<Routes> response = restTemplate.getForEntity(uri, Routes.class);
        map.add("respRoutes", response.getBody());
        return map.toSingleValueMap();
    }

    ///////////////

    public Map<String, Object> deleteRouteById(int id) throws Exception {
        URI uri = new URI("http://localhost:8181/delete/"+id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("id", id);

        ResponseEntity<Routes> response = restTemplate.getForEntity(uri, Routes.class);
        map.add("respRoutes", response.getBody());
        return map.toSingleValueMap();
    }

/////////////////////////
    public void delete(Integer id)throws Exception{
        URI uri = new URI("http://localhost:8181/delete/"+id);
        //String uri = new String("http://localhost:8181/delete/"+id);
        restTemplate.delete(Integer.toString(id));
//        return "redirect:/route";
    }

    public void deleteEmployee(int id)
    {
        final String uri = "http://localhost:8181/delete/{id}";

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", "1");

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete ( uri,  params );
    }


    public void deleteRouteById2(int id) throws Exception {
        URI uri = new URI("http://localhost:8181/delete/"+id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("id", Integer.toString(id));

        HttpEntity<?> request = new HttpEntity<Object>(headers);
        restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
//        return map.toSingleValueMap();


//        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
//        headers.add("X-XSRF-HEADER", "BlahBlah");
//        headers.add("Authorization", "Basic " + blahblah);
//        etc...
//
//        HttpEntity<?> request = new HttpEntity<Object>(headers);
//        restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
    }
}
