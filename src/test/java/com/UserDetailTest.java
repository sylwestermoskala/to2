package com;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

public class UserDetailTest {
    @LocalServerPort
    private int port = 8181;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();


    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

    @Test
    public void testUserDetails() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/details/sylwek"),
                HttpMethod.GET, entity, String.class);

        String expected = "{email:sylwek,country:poland,gender:male}";

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }


    @Test
    public void testUserDetails2() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/details/admin"),
                HttpMethod.GET, entity, String.class);

        String expected = "{email:admin,country:poland,gender:female}";

        JSONAssert.assertEquals(expected, response.getBody(), true);
    }
}
