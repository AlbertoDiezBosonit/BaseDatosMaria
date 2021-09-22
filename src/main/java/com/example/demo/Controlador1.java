package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class Controlador1 {
    private boolean personaIntroducida=false ;

    @Autowired
    PersonaService personaService;


    @PostMapping("/addPersona")
    public PersonaOutputDto addPersona(@ModelAttribute PersonaInputDto persona ) throws Exception {
        if(personaService.actualizaPersona(persona) )
            return  new PersonaOutputDto(persona.toPersona());
        throw new Exception("Fallo al insertar persona");
    }


    @GetMapping("/{id}")
    public PersonaOutputDto retorna(@PathVariable Long id){
        return personaService.retornaPorIdOutput(id);
    }

    @GetMapping("/nombre/{id}")
    public List<PersonaOutputDto> mostrarPorNombre2(@PathVariable String id){
        //return personaRepository.encontrarPorNombre(id2);
        return personaService.mostrarPorNombreOutput(id);
    }

    @GetMapping("/user/{id}")
    public List<PersonaOutputDto> mostrarPorUser(@PathVariable String id){
        //return personaRepository.encontrarPorNombre(id2);
        return personaService.retornaPorUserOutput(id);
    }

    @GetMapping("")
    public List<PersonaOutputDto> retornaTodas(){
        return personaService.listaPersonasOutput();
    }

    @PutMapping("/{id}")
    public PersonaOutputDto actualizar(@ModelAttribute PersonaInputDto persona ) throws Exception {
        personaService.actualizaPersona(persona.toPersona());
        return new PersonaOutputDto(persona.toPersona());
    }

    @DeleteMapping("/{id}")
    public String borraPersona(@PathVariable Integer id) {
     /*   personaService.eliminaPersona();
        String retorno = personas.retornaPorId(id).getNombre();
        personas.eliminarPersona(id);
        return retorno;*/
        return "";
    }



}
