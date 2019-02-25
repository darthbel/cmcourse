package com.felipebelgine.cmcourse.resources;

import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import com.felipebelgine.cmcourse.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/orders")
public class PurchaseOrderResource {

    @Autowired
    private PurchaseOrderService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PurchaseOrder> find(@PathVariable Integer id) {
        PurchaseOrder obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
