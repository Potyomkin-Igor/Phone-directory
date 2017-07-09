package net.keepers.services;

import net.keepers.dao.ContactDAO;
import net.keepers.dto.DtoContact;
import net.keepers.mappers.ContactMapper;
import net.keepers.model.Contact;
import net.keepers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContactService {
    private ContactDAO contactDAO;
    private ContactMapper contactMapper;

    @Autowired
    public ContactService(ContactDAO contactDAO, ContactMapper contactMapper) {
        this.contactDAO = contactDAO;
        this.contactMapper = contactMapper;
    }

//    public DtoContact updateContact(DtoContact dtoContact, long id) {
//        Contact contact = contactDAO.findOne(id);
//        if (contact != null && id == contact.getId()) {
//            Contact entity = contactMapper.contactFromDto(dtoContact);
//            contactDAO.save(entity);
//            return contactMapper.fromContactToDto(entity);
//        }
//        return null;
//    }

    public List<Contact> getAllContacts() {
        return((List<Contact>) contactDAO.findAll());
    }

}
