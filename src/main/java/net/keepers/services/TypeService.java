package net.keepers.services;

import net.keepers.dao.TypeDAO;
import net.keepers.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeService {
    private TypeDAO typeDAO;

    @Autowired
    public TypeService(TypeDAO typeDAO) {
        this.typeDAO = typeDAO;
    }

//    public Type findTypeByName(String name) {
//        return typeDAO.getByName(name);
//    }

    public List<Type> getAllTypes() {
        Pageable pageable = new PageRequest(0, Integer.MAX_VALUE);
        return typeDAO.findAll(pageable).getContent();
    }
}
