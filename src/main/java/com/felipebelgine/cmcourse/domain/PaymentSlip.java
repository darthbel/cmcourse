package com.felipebelgine.cmcourse.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.felipebelgine.cmcourse.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentSlip extends Payment {
    private static final long serialVersionUID = 1L;

    @JsonFormat(pattern = "dd/MM/yyy")
    private Date expiryDate;

    @JsonFormat(pattern = "dd/MM/yyy")
    private Date paymentDate;

    public PaymentSlip() {
    }

    public PaymentSlip(Integer id, PaymentStatus status, PurchaseOrder purchaseOrder, Date expiryDate, Date paymentDate) {
        super(id, status, purchaseOrder);
        this.expiryDate = expiryDate;
        this.paymentDate = paymentDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
