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

import com.lunarblade.finalproject.entities.ContactoPersonas;
import com.lunarblade.finalproject.services.interfaces.ContactoPersonasService;
@RestController
@RequestMapping("api/contacto-personas/")
public class ContactoPersonasController {
    private final ContactoPersonasService contactoPersonasService;

    public ContactoPersonasController(ContactoPersonasService contactoPersonasService) {
        this.contactoPersonasService = contactoPersonasService;
    }

    @GetMapping("/")
    public List<ContactoPersonas> getAllContactoPersonas() {
        return contactoPersonasService.getAllContactosPersonas();
    }

    @GetMapping("/{id}")
    public ContactoPersonas getContactoPersonaByID(@PathVariable("id") Integer idContactoPersona) {
        return contactoPersonasService.getContactoPersonaByID(idContactoPersona);
    }

    @PostMapping("/")
    public ResponseEntity<ContactoPersonas> createContactoPersona(@RequestBody ContactoPersonas datosContactoPersona) {
        ContactoPersonas nuevoContactoPersona = contactoPersonasService.createContactoPersona(datosContactoPersona);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoContactoPersona);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactoPersonas> updateContactoPersona(@PathVariable("id") Integer idContactoPersona, @RequestBody ContactoPersonas datosContactoPersona) {
        ContactoPersonas contactoPersonaActualizado = contactoPersonasService.updateContactoPersona(idContactoPersona, datosContactoPersona);
        if (contactoPersonaActualizado != null) {
            return ResponseEntity.ok(contactoPersonaActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactoPersonas> deleteContactoPersona(@PathVariable("id") Integer idContactoPersona) {
        contactoPersonasService.deleteContactoPersona(idContactoPersona);
        return ResponseEntity.noContent().build();
    }
}
