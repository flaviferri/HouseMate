package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface IFlatService {

    ResponseEntity <List<Flat>> getFlats();
    ResponseEntity<Object> getFlatById(int id);
    ResponseEntity<Object> saveFlat(Flat flat);
    ResponseEntity<Flat>updateFlat(int id ,Flat flat);
    ResponseEntity<Void> deleteFlat (int id);
}
