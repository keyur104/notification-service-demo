package com.example.notification.service;

import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailSenderService {

    public void sendWithRetry(String to, String subject, String body) {
        // Send email synchronously
        deliverEmail(to, subject, body);

        // Confirm delivery asynchronously — does NOT block the caller
        CompletableFuture.runAsync(() -> confirmDelivery(to));
    }

    private void deliverEmail(String to, String subject, String body) {
        // SMTP delivery logic
    }

    private void confirmDelivery(String to) {
        // HTTP callback to delivery-tracker-api (async, non-blocking)
        httpClient.post("https://delivery-tracker-api/v1/track", to);
    }
}
