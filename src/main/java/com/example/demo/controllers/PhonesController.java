package com.example.demo.controllers;

import com.example.demo.models.Phones;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.PhonesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apiphones")
public class PhonesController {
    @Autowired
    PhonesService phonesService;

    @GetMapping("/phones")
    public ArrayList<Phones> getPhones(){return phonesService.getPhones();}

    @GetMapping("/phones/{id}")
    public Optional<Phones> getID(@PathVariable("id") Integer id){ return this.phonesService.getID(id);}

    @PostMapping("/phones")
    public ResponseEntity<ResponseDTO> savePhone(@RequestBody RequestDTO requestDTO){
        return this.phonesService.savePhone(requestDTO);
    }

    @PutMapping("/phones")
    public ResponseEntity<ResponseDTO> updatePhone(@RequestBody RequestDTO requestDTO){
        return phonesService.actualizar(requestDTO);
    }

    @DeleteMapping("/phones")
    public ResponseEntity<ResponseDTO> deletePhone(@RequestBody RequestDTO requestDTO){
        return phonesService.deletePhone(requestDTO);
    }
}
