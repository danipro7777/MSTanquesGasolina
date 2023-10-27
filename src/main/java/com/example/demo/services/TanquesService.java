package com.example.demo.services;

import com.example.demo.models.Provider;
import com.example.demo.models.Tanques;
import com.example.demo.repositories.TanquesRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.response.TanquesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //POST
    public ResponseEntity<ResponseDTO> saveTanques(RequestDTO requestDTO){
        Tanques tanques = tanquesRepository.save(requestDTO.getRequest().getTanques());
        //Damos una respuesta
        TanquesResponse tanquesResponse = new TanquesResponse();
        tanquesResponse.setCapacidad(tanques.getCapacidad());
        tanquesResponse.setNivelactual(tanques.getNivelactual());
        tanquesResponse.setTipogasolina(tanques.getTipogasolina());
        tanquesResponse.setUbicacion(tanques.getUbicacion());
        tanquesResponse.setPreciogalon(tanques.getPreciogalon());
        tanquesResponse.setCliente(tanques.getCliente());
        tanquesResponse.setTipopago(tanques.getTipopago());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Tanque agregado correctamente");
        responseDTO.setTanques(tanquesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //PUT
    public ResponseEntity<ResponseDTO> putTanques(RequestDTO requestDTO) {
        tanquesRepository.updateCapacidad(requestDTO.getRequest().getTanques().getCapacidad(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updateNivelActual(requestDTO.getRequest().getTanques().getNivelactual(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updateTipoGasolina(requestDTO.getRequest().getTanques().getTipogasolina(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updateUbicacion(requestDTO.getRequest().getTanques().getUbicacion(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updatePrecioGalon(requestDTO.getRequest().getTanques().getPreciogalon(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updateCliente(requestDTO.getRequest().getTanques().getCliente(), requestDTO.getRequest().getTanques().getId());

        tanquesRepository.updateTipoPago(requestDTO.getRequest().getTanques().getTipopago(), requestDTO.getRequest().getTanques().getId());

        TanquesResponse tanquesResponse = new TanquesResponse();
        tanquesResponse.setCapacidad(requestDTO.getRequest().getTanques().getCapacidad());
        tanquesResponse.setNivelactual(requestDTO.getRequest().getTanques().getNivelactual());
        tanquesResponse.setTipogasolina(requestDTO.getRequest().getTanques().getTipogasolina());
        tanquesResponse.setUbicacion(requestDTO.getRequest().getTanques().getUbicacion());
        tanquesResponse.setPreciogalon(requestDTO.getRequest().getTanques().getPreciogalon());
        tanquesResponse.setCliente(requestDTO.getRequest().getTanques().getCliente());
        tanquesResponse.setTipopago(requestDTO.getRequest().getTanques().getTipopago());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Tanque actualizado correctamente");
        responseDTO.setTanques(tanquesResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //DELETE
    public ResponseEntity<ResponseDTO> deleteTanques(RequestDTO requestDTO){
        Integer id_tanques = requestDTO.getRequest().getTanques().getId();
        if (tanquesRepository.existsById(id_tanques)){
            tanquesRepository.deleteById(id_tanques);

            TanquesResponse tanquesResponse = new TanquesResponse();
            tanquesResponse.setId(id_tanques);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("Tanque eliminado correctamente");
            responseDTO.setTanques(tanquesResponse);
        }else{
            TanquesResponse tanquesResponse = new TanquesResponse();
            tanquesResponse.setId(id_tanques);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("El tanque no existe");
            responseDTO.setTanques(tanquesResponse);
        }
        return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
    }
}
