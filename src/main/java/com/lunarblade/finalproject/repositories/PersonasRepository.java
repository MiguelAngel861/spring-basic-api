package com.lunarblade.finalproject.repositories;

import com.lunarblade.finalproject.entities.Personas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonasRepository extends JpaRepository<Personas, Integer> {
}
