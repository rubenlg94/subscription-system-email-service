package com.rubenlg94.emailservice.controllers;

import com.rubenlg94.emailservice.models.EmailModel;
import com.rubenlg94.emailservice.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/email-notifications")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void sendEmail(@RequestBody EmailModel emailModel) {
        CompletableFuture.runAsync(() -> emailService.sendMessage(emailModel));
    }

    @PostMapping("/created-subscription")
    public void sendCreatedSubscriptionEmail(@RequestBody String to) {
        CompletableFuture.runAsync(() -> emailService.sendCreatedSubscriptionMessage(to));
    }

    @PostMapping("/cancelled-subscription")
    public void sendCancelledSubscriptionEmail(@RequestBody String to) {
        CompletableFuture.runAsync(() -> emailService.sendCancelledSubscriptionMessage(to));
    }

}
