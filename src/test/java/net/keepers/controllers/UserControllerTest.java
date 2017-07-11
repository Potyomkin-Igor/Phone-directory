package net.keepers.controllers;

import net.keepers.dto.DtoUser;
import net.keepers.model.User;
import net.keepers.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static net.keepers.validators.JsonConverter.convertObjectToJsonBytes;
import static net.keepers.validators.MapperHelper.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    private UserService userService;
    @InjectMocks
    private UserController controller;
    private MockMvc mvc;
    private DtoUser dtoUser;
    private List<DtoUser> dtoUsers;
    private List<User> users;

    @Before
    public void setUp() {
        mvc = standaloneSetup(controller).build();
        dtoUser = getTestDtoUser();
        dtoUsers = getTestListOfDtoUsers();
        users = getTestListOfUsers();
    }

    @Test
    public void getAllDtoUsersShouldReturnOkHttpStatus() throws Exception {
     when(userService.getDtoUsersFromUsers(users)).thenReturn(dtoUsers);
     mvc.perform(get("/api/user"))
             .andExpect(status().isOk());
     verify(userService).getAllDtoUsers();
    }

    @Test
    public void updateUserWithWrongIdCouldNotSaveExpectNotFound() throws Exception {
      when(userService.updateDtoUser(dtoUser)).thenReturn(null);
      mvc.perform(put("/api/user/" + TEST_NEGATIVE_ID)
              .contentType(MediaType.APPLICATION_JSON)
              .content(convertObjectToJsonBytes(dtoUser)))
              .andExpect(status().isNotFound());
              verify(userService,times(1)).updateDtoUser(dtoUser);
    }

    @Test
    public void updateUserShouldReturnOkHttpStatus() throws Exception {
        when(userService.updateDtoUser(dtoUser)).thenReturn(dtoUser);
        mvc.perform(put("/api/user/" + TEST_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonBytes(dtoUser)))
                .andExpect(status().isOk());
        verify(userService, times(1)).updateDtoUser(dtoUser);
        verifyNoMoreInteractions(userService);
    }
}