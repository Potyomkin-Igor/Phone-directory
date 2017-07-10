package net.keepers.dto;

import lombok.Data;
import net.keepers.model.Contact;

import javax.validation.Valid;

@Data
public class DtoUser {
    private long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    @Valid
    private Contact contact;
}
