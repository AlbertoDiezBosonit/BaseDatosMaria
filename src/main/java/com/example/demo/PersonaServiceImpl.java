package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service //el service es necesario
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;


    @Override
    public boolean validaPersona(Persona p){
        String mensajeError="";
        if(6> p.getUser().length() || 10<p.getUser().length())
            mensajeError+="La longitud de User no es la correcta/n";
        if(p.getPassword()==null)
            mensajeError+="No hay mensaje de error/n";
        if( p.getName()==null)
            mensajeError+="No hay nombre/n";
        if( p.getCity()==null)
            mensajeError+="No se ha indicado una ciudad/n";
        if( p.getCreated_date()==null)
            mensajeError+="No se ha aportado una fecha de creación/n";
        if(!p.getCompany_email().contains("@"))
            mensajeError+="No se ha aportado un email de empresa correcto/n";
        if(!p.getPersonal_email().contains("@"))
            mensajeError+="No se ha aportado un email personal correcto/n";
        if(!mensajeError.equals(""))
            throw new BeanUnprocesableException("Los datos no son correctos");
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
        return insertaPersona(p.toPersona());
    }

    @Override
    public  PersonaOutputDto actualizaPersona(Long id,PersonaInputDto p){
        Persona persona;
        try {
            persona = personaRepository.getById(id);
            persona=p.toPersona(persona);
        }catch (EntityNotFoundException e){
            return null;
        }

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
        try {
            Persona p = personaRepository.getById(id);
            if (p.getUser() != null) { // hasta que no se hae un get que no sea del id no salta la excepcion
                personaRepository.delete(p);
                return true;
            }
            return false;
        }catch(EntityNotFoundException e){
            return false;
        }
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
        Optional<Persona> retorno=personaRepository.findById(id);
        if(retorno.isEmpty())
            return null;
        return retorno;
    }

   @Override
   public PersonaOutputDto retornaPorIdOutput( Long id){
        Optional<Persona> p=retornaPorId(id);
        if (p!=null && !p.isEmpty()) {
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
