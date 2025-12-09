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

import com.lunarblade.finalproject.entities.Contactos;
import com.lunarblade.finalproject.services.interfaces.ContactosService;

@RestController
@RequestMapping("api/contactos/")
public class ContactosController {
    private final ContactosService contactosService;

    public ContactosController(ContactosService contactosService) {
        this.contactosService = contactosService;
    }

    @GetMapping("/")
    public List<Contactos> getAllContactos() {
        return contactosService.getAllContactos();
    }

    @GetMapping("/{id}")
    public Contactos getContactoByID(@PathVariable("id") Integer idContacto) {
        return contactosService.getContactoByID(idContacto);
    }

    @PostMapping("/")
    public ResponseEntity<Contactos> createContacto(@RequestBody Contactos datosContacto) {
        Contactos nuevoContacto = contactosService.createContacto(datosContacto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoContacto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contactos> updateContacto(@PathVariable("id") Integer idContacto, @RequestBody Contactos datosContacto) {
        Contactos contactoActualizado = contactosService.updateContacto(idContacto, datosContacto);
        if (contactoActualizado != null) {
            return ResponseEntity.ok(contactoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Contactos> deleteContacto(@PathVariable("id") Integer idContacto) {
        contactosService.deleteContacto(idContacto);
        return ResponseEntity.noContent().build();
    }
}
