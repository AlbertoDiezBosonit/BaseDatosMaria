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

    @Autowired
    PersonaServiceImpl personaService;


    @GetMapping("") // sencillamente mostramos todos los    registros
    public List<Persona> listaPersonas(){

        return personaService.listaPersonas();
//        return personaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Persona> retorna(@PathVariable Long id){
        return personaService.retornaPorId(id);
    }

    @GetMapping("/nombre2/{id2}")
    public List<Persona> mostrarPorNombre2(@PathVariable String id2){
        //return personaRepository.encontrarPorNombre(id2);
        return personaService.mostrarPorNombre(id2);
    }

    @GetMapping("/nombre") // esta es solo de prueba
    public List<Persona> mostrarPorNombre(){
        //return personaRepository.encontrarPorNombre("a");
        return personaService.mostrarPorNombre("a");
    }

}
