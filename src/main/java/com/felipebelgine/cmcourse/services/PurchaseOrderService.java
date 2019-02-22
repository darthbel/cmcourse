package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import com.felipebelgine.cmcourse.repositories.PurchaseOrderRepository;
import com.felipebelgine.cmcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository repo;

    public PurchaseOrder find(Integer id) {
        Optional<PurchaseOrder> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + PurchaseOrder.class.getName()
        ));
    }
}
