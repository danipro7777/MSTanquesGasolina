package com.example.demo.controllers;

import com.example.demo.models.Phones;
import com.example.demo.models.Provider;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/apiprovider")
public class ProviderController {
    @Autowired
    ProviderService providerService;

    //GET TODOS
    @GetMapping("/get")
    public ArrayList<Provider> getProviders(){return providerService.getProviders();}

    //GET POR ID
    @GetMapping("/get/{id}")
    public Optional<Provider> getID(@PathVariable("id") Integer id){
        return this.providerService.getID(id);
    }

    //POST
    @PostMapping("/save")
    public ResponseEntity<ResponseDTO> saveProvider(@RequestBody RequestDTO requestDTO){
        return this.providerService.saveProvider(requestDTO);
    }

    @PutMapping("/put")
    public ResponseEntity<ResponseDTO> updateProvider(@RequestBody RequestDTO requestDTO){
        return providerService.putProvider(requestDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deletePhone(@RequestBody RequestDTO requestDTO){
        return providerService.deleteProvider(requestDTO);
    }
}
