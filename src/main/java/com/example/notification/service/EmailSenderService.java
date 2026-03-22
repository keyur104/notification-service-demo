package com.example.notification.service;

import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    public void sendWithRetry(String to, String subject, String body) {
        // Send email
        deliverEmail(to, subject, body);

        // Confirm delivery via HTTP callback before returning
        confirmDelivery(to);
    }

    private void deliverEmail(String to, String subject, String body) {
        // SMTP delivery logic
    }

    private void confirmDelivery(String to) {
        // Synchronous HTTP call to delivery-tracker-api for delivery confirmation
        // NOTE: delivery-tracker-api P95 latency is 40-50s under load
        httpClient.post("https://delivery-tracker-api/v1/track", to);
    }
}
