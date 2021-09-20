package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

//@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public boolean validaPersona(Persona p){
        if(6> p.getUser().length() || 10<p.getUser().length())
            return false;
        if(p.getPassword()==null || p.getName()==null || p.getCity()==null || p.getCreated_date()==null)
            return false;
        if(!p.getCompany_email().contains("@"))
            return false;
        if(!p.getPersonal_email().contains("@"))
            return false;
        return true;
    }

    @Override
    public boolean insertaPersona(Persona p) {
        return false;
    }

    @Override
    public boolean eliminaPersona(Persona p) {
        return false;
    }

    @Override
    public boolean actualizaPersona(Persona p) {
        return false;
    }

    @Override
    public List<Persona> listaPersonas() {
        return null;
    }

    @Override
    public Optional<Persona> retornaPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Persona> mostrarPorNombre(String nombre) {
        return null;
    }
}
