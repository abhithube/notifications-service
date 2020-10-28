package io.abhithube.notificationsservice.service;

import io.abhithube.notificationsservice.dto.Member;
import io.abhithube.notificationsservice.dto.Notification;
import io.abhithube.notificationsservice.dto.Payment;
import io.abhithube.notificationsservice.dto.Plan;
import io.abhithube.notificationsservice.util.RestClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationsServiceTest {
    @InjectMocks
    @Spy
    private NotificationsService notificationsService;
    @Mock
    private RestClient restClient;

    @Test
    @DisplayName("it should create a registration notification")
    void registered() {
        // Arrange
        Member member = new Member();
        member.setUsername("test");

        doNothing()
                .when(notificationsService).createNotification(any(Member.class), anyString(), anyString());

        // Act
        notificationsService.registered(member);

        // Assert
        String title = "Welcome to AT Insurance, test!";
        String description = "Your member account has been created.";
        verify(notificationsService).createNotification(member, title, description);
    }

    @Test
    @DisplayName("it should create an enrollment notification")
    void enrolled() {
        // Arrange
        Member member = new Member();
        Plan plan = new Plan();
        plan.setName("test");
        member.setPlan(plan);

        doNothing()
                .when(notificationsService).createNotification(any(Member.class), anyString(), anyString());

        // Act
        notificationsService.enrolled(member);

        // Assert
        String title = "Enrollment Confirmation";
        String description = "You have been enrolled in plan test.";
        verify(notificationsService).createNotification(member, title, description);
    }

    @Test
    @DisplayName("it should create a cancellation notification")
    void cancelled() {
        // Arrange
        Member member = new Member();

        doNothing()
                .when(notificationsService).createNotification(any(Member.class), anyString(), anyString());

        // Act
        notificationsService.cancelled(member);

        // Assert
        String title = "Enrollment Cancelled";
        String description = "You have been dropped from your enrolled plan.";
        verify(notificationsService).createNotification(member, title, description);
    }

    @Test
    @DisplayName("it should create a payment notification")
    void charged() {
        // Arrange
        Member member = new Member();
        Payment payment = new Payment();
        payment.setAmount(0L);
        member.setPayments(Collections.singletonList(payment));

        doNothing()
                .when(notificationsService).createNotification(any(Member.class), anyString(), anyString());

        // Act
        notificationsService.charged(member);

        // Assert
        String title = "Monthly Payment Confirmation";
        String description = "Your account has been charged $0.";
        verify(notificationsService).createNotification(member, title, description);
    }

    @Test
    @DisplayName("it should add a new notification to a member's account")
    void createNotification() {
        // Arrange
        Member member = new Member();

        doNothing()
                .when(restClient).updateMember(any(Member.class));

        // Act
        notificationsService.createNotification(member, "test", "test");

        // Assert
        verify(restClient).updateMember(member);
        List<Notification> notifications = member.getNotifications();
        assertEquals(1, notifications.size());
        assertEquals("test", notifications.get(0).getTitle());
    }
}