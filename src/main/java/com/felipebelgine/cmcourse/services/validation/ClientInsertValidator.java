package com.felipebelgine.cmcourse.services.validation;

import com.felipebelgine.cmcourse.domain.Client;
import com.felipebelgine.cmcourse.dto.NewClientDTO;
import com.felipebelgine.cmcourse.enums.ClientType;
import com.felipebelgine.cmcourse.repositories.ClientRepository;
import com.felipebelgine.cmcourse.resources.exceptions.FieldMessage;
import com.felipebelgine.cmcourse.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, NewClientDTO> {

    @Autowired
    private ClientRepository repo;

    @Override
    public void initialize(ClientInsert ann) {
    }

    @Override
    public boolean isValid(NewClientDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getClientType().equals(ClientType.NATURALPERSON.getCod()) && !BR.isValidCPF(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CPF is invalid"));
        }

        if (objDto.getClientType().equals(ClientType.LEGALPERSON.getCod()) && !BR.isValidCNPJ(objDto.getCpfOrCnpj())) {
            list.add(new FieldMessage("cpfOrCnpj", "CNPJ is invalid"));
        }

        Client aux = repo.findByEmail(objDto.getEmail());
        if (aux != null) {

            list.add(new FieldMessage("email", "Existent Email"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
