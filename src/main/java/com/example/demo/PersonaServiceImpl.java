package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service //el service es necesario
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
        return p==personaRepository.save(p);
    }

    @Override
    public void eliminaPersona(Persona p) {
        personaRepository.delete(p);
    }

    @Override
    public boolean actualizaPersona(Persona p) {
        return p==personaRepository.save(p);
    }

    @Override
    public List<Persona> listaPersonas() {
        if(personaRepository!=null)
            return personaRepository.findAll();
        return null;
    }

    @Override
    public Optional<Persona> retornaPorId(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona>  mostrarPorNombre(String nombre) {
        return personaRepository.findByName(nombre);
    }
}
