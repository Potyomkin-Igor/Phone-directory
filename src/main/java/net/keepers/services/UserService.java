package net.keepers.services;

import net.keepers.dao.UserDAO;
import net.keepers.dto.DtoUser;
import net.keepers.mappers.UserMapper;
import net.keepers.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {
    private UserDAO userDAO;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    public List<DtoUser> getAllDtoUsers() {
        return getDtoUsersFromUsers((List<User>) userDAO.findAll());
    }

    public List<DtoUser> getDtoUsersFromUsers(List<User> users) {
        List<DtoUser> dtoUsers = new ArrayList<>();
        users.forEach(user -> dtoUsers.add(userMapper.fromUserToDto(user)));
        return dtoUsers;
    }

    public DtoUser updateDtoUser (DtoUser dtoUser) {
        User user = userMapper.userFromDto(dtoUser);
        user = userDAO.save(user);
        return userMapper.fromUserToDto(user);
    }

//    public List<User> gertAllUser() {
//        return (List<User>) userDAO.findAll();
//    }

}