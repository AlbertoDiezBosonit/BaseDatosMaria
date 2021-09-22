package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public PersonaOutputDto insertaPersona(Persona p) {
        p.setActive("activo");
        p.setCreated_date(new java.sql.Date(new java.util.Date().getTime()));
        if(validaPersona(p)) {
            personaRepository.save(p);
            return new PersonaOutputDto(p);
        }
        return null;

    }

    @Override
    public PersonaOutputDto insertaPersona(PersonaInputDto p) {
        // vamos a eliminar el id para insertarlo en la base de datos
        p.setId(null);
        return insertaPersona(p.toPersona());
    }

    @Override
    public  PersonaOutputDto actualizaPersona(PersonaInputDto p){
        Persona persona=personaRepository.getById(p.getId());
        persona=p.toPersona(persona);
        //persona.setCreated_date(new java.sql.Date(new java.util.Date().getTime()));
        return actualizaPersona(persona);
        //return persona==personaRepository.save(persona);
    }

    @Override
    public  PersonaOutputDto actualizaPersona(Persona p) {
        p.setActive("true");
        if(this.validaPersona(p)) {
            personaRepository.save(p);
            return new PersonaOutputDto(p);
        }
        return null;
    }

    @Override
    public void eliminaPersona(Persona p) {
        personaRepository.delete(p);
    }

    @Override
    public void eliminaPersona(PersonaInputDto p) {
        personaRepository.delete(p.toPersona());
    }

    @Override
    public boolean eliminaPersonaPorId(Long id){
        Persona p=personaRepository.getById(id);
        if(p!=null) {
            personaRepository.delete(p);
            return true;
        }
        return  false;
    }




    @Override
    public List<Persona> listaPersonas() {
        if(personaRepository!=null)
            return personaRepository.findAll();
        return null;
    }

    @Override
    public List<PersonaOutputDto> listaPersonasOutput(){
        if(personaRepository!=null) {
            List<PersonaOutputDto> retorno=new ArrayList<>();
            List<Persona> personas=personaRepository.findAll();
            for(Persona p:personas)
                retorno.add(new PersonaOutputDto(p));
            return retorno;
        }
        return null;
    }

    @Override
    public Optional<Persona> retornaPorId(Long id) {
        return personaRepository.findById(id);
    }

   @Override
   public PersonaOutputDto retornaPorIdOutput( Long id){
        Optional<Persona> p=retornaPorId(id);
        if (!p.isEmpty()) {
            return new PersonaOutputDto(p.get());
        }
        return null;
   }

    @Override
    public List<Persona>  mostrarPorNombre(String nombre) {
        return personaRepository.findByName(nombre);
    }

    @Override
    public List<PersonaOutputDto> mostrarPorNombreOutput(String nombre){
        List<PersonaOutputDto> retorno=new ArrayList<>();
        List<Persona> personas=personaRepository.findByName(nombre);
        for(Persona p:personas)
            retorno.add(new PersonaOutputDto(p));
        return retorno;
    }

    @Override
    public List<PersonaOutputDto> retornaPorUserOutput( String user){
        List<PersonaOutputDto> retorno=new ArrayList<>();
        List<Persona> personas=personaRepository.findByUser(user);
        for(Persona p:personas)
            retorno.add(new PersonaOutputDto(p));
        return retorno;
    }
}
