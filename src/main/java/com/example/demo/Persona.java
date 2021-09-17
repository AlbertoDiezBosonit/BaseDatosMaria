package com.example.demo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {
    @Id
    @GeneratedValue
    Integer Id;

    @Column
    String usuario,password,name,surname,company_email,personal_email,city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;
}
