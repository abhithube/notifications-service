package io.abhithube.notificationsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Member {
    private String id;
    private String username;
    private String password;
    private String email;

    private Plan plan;
    private long memberSince;
    private long nextPaymentDate;
    private List<Payment> payments = new ArrayList<>();

    private List<Notification> notifications = new ArrayList<>();

    private String customerId;
    private String subscriptionId;

    public void addToNotifications(Notification notification) {
        notifications.add(notification);
    }
}
