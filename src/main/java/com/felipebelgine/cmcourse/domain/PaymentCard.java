package com.felipebelgine.cmcourse.domain;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.felipebelgine.cmcourse.enums.PaymentStatus;

import javax.persistence.Entity;

@Entity
@JsonTypeName("cardPayment")
public class PaymentCard extends Payment {
    private static final long serialVersionUID = 1L;

    private Integer monthlyInstallments;

    public PaymentCard() {
    }

    public PaymentCard(Integer id, PaymentStatus status, PurchaseOrder purchaseOrder, Integer monthlyInstallments) {
        super(id, status, purchaseOrder);
        this.monthlyInstallments = monthlyInstallments;
    }

    public Integer getMonthlyInstallments() {
        return monthlyInstallments;
    }

    public void setMonthlyInstallments(Integer monthlyInstallments) {
        this.monthlyInstallments = monthlyInstallments;
    }
}
