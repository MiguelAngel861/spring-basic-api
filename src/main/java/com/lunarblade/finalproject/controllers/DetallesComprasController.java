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

import com.lunarblade.finalproject.entities.DetallesCompras;
import com.lunarblade.finalproject.services.interfaces.DetallesComprasService;

@RestController
@RequestMapping("api/detalles-compras/")
public class DetallesComprasController {
    private final DetallesComprasService detallesComprasService;

    public DetallesComprasController(DetallesComprasService detallesComprasService) {
        this.detallesComprasService = detallesComprasService;
    }

    @GetMapping("/")
    public List<DetallesCompras> getAllDetallesCompras() {
        return detallesComprasService.getAllDetallesCompras();
    }

    @GetMapping("/{id}")
    public DetallesCompras getDetalleCompraByID(@PathVariable("id") Integer idDetalleCompra) {
        return detallesComprasService.getDetalleCompraByID(idDetalleCompra);
    }

    @PostMapping("/")
    public ResponseEntity<DetallesCompras> createDetalleCompra(@RequestBody DetallesCompras datosDetalleCompra) {
        DetallesCompras nuevoDetalleCompra = detallesComprasService.createDetalleCompra(datosDetalleCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDetalleCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesCompras> updateDetalleCompra(@PathVariable("id") Integer idDetalleCompra, @RequestBody DetallesCompras datosDetalleCompra) {
        DetallesCompras detalleCompraActualizado = detallesComprasService.updateDetalleCompra(idDetalleCompra, datosDetalleCompra);
        if (detalleCompraActualizado != null) {
            return ResponseEntity.ok(detalleCompraActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DetallesCompras> deleteDetalleCompra(@PathVariable("id") Integer idDetalleCompra) {
        detallesComprasService.deleteDetalleCompra(idDetalleCompra);
        return ResponseEntity.noContent().build();
    }
}
