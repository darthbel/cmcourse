package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(PurchaseOrder obj);

    void sendEmail(SimpleMailMessage msg);
}
