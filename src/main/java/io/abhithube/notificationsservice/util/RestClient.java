package io.abhithube.notificationsservice.util;

import io.abhithube.notificationsservice.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private final RestTemplate restTemplate;
    @Value("${client.members.url}")
    private String baseUrl;

    @Autowired
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateMember(Member member) {
        restTemplate.put(baseUrl + member.getUsername(), member);
    }
}
