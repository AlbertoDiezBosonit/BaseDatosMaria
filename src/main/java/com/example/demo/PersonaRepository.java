package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona,Integer> {
    @Query("select p from Persona p where p.name = ?1")
    public List<Persona> encontrarPorNombre(String nombre);
    // el query tiene que estar aqui

    public List<Persona> findByName(String name);
    // así es mas simple
}
