package net.keepers.dao;

import net.keepers.model.Type;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TypeDAO extends PagingAndSortingRepository<Type, Long> {
    Type getByName(String name);
}
