/*
package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.repositories.IFlatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FlatService implements IFlatService {

    @Autowired
    private IFlatRepository repoFlat;

    @Override
    public List<Flat> getFlats() {
        return List.of();
    }

    @Override
    public Optional<Flat> getFlatById(int id) {
        return repoFlat.findById(id);
    }

    @Override
    public void saveFlat(Flat flat) {
        repoFlat.save(flat);

    }

    @Override
    public boolean updateFlat(int id, Flat flat) {
        if (repoFlat.existsById(id)) {
            flat.setId(id);
            repoFlat.save(flat);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteFlat(int id) {
        if (repoFlat.existsById(id)) {
            repoFlat.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean patchFlat(int id, String name, String street, Integer number, Integer floor, Integer postCode, Integer rooms) {
        Flat flat = repoFlat.findById(id).orElse(null);

        if (flat != null) {
            if (name != null) {
                flat.setName(name);
            }
            if (street != null) {
                flat.setStreet(street);
            }
            if (number != null) {
                flat.setNumber(number);
            }
            if (floor != null) {
                flat.setFloor(floor);
            }
            if (postCode != null) {
                flat.setPostCode(postCode);
            }
            if (rooms != null) {
                flat.setRooms(rooms);
            }
            repoFlat.save(flat);
            return true;
        }
       return false;
    }

}

*/
