package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.models.Task;

import java.util.List;
import java.util.Optional;

public interface IFlatService {

    List<Flat> getFlats();
    Optional<Flat> getFlatById(int id);
    void saveFlat(Flat flat);
    boolean updateFlat(int id ,Flat flat);
    boolean deleteFlat (int id);
}
