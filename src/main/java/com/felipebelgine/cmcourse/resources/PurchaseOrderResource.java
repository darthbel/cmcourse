package com.felipebelgine.cmcourse.resources;

import com.felipebelgine.cmcourse.domain.Category;
import com.felipebelgine.cmcourse.domain.PurchaseOrder;
import com.felipebelgine.cmcourse.dto.CategoryDTO;
import com.felipebelgine.cmcourse.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


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

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody PurchaseOrder obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
