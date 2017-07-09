package net.keepers.dto;

import lombok.Data;
import net.keepers.model.Type;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class DtoContact {
//    private long id;
//    @NotNull
//    @Pattern(regexp = "^((\\+\\d)?[\\d]?)?((\\(?\\d){3}\\)?([\\-]|[\\s]))?[\\d\\-]{7,10}$" , message = "{phone.valid}")
//    String phoneNumber;
//    @Valid
//    Type type;
//    String comment;
}