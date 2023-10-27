package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
public class TanquesResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("capacidad")
    private String capacidad;
    @JsonProperty("nivelactual")
    private Double nivelactual;
    @JsonProperty("tipogasolina")
    private String tipogasolina;
    @JsonProperty("ubicacion")
    private String ubicacion;
    @JsonProperty("preciogalon")
    private Double preciogalon;
    @JsonProperty("cliente")
    private Integer cliente;
    @JsonProperty("tipopago")
    private String tipopago;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Double getNivelactual() {
        return nivelactual;
    }

    public void setNivelactual(Double nivelactual) {
        this.nivelactual = nivelactual;
    }

    public String getTipogasolina() {
        return tipogasolina;
    }

    public void setTipogasolina(String tipogasolina) {
        this.tipogasolina = tipogasolina;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPreciogalon() {
        return preciogalon;
    }

    public void setPreciogalon(Double preciogalon) {
        this.preciogalon = preciogalon;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }
}
