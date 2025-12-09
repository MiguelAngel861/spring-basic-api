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

import com.lunarblade.finalproject.entities.Compras;
import com.lunarblade.finalproject.services.interfaces.ComprasService;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {
    private final ComprasService comprasService;

    public ComprasController(ComprasService comprasService) {
        this.comprasService = comprasService;
    }

    @GetMapping("/")
    public List<Compras> getAllCompras() {
        return  comprasService.getAllCompras();
    }

    @GetMapping("/{id}")
    public Compras getCompraById(@PathVariable Integer id) {
        return comprasService.getCompraByID(id);
    }

    @PostMapping
    public ResponseEntity<Compras> createCompra(@RequestBody Compras compra) {
        Compras nuevaCompra = comprasService.createCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compras> updateCompra(@PathVariable Integer id, @RequestBody Compras compra) {
        Compras compraActualizada = comprasService.updateCompra(id, compra);
        if (compraActualizada != null) {
            return ResponseEntity.ok(compraActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable Integer id) {
        comprasService.deleteCompra(id);
        return ResponseEntity.noContent().build();
    }
}
