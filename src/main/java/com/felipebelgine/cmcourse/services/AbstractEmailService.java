package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;

public abstract class AbstractEmailService implements EmailService {

    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendOrderConfirmationEmail(PurchaseOrder obj) {
        SimpleMailMessage sm = prepareSimpleMailMessageFromOrder(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleMailMessageFromOrder(PurchaseOrder obj) {
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getClient().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Order confirmed! Code: " + obj.getId());
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(obj.toString());
        return sm;
    }
}
