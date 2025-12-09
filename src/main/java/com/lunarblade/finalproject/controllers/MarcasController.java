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

import com.lunarblade.finalproject.entities.Marcas;
import com.lunarblade.finalproject.services.interfaces.MarcasService;

@RestController
@RequestMapping("api/marcas/")
public class MarcasController {
    private final MarcasService marcasService;

    public MarcasController(MarcasService marcasService) {
        this.marcasService = marcasService;
    }

    @GetMapping("/")
    public List<Marcas> getAllMarcas() {
        return marcasService.getAllMarcas();
    }

    @GetMapping("/{id}")
    public Marcas getMarcaByID(@PathVariable("id") Integer idMarca) {
        return marcasService.getMarcaByID(idMarca);
    }

    @PostMapping("/")
    public ResponseEntity<Marcas> createMarca(@RequestBody Marcas datosMarca) {
        Marcas nuevaMarca = marcasService.createMarca(datosMarca);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMarca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marcas> updateMarca(@PathVariable("id") Integer idMarca, @RequestBody Marcas datosMarca) {
        Marcas marcaActualizada = marcasService.updateMarca(idMarca, datosMarca);
        if (marcaActualizada != null) {
            return ResponseEntity.ok(marcaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marcas> deleteMarca(@PathVariable("id") Integer idMarca) {
        marcasService.deleteMarca(idMarca);
        return ResponseEntity.noContent().build();
    }
}
