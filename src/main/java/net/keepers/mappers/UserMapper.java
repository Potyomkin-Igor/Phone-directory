package net.keepers.mappers;

import net.keepers.dto.DtoUser;
import net.keepers.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source="contact",target = "contact")
    DtoUser fromUserToDto(User user);

    User userFromDto(DtoUser dtoUser);
}
