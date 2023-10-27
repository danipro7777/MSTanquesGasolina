package com.example.demo.repositories;

import com.example.demo.models.Tanques;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TanquesRepository extends JpaRepository<Tanques, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.capacidad = :capacidad WHERE p.id = :id")
    void updateCapacidad(@Param("capacidad") String capacidad, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.nivelactual = :nivelactual WHERE p.id = :id")
    void updateNivelActual(@Param("nivelactual") Double nivelactual, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.tipogasolina = :tipogasolina WHERE p.id = :id")
    void updateTipoGasolina(@Param("tipogasolina") String tipogasolina, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.ubicacion = :ubicacion WHERE p.id = :id")
    void updateUbicacion(@Param("ubicacion") String ubicacion, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.preciogalon = :preciogalon WHERE p.id = :id")
    void updatePrecioGalon(@Param("preciogalon") Double preciogalon, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.cliente = :cliente WHERE p.id = :id")
    void updateCliente(@Param("cliente") Integer cliente, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanques p SET p.tipopago = :tipopago WHERE p.id = :id")
    void updateTipoPago(@Param("tipopago") String tipopago, @Param("id") Integer id);
}
