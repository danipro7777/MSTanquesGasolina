package com.example.demo.services;

import com.example.demo.models.Tanques;
import com.example.demo.repositories.TanquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TanquesService {
    @Autowired
    TanquesRepository tanquesRepository;

    //GET TODOS
    public ArrayList<Tanques> getTanques(){
        return (ArrayList<Tanques>) tanquesRepository.findAll();
    }

    //GET POR ID
    public Optional<Tanques> getID(Integer id){
        return tanquesRepository.findById(id);
    }
}
