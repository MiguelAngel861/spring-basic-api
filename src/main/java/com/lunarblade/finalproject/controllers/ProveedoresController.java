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

import com.lunarblade.finalproject.entities.Proveedores;
import com.lunarblade.finalproject.services.interfaces.ProveedoresService;

@RestController
@RequestMapping("api/proveedores/")
public class ProveedoresController {
    private final ProveedoresService proveedoresService;

    public ProveedoresController(ProveedoresService proveedoresService) {
        this.proveedoresService = proveedoresService;
    }

    @GetMapping("/")
    public List<Proveedores> getAllProveedores() {
        return proveedoresService.getAllProveedores();
    }

    @GetMapping("/{id}")
    public Proveedores getProveedorByID(@PathVariable("id") Integer idProveedor) {
        return proveedoresService.getProveedorByID(idProveedor);
    }

    @PostMapping("/")
    public ResponseEntity<Proveedores> createProveedor(@RequestBody Proveedores datosProveedor) {
        Proveedores nuevoProveedor = proveedoresService.createProveedor(datosProveedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedores> updateProveedor(@PathVariable("id") Integer idProveedor, @RequestBody Proveedores datosProveedor) {
        Proveedores proveedorActualizado = proveedoresService.updateProveedor(idProveedor, datosProveedor);
        if (proveedorActualizado != null) {
            return ResponseEntity.ok(proveedorActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Proveedores> deleteProveedor(@PathVariable("id") Integer idProveedor) {
        proveedoresService.deleteProveedor(idProveedor);
        return ResponseEntity.noContent().build();
    }
}
