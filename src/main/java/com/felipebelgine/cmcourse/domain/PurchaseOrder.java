package com.felipebelgine.cmcourse.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class PurchaseOrder implements Serializable {
     private static final long serialVersionUID = 1L;

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @JsonFormat(pattern = "dd/MM/yyy HH:mm")
     private Date time;

     @OneToOne(cascade = CascadeType.ALL, mappedBy = "purchaseOrder")
     private Payment payment;

     @ManyToOne
     @JoinColumn(name = "client_id")
     private Client client;

     @ManyToOne
     @JoinColumn(name = "delivery_address_id")
     private Address deliveryAddress;

     @OneToMany(mappedBy = "id.purchaseOrder")
     private Set<OrderItem> items = new HashSet<>();

     public PurchaseOrder() {
     }

     public PurchaseOrder(Integer id, Date time, Client client, Address deliveryAddress) {
          this.id = id;
          this.time = time;
          this.client = client;
          this.deliveryAddress = deliveryAddress;
     }

     public double getTotalValue() {
          double sum = 0;

          for (OrderItem item : items) {
               sum += item.getSubTotal();
          }
          return sum;
     }

     public Integer getId() {
          return id;
     }

     public void setId(Integer id) {
          this.id = id;
     }

     public Date getTime() {
          return time;
     }

     public void setTime(Date time) {
          this.time = time;
     }

     public Payment getPayment() {
          return payment;
     }

     public void setPayment(Payment payment) {
          this.payment = payment;
     }

     public Client getClient() {
          return client;
     }

     public void setClient(Client client) {
          this.client = client;
     }

     public Address getDeliveryAddress() {
          return deliveryAddress;
     }

     public void setDeliveryAddress(Address deliveryAddress) {
          this.deliveryAddress = deliveryAddress;
     }

     public Set<OrderItem> getItems() {
          return items;
     }

     public void setItems(Set<OrderItem> items) {
          this.items = items;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          PurchaseOrder purchaseOrder = (PurchaseOrder) o;
          return Objects.equals(id, purchaseOrder.id);
     }

     @Override
     public int hashCode() {
          return Objects.hash(id);
     }
}
