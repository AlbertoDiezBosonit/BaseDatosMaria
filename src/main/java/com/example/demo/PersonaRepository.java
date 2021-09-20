package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonaRepository extends JpaRepository<Persona,Long> {
  //  @Query("select p from Persona p where p.name = ?1")
  //  public List<Persona> encontrarPorNombre(String nombre);
    // el query tiene que estar aqui

    List<Persona> findByName(String name);
    // así es mas simple
}
