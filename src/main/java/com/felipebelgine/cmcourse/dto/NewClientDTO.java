package com.felipebelgine.cmcourse.dto;

import com.felipebelgine.cmcourse.services.validation.ClientInsert;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClientInsert
public class NewClientDTO implements Serializable {
    private static final long setrialVersionUID = 1L;

    @NotEmpty(message = "Field is mandatory")
    @Length(min = 5, max = 120, message = "Length should be between 5 and 120 characters")
    private String name;

    @NotEmpty(message = "Field is mandatory")
    @Email(message = "Invalid email")
    private String email;

    @NotEmpty(message = "Field is mandatory")
    private String cpfOrCnpj;

    private Integer clientType;

    @NotEmpty(message = "Field is mandatory")
    private String number;

    @NotEmpty(message = "Field is mandatory")
    private String street;

    private String street2;

    @NotEmpty(message = "Field is mandatory")
    private String zip;

    @NotEmpty(message = "Field is mandatory")
    private String phone1;

    private String phone2;
    private String phone3;

    private Integer cityId;

    public NewClientDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOrCnpj() {
        return cpfOrCnpj;
    }

    public void setCpfOrCnpj(String cpfOrCnpj) {
        this.cpfOrCnpj = cpfOrCnpj;
    }

    public Integer getClientType() {
        return clientType;
    }

    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
