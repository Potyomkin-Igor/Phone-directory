package net.keepers.dao;

import net.keepers.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ContactDAO extends PagingAndSortingRepository<Contact, Long> {
}
