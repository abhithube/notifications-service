package io.abhithube.notificationsservice.service;

import io.abhithube.notificationsservice.dto.Member;
import io.abhithube.notificationsservice.dto.Notification;
import io.abhithube.notificationsservice.dto.Payment;
import io.abhithube.notificationsservice.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationsService {
    private final RestClient restClient;

    @Autowired
    public NotificationsService(RestClient restClient) {
        this.restClient = restClient;
    }

    @KafkaListener(topics = "registration")
    public void registered(Member member) {
        String name = member.getUsername();
        String title = "Welcome to AT Insurance, " + name + "!";
        String description = "Your member account has been created.";
        createNotification(member, title, description);
    }

    @KafkaListener(topics = "enrollment")
    public void enrolled(Member member) {
        String plan = member.getPlan().getName();
        String title = "Enrollment Confirmation";
        String description = "You have been enrolled in plan " + plan + ".";
        createNotification(member, title, description);
    }

    @KafkaListener(topics = "cancellation")
    public void cancelled(Member member) {
        String title = "Enrollment Cancelled";
        String description = "You have been dropped from your enrolled plan.";
        createNotification(member, title, description);
    }

    @KafkaListener(topics = "payment")
    public void charged(Member member) {
        List<Payment> payments  = member.getPayments();
        Long payment = payments.get(payments.size()-1).getAmount();
        String title = "Monthly Payment Confirmation";
        String description = "Your account has been charged $" + payment/100 + ".";
        createNotification(member, title, description);
    }

    public void createNotification(Member member, String title, String description) {
        Notification notification = new Notification();
        notification.setTitle(title);
        notification.setDescription(description);

        member.addToNotifications(notification);

        restClient.updateMember(member);
    }
}
