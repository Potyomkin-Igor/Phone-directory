package net.keepers.services;

import net.keepers.dao.ContactDAO;
import net.keepers.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactService {
    private ContactDAO contactDAO;

    @Autowired
    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAllContacts() {
        return((List<Contact>) contactDAO.findAll());
    }

}
