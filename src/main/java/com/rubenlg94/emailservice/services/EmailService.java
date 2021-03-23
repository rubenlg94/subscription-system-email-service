package com.rubenlg94.emailservice.services;

import com.rubenlg94.emailservice.models.EmailModel;

public interface EmailService {

    void sendCreatedSubscriptionMessage(String to);

    void sendCancelledSubscriptionMessage(String to);

    void sendMessage(EmailModel emailModel);

}
