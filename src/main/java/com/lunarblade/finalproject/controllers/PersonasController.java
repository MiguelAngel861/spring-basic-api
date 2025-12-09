package com.lunarblade.finalproject.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lunarblade.finalproject.entities.Personas;
import com.lunarblade.finalproject.services.interfaces.PersonasService;

@RestController
@RequestMapping("/api/personas")
public class PersonasController {
    private final PersonasService personasService;

    public PersonasController(PersonasService personasService) {
        this.personasService = personasService;
    }

    @GetMapping
    public List<Personas> getAllPersonas() {
        return personasService.getAllPersonas();
    }

    @GetMapping("/{id}")
    public Personas getPersonaById(@PathVariable Integer id) {
        return personasService.getPersonaByID(id);
    }

    @PostMapping
    public ResponseEntity<Personas> createPersona(@RequestBody Personas persona) {
        Personas createdPersona = personasService.createPersona(persona);
        return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personas> updatePersona(@PathVariable Integer id, @RequestBody Personas persona) {
        Personas updatedPersona = personasService.updatePersona(id, persona);
        return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Integer id) {
        personasService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
