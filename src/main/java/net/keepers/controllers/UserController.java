package net.keepers.controllers;

import net.keepers.dto.DtoUser;
import net.keepers.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/api/user", "/api/user/"})
    @ResponseBody
    public ResponseEntity<List<DtoUser>> getAllDtoUsers() {
        List<DtoUser> users = userService.getAllDtoUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/api/user/{id}")
    public ResponseEntity<DtoUser> updateUser (@PathVariable("id") long id, @Valid @RequestBody DtoUser dtoUser) {
        DtoUser currentUser = userService.updateDtoUser(dtoUser);
        if(currentUser != null){
            return new ResponseEntity<>(dtoUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
