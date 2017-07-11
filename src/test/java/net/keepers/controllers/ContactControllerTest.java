package net.keepers.controllers;

import net.keepers.model.Contact;
import net.keepers.services.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static net.keepers.validators.MapperHelper.getTestListOfContacts;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {
    @Mock
    private ContactService contactService;
    @InjectMocks
    private ContactController contactController;
    private MockMvc mvc;
    private List<Contact> contacts;

    @Before
    public void setUp() {
        mvc = standaloneSetup(contactController).build();
        contacts = getTestListOfContacts();
    }
    @Test
    public void getAllContactsShouldreturnOkHttpStatus() throws Exception {
      when(contactService.getAllContacts()).thenReturn(contacts);
        mvc.perform(get("/api/contacts"))
                .andExpect(status().isOk());
        verify(contactService,times(1)).getAllContacts();
    }
}