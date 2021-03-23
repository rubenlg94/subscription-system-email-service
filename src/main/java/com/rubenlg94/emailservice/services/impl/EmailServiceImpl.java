package com.rubenlg94.emailservice.services.impl;

import com.rubenlg94.emailservice.models.EmailModel;
import com.rubenlg94.emailservice.services.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    @Value("${mail-template.created-subscription.subject}")
    private String createdSubscriptionSubject;

    @Value("${mail-template.created-subscription.message}")
    private String createdSubscriptionMessage;

    @Value("${mail-template.created-subscription.subject}")
    private String cancelledSubscriptionSubject;

    @Value("${mail-template.created-subscription.message}")
    private String cancelledSubscriptionMessage;

    @Value("${spring.mail.username}")
    private String from;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendCreatedSubscriptionMessage(String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(createdSubscriptionSubject);
        simpleMailMessage.setText(createdSubscriptionMessage);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendCancelledSubscriptionMessage(String to) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(cancelledSubscriptionSubject);
        simpleMailMessage.setText(cancelledSubscriptionMessage);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendMessage(EmailModel emailModel) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(emailModel.getTo());
        simpleMailMessage.setSubject(emailModel.getSubject());
        simpleMailMessage.setText(emailModel.getText());
        javaMailSender.send(simpleMailMessage);
    }


}
