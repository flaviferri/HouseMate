package com.houseMate.houseMate.services;

import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.repositories.IFlatRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public class FlatService implements IFlatService {

    @Autowired
    private IFlatRepository repoFlat;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Flat> getFlats() {
        return repoFlat.findAllByOrderByIdAsc();
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


}

