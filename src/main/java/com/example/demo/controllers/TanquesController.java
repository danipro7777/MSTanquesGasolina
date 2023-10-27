package com.example.demo.controllers;

import com.example.demo.models.Tanques;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.TanquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apitanques")
public class TanquesController {
    @Autowired
    TanquesService tanquesService;

    //GET TODOS
    @GetMapping("/get")
    public ArrayList<Tanques> getTanques(){
        return tanquesService.getTanques();
    }

    //GET POR ID
    @GetMapping("/get/{id}")
    public Optional<Tanques> getID(Integer id){
        return this.tanquesService.getID(id);
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveTanques(@RequestBody RequestDTO requestDTO){
        return this.tanquesService.saveTanques(requestDTO);
    }

    //PUT
    @PutMapping("/put")
    public ResponseEntity<ResponseDTO> updateTanques(@RequestBody RequestDTO requestDTO){
        return tanquesService.putTanques(requestDTO);
    }

    //DELETE
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteTanques(@RequestBody RequestDTO requestDTO){
        return tanquesService.deleteTanques(requestDTO);
    }
}
