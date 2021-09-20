package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface PersonaService {


    // ahora toda la logica de persona
    boolean validaPersona(Persona p);

    boolean insertaPersona(Persona p);

    void eliminaPersona(Persona p);

    boolean actualizaPersona(Persona p);

    List<Persona> listaPersonas();

    Optional<Persona> retornaPorId( Long id);

    List<Persona> mostrarPorNombre(String nombre);

}
