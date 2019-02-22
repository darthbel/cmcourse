package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.Client;
import com.felipebelgine.cmcourse.repositories.ClientRepository;
import com.felipebelgine.cmcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    public Client find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Client.class.getName()
        ));
    }
}
