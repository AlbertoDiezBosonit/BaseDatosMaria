package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class Controlador1 {

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
        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> retorna(@PathVariable Integer id){
        return personaRepository.findById(id);
    }

    @GetMapping("/nombre2/{id2}")
    public List<Persona> mostrarPorNombre2(@PathVariable String id2){
        return personaRepository.encontrarPorNombre(id2);
        //return personaRepository.findByName(id2);
    }

    @GetMapping("/nombre") // esta es solo de prueba
    public List<Persona> mostrarPorNombre(){
        //return personaRepository.encontrarPorNombre("a");
        return personaRepository.findByName("a");
    }







}
