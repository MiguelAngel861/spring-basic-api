package com.lunarblade.finalproject.repositories;

import com.lunarblade.finalproject.entities.Modelos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelosRepository extends JpaRepository<Modelos, Integer> {
}
