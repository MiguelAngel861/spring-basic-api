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

import com.lunarblade.finalproject.entities.Modelos;
import com.lunarblade.finalproject.services.interfaces.ModelosService;

@RestController
@RequestMapping("api/modelos/")
public class ModelosController {
    private final ModelosService modelosService;

    public ModelosController(ModelosService modelosService) {
        this.modelosService = modelosService;
    }

    @GetMapping("/")
    public List<Modelos> getAllModelos() {
        return modelosService.getAllModelos();
    }

    @GetMapping("/{id}")
    public Modelos getModeloByID(@PathVariable("id") Integer idModelo) {
        return modelosService.getModeloByID(idModelo);
    }

    @PostMapping("/")
    public ResponseEntity<Modelos> createModelo(@RequestBody Modelos datosModelo) {
        Modelos nuevoModelo = modelosService.createModelo(datosModelo);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelos> updateModelo(@PathVariable("id") Integer idModelo, @RequestBody Modelos datosModelo) {
        Modelos modeloActualizado = modelosService.updateModelo(idModelo, datosModelo);
        if (modeloActualizado != null) {
            return ResponseEntity.ok(modeloActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Modelos> deleteModelo(@PathVariable("id") Integer idModelo) {
        modelosService.deleteModelo(idModelo);
        return ResponseEntity.noContent().build();
    }
}
