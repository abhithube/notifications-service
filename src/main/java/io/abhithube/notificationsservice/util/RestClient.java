package io.abhithube.notificationsservice.util;

import io.abhithube.notificationsservice.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private final RestTemplate restTemplate;

    @Autowired
    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void updateMember(Member member) {
        restTemplate.put("https://at-insurance.com/api/v1/members/" + member.getUsername(), member);
    }
}
