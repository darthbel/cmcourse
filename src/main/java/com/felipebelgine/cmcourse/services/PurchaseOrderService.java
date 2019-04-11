package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.OrderItem;
import com.felipebelgine.cmcourse.domain.PaymentSlip;
import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import com.felipebelgine.cmcourse.enums.PaymentStatus;
import com.felipebelgine.cmcourse.repositories.OrderItemRepository;
import com.felipebelgine.cmcourse.repositories.PaymentRepository;
import com.felipebelgine.cmcourse.repositories.ProductRepository;
import com.felipebelgine.cmcourse.repositories.PurchaseOrderRepository;
import com.felipebelgine.cmcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repo;

    @Autowired
    private PaymentSlipService paymentSlipService;

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public PurchaseOrder find(Integer id) {
        Optional<PurchaseOrder> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + PurchaseOrder.class.getName()
        ));
    }

    public PurchaseOrder insert(PurchaseOrder obj) {
        obj.setId(null);
        obj.setTime(new Date());
        obj.getPayment().setStatus(PaymentStatus.PENDING);
        obj.getPayment().setPurchaseOrder(obj);
        if(obj.getPayment() instanceof PaymentSlip) {
            PaymentSlip payment = (PaymentSlip) obj.getPayment();
            paymentSlipService.fillPaymentSlip(payment, obj.getTime());
        }
        obj = repo.save(obj);
        paymentRepo.save(obj.getPayment());
        for(OrderItem oi : obj.getItems()) {
            oi.setDiscount(0.0);
            oi.setPrice(productService.find(oi.getProduct().getId()).getPrice());
            oi.setPurchaseOrder(obj);
        }
        orderItemRepository.saveAll(obj.getItems());
        return obj;
    }
}
