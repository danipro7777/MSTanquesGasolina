package com.example.demo.services;

import com.example.demo.models.Phones;
import com.example.demo.repositories.PhonesRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.PhonesResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PhonesService {

    @Autowired
    PhonesRepository phonesRepository;

    public ArrayList<Phones> getPhones(){
        return (ArrayList<Phones>) phonesRepository.findAll();
    }

    public Optional<Phones> getID(Integer id){ return phonesRepository.findById(id);}

    //Guardar
    public ResponseEntity<ResponseDTO> savePhone(RequestDTO requestDTO){
        //Guardamos el objeto phones
        Phones phones = phonesRepository.save(requestDTO.getRequest().getPhones());
        //Damos una respuesta
        PhonesResponse phonesResponse = new PhonesResponse();
        phonesResponse.setName(phones.getName());
        phonesResponse.setModel(phones.getModel());
        phonesResponse.setPurchase(phones.getPurchase());
        phonesResponse.setSale(phones.getSale());
        phonesResponse.setStatus(phones.getStatus());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Telefono agregado correctamente");
        responseDTO.setPhones(phonesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar
    public ResponseEntity<ResponseDTO> actualizar(RequestDTO requestDTO){
        phonesRepository.updateName(requestDTO.getRequest().getPhones().getName(), requestDTO.getRequest().getPhones().getId());

        phonesRepository.updateModel(requestDTO.getRequest().getPhones().getModel(), requestDTO.getRequest().getPhones().getId());

        PhonesResponse phonesResponse = new PhonesResponse();
        phonesResponse.setName(requestDTO.getRequest().getPhones().getName());
        phonesResponse.setModel(requestDTO.getRequest().getPhones().getModel());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Telefono actualizado correctamente");
        responseDTO.setPhones(phonesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar
    public ResponseEntity<ResponseDTO> deletePhone(RequestDTO requestDTO){
        Integer id_phone = requestDTO.getRequest().getPhones().getId();
        if (phonesRepository.existsById(id_phone)){
            phonesRepository.deleteById(id_phone);

            PhonesResponse phonesResponse = new PhonesResponse();
            phonesResponse.setId(id_phone);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("Telefono eliminado correctamente");
            responseDTO.setPhones(phonesResponse);
        }else{
            PhonesResponse phonesResponse = new PhonesResponse();
            phonesResponse.setId(id_phone);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("Telefono no encontrado");
            responseDTO.setPhones(phonesResponse);
        }
        return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
    }
}
