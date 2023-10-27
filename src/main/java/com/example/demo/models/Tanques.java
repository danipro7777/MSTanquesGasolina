package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tanques")
public class Tanques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private String capacidad;
    private Double nivelactual;
    private String tipogasolina;
    private String ubicacion;
    private Double preciogalon;
    private String cliente;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }
}
