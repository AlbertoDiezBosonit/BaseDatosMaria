package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

//@Service
public class PersonaServiceImpl implements PersonaService {

    Persona persona=new Persona();

    @Override
    public String getNombre() {
        return persona.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        persona.setNombre(nombre);
    }
}
