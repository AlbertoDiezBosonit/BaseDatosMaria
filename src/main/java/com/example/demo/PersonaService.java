package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service //el service es necesario
public interface PersonaService {


    // ahora toda la logica de persona
    boolean validaPersona(Persona p);

    PersonaOutputDto insertaPersona(PersonaInputDto p);
    PersonaOutputDto insertaPersona(Persona p);

    void eliminaPersona(Persona p);

    void eliminaPersona(PersonaInputDto p);

    boolean eliminaPersonaPorId(Long id);

    PersonaOutputDto actualizaPersona(Persona p);

    PersonaOutputDto actualizaPersona(PersonaInputDto p);

    List<Persona> listaPersonas();

    List<PersonaOutputDto> listaPersonasOutput();

    Optional<Persona> retornaPorId( Long id);

    PersonaOutputDto retornaPorIdOutput( Long id);

    List<PersonaOutputDto> retornaPorUserOutput( String user);

    List<Persona> mostrarPorNombre(String nombre);

    List<PersonaOutputDto> mostrarPorNombreOutput(String nombre);

}
