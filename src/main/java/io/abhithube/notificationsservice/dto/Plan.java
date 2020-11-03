package io.abhithube.notificationsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Plan {
    private String id;
    private String name;
    private long cost;
    private long deductible;

    private String productId;
    private String priceId;
}
