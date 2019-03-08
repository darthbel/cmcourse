package com.felipebelgine.cmcourse.services;

import com.felipebelgine.cmcourse.domain.Address;
import com.felipebelgine.cmcourse.domain.City;
import com.felipebelgine.cmcourse.domain.Client;
import com.felipebelgine.cmcourse.dto.ClientDTO;
import com.felipebelgine.cmcourse.dto.NewClientDTO;
import com.felipebelgine.cmcourse.enums.ClientType;
import com.felipebelgine.cmcourse.repositories.AddressRepository;
import com.felipebelgine.cmcourse.repositories.CityRepository;
import com.felipebelgine.cmcourse.repositories.ClientRepository;
import com.felipebelgine.cmcourse.services.exceptions.DataIntegrityException;
import com.felipebelgine.cmcourse.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Client find(Integer id) {
        Optional<Client> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Client.class.getName()
        ));
    }

    @Transactional
    public Client insert(Client obj) {
        obj.setId(null);
        obj = repo.save(obj);
        addressRepository.saveAll(obj.getAddresses());
        return repo.save(obj);
    }

    public Client update(Client obj) {
        Client newObj = find(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("It is not possible to delete a Client that has Purchase Orders");
        }
    }

    public List<Client> findAll() {
        return repo.findAll();
    }

    public Page<Client> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Client fromDTO(ClientDTO objDto) {
        return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), null, null);
    }

    public Client fromDTO(NewClientDTO objDto) {
        Client cli = new Client(
                null, objDto.getName(),
                objDto.getEmail(), objDto.getCpfOrCnpj(),
                ClientType.toEnum(objDto.getClientType()));
        City city = new City(objDto.getCityId(), null, null);
        Address addr = new Address(
                null, objDto.getNumber(),
                objDto.getStreet(),
                objDto.getStreet2(),
                objDto.getZip(),
                cli, city);
        cli.getAddresses().add(addr);
        cli.getPhoneNumbers().add(objDto.getPhone1());
        if(objDto.getPhone2()!=null) {
            cli.getPhoneNumbers().add(objDto.getPhone2());
        }
        if(objDto.getPhone3()!=null) {
            cli.getPhoneNumbers().add(objDto.getPhone3());
        }
        return cli;
    }

    private void updateData(Client newObj, Client obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
