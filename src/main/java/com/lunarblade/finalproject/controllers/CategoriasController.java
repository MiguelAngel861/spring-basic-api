package com.lunarblade.finalproject.controllers;

//Importaciones
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

import com.lunarblade.finalproject.entities.Categorias;
import com.lunarblade.finalproject.services.interfaces.CategoriasService;

@RestController
@RequestMapping("api/categorias/")
public class CategoriasController {
    private final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/")
    public List<Categorias> getAllCategorias() {
        return categoriasService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public Categorias getCategoriaByID(@PathVariable("id") Integer idCategoria) {
        return categoriasService.getCategoriaByID(idCategoria);
    }

    @PostMapping("/")
    public ResponseEntity<Categorias> createCategoria(@RequestBody Categorias datosCategoria) {
        Categorias nuevaCategoria = categoriasService.createCategoria(datosCategoria);

        // Devuelve el ResponseEntity completo, incluyendo el código 201 CREATED y el cuerpo.
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorias> updateCategoria(@PathVariable("id") Integer idCategoria, @RequestBody Categorias datosCategoria) {
        Categorias categoriaActualizada = categoriasService.updateCategoria(idCategoria, datosCategoria);
        if (categoriaActualizada != null) {
            return ResponseEntity.ok(categoriaActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categorias> deleteCategoria(@PathVariable("id") Integer idCategoria) {
        categoriasService.deleteCategoria(idCategoria);
        return ResponseEntity.noContent().build();
    }
}
