package com.example.demo.services;

import com.example.demo.models.Phones;
import com.example.demo.models.Provider;
import com.example.demo.repositories.ProviderRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.PhonesResponse;
import com.example.demo.response.ProviderResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProviderService {
    @Autowired
    ProviderRepository providerRepository;

    //GET TODOS
    public ArrayList<Provider> getProviders(){
        return (ArrayList<Provider>) providerRepository.findAll();
    }

    //GET POR ID
    public Optional<Provider> getID(Integer id){
        return providerRepository.findById(id);
    }

    //POST
    public ResponseEntity<ResponseDTO> saveProvider(RequestDTO requestDTO){
        Provider provider = providerRepository.save(requestDTO.getRequest().getProvider());
        //Damos una respuesta
        ProviderResponse providerResponse = new ProviderResponse();
        providerResponse.setName(provider.getName());
        providerResponse.setCompany(provider.getCompany());
        providerResponse.setPhone(provider.getPhone());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Proveedor agregado correctamente");
        responseDTO.setProvider(providerResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //PUT
    public ResponseEntity<ResponseDTO> putProvider(RequestDTO requestDTO){
        providerRepository.updateName(requestDTO.getRequest().getProvider().getName(), requestDTO.getRequest().getProvider().getId());

        providerRepository.updateCompany(requestDTO.getRequest().getProvider().getCompany(), requestDTO.getRequest().getProvider().getId());

        providerRepository.updatePhone(requestDTO.getRequest().getProvider().getPhone(), requestDTO.getRequest().getProvider().getId());

        ProviderResponse providerResponse = new ProviderResponse();
        providerResponse.setName(requestDTO.getRequest().getProvider().getName());
        providerResponse.setCompany(requestDTO.getRequest().getProvider().getCompany());
        providerResponse.setPhone(requestDTO.getRequest().getProvider().getPhone());

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Proveedor actualizado correctamente");
        responseDTO.setProvider(providerResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //DELETE
    public ResponseEntity<ResponseDTO> deleteProvider(RequestDTO requestDTO){
        Integer id_provider = requestDTO.getRequest().getProvider().getId();
        if (providerRepository.existsById(id_provider)){
            providerRepository.deleteById(id_provider);

            ProviderResponse providerResponse = new ProviderResponse();
            providerResponse.setId(id_provider);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("Proveedor eliminado correctamente");
            responseDTO.setProvider(providerResponse);
        }else{
            ProviderResponse providerResponse = new ProviderResponse();
            providerResponse.setId(id_provider);

            ResponseDTO responseDTO = new ResponseDTO();
            responseDTO.setResponse("Proveedor no encontrado");
            responseDTO.setProvider(providerResponse);
        }
        return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
    }
}
