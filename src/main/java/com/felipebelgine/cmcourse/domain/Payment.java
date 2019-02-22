package com.felipebelgine.cmcourse.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.felipebelgine.cmcourse.enums.PaymentStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Payment implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private Integer status;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    @MapsId
    private PurchaseOrder purchaseOrder;

    public Payment() {
    }

    public Payment(Integer id, PaymentStatus status, PurchaseOrder purchaseOrder) {
        this.id = id;
        this.status = status.getCod();
        this.purchaseOrder = purchaseOrder;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PaymentStatus getStatus() {
        return PaymentStatus.toEnum(status);
    }

    public void setStatus(PaymentStatus status) {
        this.status = status.getCod();
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
