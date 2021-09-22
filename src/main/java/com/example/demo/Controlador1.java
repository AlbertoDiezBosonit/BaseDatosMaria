package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;


import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("persona")
public class Controlador1 {


    @Autowired
    PersonaService personaService;


    @PostMapping("/addPersona")
    @Transactional(rollbackOn = Exception.class)
    public PersonaOutputDto addPersona(@ModelAttribute/*@RequestBody*/ PersonaInputDto persona ) throws Exception {
        PersonaOutputDto retorno=personaService.insertaPersona(persona);
        if( retorno!=null)
            return  retorno;
        throw new Exception("Fallo al insertar persona");
    }


    @GetMapping("/{id}")
    public PersonaOutputDto retorna(@PathVariable Long id){
        return personaService.retornaPorIdOutput(id);
    }

    @GetMapping("/nombre/{id}")
    public List<PersonaOutputDto> mostrarPorNombre2(@PathVariable String id){
        return personaService.mostrarPorNombreOutput(id);
    }

    @GetMapping("/user/{id}")
    public List<PersonaOutputDto> mostrarPorUser(@PathVariable String id){
        return personaService.retornaPorUserOutput(id);
    }

    @GetMapping("")
    public List<PersonaOutputDto> retornaTodas(){
        return personaService.listaPersonasOutput();
    }

    @PutMapping("") // actualizamos la persona, hay que estar atentos a la id
    @Transactional(rollbackOn = Exception.class)
    public PersonaOutputDto actualizar(@ModelAttribute PersonaInputDto persona ) throws Exception {
        return personaService.actualizaPersona(persona);
    }

    @DeleteMapping("/{id}")
    @Transactional(rollbackOn = Exception.class)
    public String borraPersona(@PathVariable Long id) throws Exception{
        if( personaService.eliminaPersonaPorId(id))
            return "Borrado";
        throw new Exception("Fallo al borrar persona");
    }







}
