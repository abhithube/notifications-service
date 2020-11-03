package io.abhithube.notificationsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Payment {
    private String id;
    private long amount;
    private long createdAt;
    private String plan;

    private String invoiceId;
}
