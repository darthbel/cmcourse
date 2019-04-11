package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.PaymentSlip;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class PaymentSlipService {

    public void fillPaymentSlip(PaymentSlip payment, Date purchaseOrderTime) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(purchaseOrderTime);
        cal.add(Calendar.DAY_OF_MONTH, 7);
        payment.setExpiryDate(cal.getTime());
    }
}
