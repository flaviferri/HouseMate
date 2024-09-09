package com.houseMate.houseMate.controllers;

import com.houseMate.houseMate.config.JwtTokenProvider;
import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.models.User;
import com.houseMate.houseMate.services.IFlatService;
import com.houseMate.houseMate.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4001")
public class FlatController {

    private final IFlatService flatServ;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public FlatController(IFlatService flatServ, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.flatServ = flatServ;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping("/flats")
    public ResponseEntity <List<Flat>> getFlats() {
        return flatServ.getFlats();
    }

    @PostMapping("/flat/create")
    public ResponseEntity<Object> saveFlat(@RequestBody Flat flat, @RequestHeader("Authorization") String token) {
        // Extraer el userId del token
        int userId = jwtTokenProvider.extractUserIdFromToken(token);

        // Buscar el usuario en la base de datos usando el userId
        User user = userService.findById(userId);

        // Asignar el usuario al flat
        flat.setUser(user);

        // Guardar el flat
        return flatServ.saveFlat(flat);
    }

    @DeleteMapping("/flat/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable("id") int id) {
        return flatServ.deleteFlat(id);
    }

    @PutMapping("/flat/{id}")
    public ResponseEntity<Flat> updateFlat(@PathVariable("id") int id, @RequestBody Flat flat) {
        return flatServ.updateFlat(id, flat);
    }

    @GetMapping("/flat/{id}")
    public ResponseEntity<Object> getFlatById(@PathVariable("id") int id) {
        return flatServ.getFlatById(id);
    }
}
/*
Opción B: Usar @RequiredArgsConstructor y eliminar el constructor personalizado
Si prefieres usar @RequiredArgsConstructor, elimina el constructor personalizado y marca los campos flatServ, userService y jwtTokenProvider como final:

java
Copiar código
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4001")
public class FlatController {

    private final IFlatService flatServ;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/flats")
    public ResponseEntity <List<Flat>> getFlats() {
        return flatServ.getFlats();
    }

    @PostMapping("/flat/create")
    public ResponseEntity<Object> saveFlat(@RequestBody Flat flat, @RequestHeader("Authorization") String token) {
        // Extraer el userId del token
        int userId = jwtTokenProvider.extractUserIdFromToken(token);

        // Buscar el usuario en la base de datos usando el userId
        User user = userService.findById(userId);

        // Asignar el usuario al flat
        flat.setUser(user);

        // Guardar el flat
        return flatServ.saveFlat(flat);
    }

    @DeleteMapping("/flat/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable("id") int id) {
        return flatServ.deleteFlat(id);
    }

    @PutMapping("/flat/{id}")
    public ResponseEntity<Flat> updateFlat(@PathVariable("id") int id, @RequestBody Flat flat) {
        return flatServ.updateFlat(id, flat);
    }

    @GetMapping("/flat/{id}")
    public ResponseEntity<Object> getFlatById(@PathVariable("id") int id) {
        return flatServ.getFlatById(id);
    }
}*/
