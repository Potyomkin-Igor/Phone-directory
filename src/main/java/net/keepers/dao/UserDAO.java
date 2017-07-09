package net.keepers.dao;

import net.keepers.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDAO extends PagingAndSortingRepository<User, Long> {
}
