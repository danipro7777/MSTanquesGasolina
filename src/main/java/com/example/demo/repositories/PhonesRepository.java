package com.example.demo.repositories;

import com.example.demo.models.Phones;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Phones p SET p.name = :name WHERE p.id = :id")
    void updateName(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Phones p SET p.model = :model WHERE p.id = :id")
    void updateModel(@Param("model") String model, @Param("id") Integer id);
}