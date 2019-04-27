package com.config.service;

import com.config.domain.Questions;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;


@Service
public class QuestionsService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Questions> getQuestions() throws Exception {
        URI uri = new URI("http://localhost:8181/questions");
        String data = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(data);
        return objectMapper.readValue(data,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Questions.class));
    }

    public List<Questions> getQuestionsByCategory(String category) throws Exception {
        URI uri = new URI("http://localhost:8181/questions/"+category);
        String data = restTemplate.getForObject(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.writeValueAsString(data);
        return objectMapper.readValue(data,
                objectMapper.getTypeFactory().constructCollectionType(List.class, Questions.class));
    }
}
