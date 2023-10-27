package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "tanques")
public class Tanques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    private Integer capacidad;
    private Double nivelactual;
    private String tipogasolina;
    private String ubicacion;
    private Double preciogalon;
    private String cliente;
    private String tipopago;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }
}
