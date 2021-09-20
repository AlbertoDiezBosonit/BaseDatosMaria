package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class Controlador1 {
    private boolean personaIntroducida=false;

    private boolean validaPersona(Persona p){
  /*      if(6> p.getUser().length() || 10<p.getUser().length())
            return false;
        if(p.getPassword()==null || p.getName()==null || p.getCity()==null || p.getCreated_date()==null)
            return false;
        if(!p.getCompany_email().contains("@"))
            return false;
        if(!p.getPersonal_email().contains("@"))
            return false;*/
        return true;
    }

    private boolean introducirPersona(){
        //if(this.personaIntroducida)            return false;
        this.personaIntroducida=true;
        Persona p = new Persona();


       p.setNombre("alberto");
        p.setEdad("1");
        p.setPoblacion("Zaragoza");


        if(this.validaPersona(p)) {
            personaRepository.save(p);

          //  personaRepository.flush();
        }
        else{
            System.out.println("Datos de la persona NO validos");
        }
        return true;
    }

    @Autowired
    PersonaRepository personaRepository;

    @GetMapping("") // sencillamente mostramos todos los registros
    public List<Persona> listaPersonas(){
        /*Persona p=new Persona();
        p.setActive(true);
        p.setName("a");
        p.setCity("Logroño");
        p.setCompany_email("A");
        personaRepository.save(p);
        personaRepository.flush();*/
        this.introducirPersona();
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> retorna(@PathVariable Integer id){
        return personaRepository.findById(id);
    }

    @GetMapping("/nombre2/{id2}")
    public List<Persona> mostrarPorNombre2(@PathVariable String id2){
        //return personaRepository.encontrarPorNombre(id2);
        return personaRepository.findByNombre(id2);
    }

    @GetMapping("/nombre") // esta es solo de prueba
    public List<Persona> mostrarPorNombre(){
        //return personaRepository.encontrarPorNombre("a");
        return personaRepository.findByNombre("a");
    }

}
