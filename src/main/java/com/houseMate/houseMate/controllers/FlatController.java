package com.houseMate.houseMate.controllers;


import com.houseMate.houseMate.models.Flat;
import com.houseMate.houseMate.services.IFlatService;
import com.houseMate.houseMate.services.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4001")
public class FlatController {


    @Autowired
    private IFlatService flatServ;

    @Autowired
    private JwtService jwtService;

  /*  @GetMapping("/flats")
    public ResponseEntity<List<Flat>> getFlats(@RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsernameFromToken(token); // Usa el servicio JWT
        return flatServ.getFlats();
    }

     @PostMapping("/flat/create")
     public ResponseEntity<Object>saveFlat(@RequestBody Flat flat){
         return flatServ.saveFlat(flat);
     }*/

    @GetMapping("/flats")
    public ResponseEntity<List<Flat>> getFlatsByUser(@RequestHeader("Authorization") String token) {
        String email = jwtService.extractUsernameFromToken(token);
        return flatServ.getFlatsByUserId(email);
    }
    @PostMapping("/flat/create")
    public ResponseEntity<Flat> saveFlat(@RequestBody Flat flat, @RequestHeader("Authorization") String token) {
        String username = jwtService.extractUsernameFromToken(token); // Usa el servicio JWT
        return flatServ.saveFlat(flat, username);
    }

    @DeleteMapping("flat/{id}")
    public ResponseEntity<Void> deleteFlat(@PathVariable("id") int id, @RequestHeader("Authorization") String token){
        String username = jwtService.extractUsernameFromToken(token); // Usa el servicio JWT
        return flatServ.deleteFlat(id, username);
    }
    @PutMapping("/flat/{id}")
    public ResponseEntity<Flat> updateFlat(@PathVariable("id")int id, Flat flat){
        return flatServ.updateFlat(id,flat);
    }
    @GetMapping("/flat/{id}")
    public ResponseEntity<Object> getFlatById(@PathVariable("id") int id, @RequestHeader("Authorization") String token){
        String username = jwtService.extractUsernameFromToken(token); // Usa el servicio JWT
        return flatServ.getFlatById(id,username);
    }

}
