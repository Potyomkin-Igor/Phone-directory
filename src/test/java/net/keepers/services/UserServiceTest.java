package net.keepers.services;

import net.keepers.dao.UserDAO;
import net.keepers.dto.DtoUser;
import net.keepers.mappers.UserMapper;
import net.keepers.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static net.keepers.validators.MapperHelper.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.matches;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
    @Mock
    private UserDAO userDAO;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;

    private List<User> users;
    private List<DtoUser> dtoUsers;
    private User user;
    private DtoUser dtoUser;

    @Before
    public void setUp() {
        user = getUserTest();
        dtoUser = getTestDtoUser();
        users = getTestListOfUsers();
        dtoUsers = getTestListOfDtoUsers();
    }

    @Test
    public void getAllDtoUsersShouldReturnDtoList() {
        when(userDAO.findAll()).thenReturn(users);
        when(userMapper.fromUserToDto(user)).thenReturn(dtoUser);
        List<DtoUser> result = userService.getAllDtoUsers();
        assertEquals(dtoUsers, result);
        verify(userDAO, times(1)).findAll();
    }

    @Test
    public void invokeUpdateUserShouldReturnDtoUser() {
        when(userMapper.userFromDto(dtoUser)).thenReturn(user);
        when(userDAO.save(user)).thenReturn(user);
        when(userMapper.fromUserToDto(user)).thenReturn(dtoUser);
        assertEquals(userService.updateDtoUser(dtoUser), dtoUser);
        verify(userDAO, times(1)).save(user);
        verify(userMapper).fromUserToDto(user);
    }
    @Test
    public void getDtoUsersFromUserListShouldReturnDtoList() {
        when(userMapper.fromUserToDto(user)).thenReturn(dtoUser);
        assertEquals(userService.getDtoUsersFromUsers(users), dtoUsers);
    }

}
