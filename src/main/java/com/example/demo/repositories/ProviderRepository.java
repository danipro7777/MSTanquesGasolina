package com.example.demo.repositories;

import com.example.demo.models.Provider;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Provider p SET p.name = :name WHERE p.id = :id")
    void updateName(@Param("name") String name, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Provider p SET p.company = :company WHERE p.id = :id")
    void updateCompany(@Param("company") String company, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Provider p SET p.phone = :phone WHERE p.id = :id")
    void updatePhone(@Param("phone") Integer phone, @Param("id") Integer id);
}
