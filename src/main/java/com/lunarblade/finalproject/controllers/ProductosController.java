package com.lunarblade.finalproject.controllers;

// Importaciones SpringBoot
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Importaciones Java
import java.util.List;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Productos;
import com.lunarblade.finalproject.services.interfaces.ProductosService;

@RestController
@RequestMapping("api/productos/")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/")
    public List<Productos> getAllProductos() {
        return productosService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Productos> getProductoByID(@PathVariable("id") Integer idProducto) {
        Productos producto = productosService.getProductoByID(idProducto);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Productos> createProducto(@RequestBody Productos datosProducto) {
        Productos nuevoProducto = productosService.createProducto(datosProducto);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Productos> updateProducto(@PathVariable("id") Integer idProducto, @RequestBody Productos datosProducto) {
        Productos productoActualizado = productosService.updateProducto(idProducto, datosProducto);
        if (productoActualizado != null) {
            return ResponseEntity.ok(productoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id") Integer idProducto) {
        productosService.deleteProductoByID(idProducto);

        return ResponseEntity.noContent().build();
    }
}
