package com.houseMate.houseMate.controllers;


import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.services.IFlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class FlatController {


    @Autowired
   private IFlatService flatServ;

    @GetMapping("/flats")
    public ResponseEntity <List<Flat>> getFlats(){
        return flatServ.getFlats();
    }
    @PostMapping("/flat/create")
    public ResponseEntity<Object>saveFlat(@RequestBody Flat flat){
        return flatServ.saveFlat(flat);
    }
    @DeleteMapping("flat/{id}")
        public ResponseEntity<Void>deleteFlat(@PathVariable("id") int id){
            return flatServ.deleteFlat(id);
    }
    @PutMapping("/flat/{id}")
    public ResponseEntity<Flat>updateFlat(@PathVariable("id")int id, Flat flat){
        return flatServ.updateFlat(id,flat);
    }
    @GetMapping("/flat/{id}")
    public ResponseEntity<Object>getFlatById(@PathVariable("id")int id){
        return flatServ.getFlatById(id);
    }

}
