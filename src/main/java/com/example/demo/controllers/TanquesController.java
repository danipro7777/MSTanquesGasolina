package com.example.demo.controllers;

import com.example.demo.models.Tanques;
import com.example.demo.services.TanquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
