package io.abhithube.notificationsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private List<Payment> payments;

    private List<Notification> notifications;

    private String customerId;
    private String subscriptionId;

    public void addToNotifications(Notification notification) {
        notifications.add(0, notification);
    }
}
