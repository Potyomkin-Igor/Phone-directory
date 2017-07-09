package net.keepers.controllers;

import net.keepers.model.Type;
import net.keepers.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class TypeController {
    private TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/api/type")
    @ResponseBody
    public ResponseEntity<Collection<Type>> getTypes() {
        List<Type> typeList = typeService.getAllTypes();
        return new ResponseEntity<>(typeList, HttpStatus.OK);
    }
}
