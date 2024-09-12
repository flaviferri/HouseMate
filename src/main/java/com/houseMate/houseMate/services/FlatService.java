package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.models.User;
import com.houseMate.houseMate.repositories.IFlatRepository;
import com.houseMate.houseMate.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FlatService implements IFlatService {

    @Autowired
    private IFlatRepository repoFlat;
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public  ResponseEntity<List<Flat>>getFlats() {
        List<Flat> flat = repoFlat.findAll();
            if(flat.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(flat);
    }

    @Override
    public ResponseEntity<List<Flat>> getFlatsByUserId(String email) {
        List<Flat> flats = repoFlat.findByUserEmail(email);
        if (flats.isEmpty()) {
            return ResponseEntity.ok(new ArrayList<>());
        }
        return ResponseEntity.ok(flats);
    }


    @Override
    public ResponseEntity<Object> getFlatById(int id , String userName) {
        Optional<Flat> flatOptional = repoFlat.findById(id);
        if (flatOptional.isPresent()) {
            Flat flat = flatOptional.get();
            return new ResponseEntity<>(flat, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Flat> saveFlat(Flat flat, String username) {
        Optional<User> optionalUser = userRepository.findByEmail(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            flat.setUser(user);
            Flat savedFlat = repoFlat.save(flat);
            return ResponseEntity.ok(savedFlat);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(null);
    }


    @Override
    public ResponseEntity <Flat> updateFlat(int id, Flat flat) {
        if (repoFlat.existsById(id)) {
            flat.setId(id);
            repoFlat.save(flat);
            Flat updateFlat = repoFlat.save(flat);
           return ResponseEntity.ok(updateFlat);
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> deleteFlat(int id, String userName) {
        if (repoFlat.existsById(id)) {
            repoFlat.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}

