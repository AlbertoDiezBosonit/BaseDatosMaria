package com.example.demo;

import lombok.Data;

import java.sql.Date;

@Data
public class PersonaInputDto {
    // clase DTO para el tipo persona
    Long id;
    String user ;
    String password ;
    String name ;
    String surname ;
    String company_email;
    String personal_email;
    String city;
    String imagen_url;
    Date termination_date;
    Date created_date;

    public PersonaInputDto(Persona p){
        if(p!=null){
            if(p.getId()!=null)
                this.setId(p.getId());
            this.setUser(p.getUser());
            this.setPassword(p.getPassword());
            this.setName(p.getName());
            this.setSurname(p.getSurname());
            this.setCompany_email(p.getCompany_email());
            this.setPersonal_email(p.getPersonal_email());
            this.setCity(p.getCity());
            this.setImagen_url(p.getImagen_url());
            this.setTermination_date(p.getTermination_date());
            this.setCreated_date(p.getCreated_date());
        }
    }

    public Persona toPersona(){
        Persona p=new Persona();
        p.setId(this.getId());
        p.setUser(this.getUser());
        p.setPassword(this.getPassword());
        p.setName(this.getName());
        p.setSurname(this.getSurname());
        p.setCompany_email(this.getCompany_email());
        p.setPersonal_email(this.getPersonal_email());
        p.setCity(this.getCity());
        p.setImagen_url(this.getImagen_url());
        p.setTermination_date(this.getTermination_date());
        p.setCreated_date(this.getCreated_date());
        return p;
    }

    public Persona toPersona(Persona p){
        p.setId(this.getId());
        p.setUser(this.getUser());
        p.setPassword(this.getPassword());
        p.setName(this.getName());
        p.setSurname(this.getSurname());
        p.setCompany_email(this.getCompany_email());
        p.setPersonal_email(this.getPersonal_email());
        p.setCity(this.getCity());
        p.setImagen_url(this.getImagen_url());
        p.setTermination_date(this.getTermination_date());
        p.setCreated_date(this.getCreated_date());
        return p;
    }

}
