package net.keepers.mappers;

import net.keepers.dto.DtoUser;
import net.keepers.model.Contact;
import net.keepers.model.User;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import static net.keepers.validators.MapperHelper.getTestDtoUser;
import static net.keepers.validators.MapperHelper.getUserTest;
import static org.junit.Assert.*;

public class UserMapperTest {

    UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Test
    public void fromUserToDto() throws Exception {
        User user = getUserTest();
        DtoUser dtoUser = userMapper.fromUserToDto(user);
        assertNotNull(dtoUser);
        Contact contact = user.getContact();
        assertEquals(user.getFirstName(), dtoUser.getFirstName());
        assertEquals(user.getLastName(), dtoUser.getLastName());
        assertEquals(user.getPatronymic(), dtoUser.getPatronymic());
        assertEquals(contact.getPhoneNumber(), dtoUser.getContact().getPhoneNumber());
        assertEquals(contact.getType(), dtoUser.getContact().getType());
        assertEquals(contact.getComment(), dtoUser.getContact().getComment());
    }

    @Test
    public void userFromDto() throws Exception {
        DtoUser dtoUser = getTestDtoUser();
        User user = userMapper.userFromDto(dtoUser);
        assertNotNull(user);
        Contact contact = user.getContact();
        assertNotNull(contact);
        assertEquals(dtoUser.getFirstName(), user.getFirstName());
        assertEquals(dtoUser.getLastName(), user.getLastName());
        assertEquals(dtoUser.getPatronymic(), user.getPatronymic());
        assertEquals(dtoUser.getContact().getPhoneNumber(), contact.getPhoneNumber());
        assertEquals(dtoUser.getContact().getType(), contact.getType());
        assertEquals(dtoUser.getContact().getComment(), contact.getComment());
    }

}