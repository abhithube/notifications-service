package io.abhithube.notificationsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Notification {
    private String id = UUID.randomUUID().toString();
    private String title;
    private String description;
    private long createdAt = Instant.now().getEpochSecond();
}
