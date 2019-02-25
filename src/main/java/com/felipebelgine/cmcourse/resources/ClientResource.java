package com.felipebelgine.cmcourse.resources;

import com.felipebelgine.cmcourse.domain.Category;
import com.felipebelgine.cmcourse.domain.Client;
import com.felipebelgine.cmcourse.services.CategoryService;
import com.felipebelgine.cmcourse.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

    @Autowired
    private ClientService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Client> find(@PathVariable Integer id) {
        Client obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
