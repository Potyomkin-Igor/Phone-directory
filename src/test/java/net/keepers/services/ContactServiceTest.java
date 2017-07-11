package net.keepers.services;

import net.keepers.dao.ContactDAO;
import net.keepers.model.Contact;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static net.keepers.validators.MapperHelper.getTestListOfContacts;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
    @Mock
    private ContactDAO contactDAO;
    @InjectMocks
    private ContactService contactService;

    private List<Contact> contacts;

    @Before
    public void setUp() {
        contacts = getTestListOfContacts();
    }
    @Test
    public void getAllContactsShouldReturnListOfContacts() {
      when(contactDAO.findAll()).thenReturn(contacts);
      assertEquals(contactService.getAllContacts(), contacts);
      verify(contactDAO, times(1)).findAll();
    }
}