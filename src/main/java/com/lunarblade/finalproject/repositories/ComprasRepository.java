package com.lunarblade.finalproject.repositories;

import com.lunarblade.finalproject.entities.Compras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Integer> {
}
