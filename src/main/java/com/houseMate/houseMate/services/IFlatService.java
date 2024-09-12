package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface IFlatService {

    ResponseEntity <List<Flat>> getFlats();
    ResponseEntity<List<Flat>> getFlatsByUserId(String username);
    ResponseEntity<Object> getFlatById(int id, String userName);
    ResponseEntity<Flat> saveFlat(Flat flat,  String username);
    ResponseEntity<Flat>updateFlat(int id ,Flat flat);
    ResponseEntity<Void> deleteFlat (int id, String userName);
}
