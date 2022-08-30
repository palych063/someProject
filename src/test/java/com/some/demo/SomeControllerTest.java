package com.some.demo;

import com.some.demo.model.Product;
import com.some.demo.model.SomeRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SomeControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void test_positive_case() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String requestBody = "{\n" +
                "\t\"seller\": \"223534251\",\n" +
                "\t\"customer\": \"648563524\",\n" +
                "\t\"products\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"milk\",\n" +
                "\t\t\t\"code\": \"2136478363542\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"name\": \"water\",\n" +
                "\t\t\t\"code\": \"3656352437590\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        HttpEntity<String> request =
                new HttpEntity<String>(requestBody, headers);
        assertThat(
                restTemplate.postForObject("http://localhost:" + port + "/api/v1/some", request, String.class)
        ).contains("OK");
    }
}
