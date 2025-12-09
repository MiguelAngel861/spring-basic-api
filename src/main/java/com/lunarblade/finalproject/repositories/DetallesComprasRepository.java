package com.lunarblade.finalproject.repositories;

import com.lunarblade.finalproject.entities.DetallesCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesComprasRepository extends JpaRepository<DetallesCompras, Integer> {
}
