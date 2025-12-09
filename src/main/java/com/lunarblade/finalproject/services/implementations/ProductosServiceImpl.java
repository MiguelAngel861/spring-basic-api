package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Productos;
import com.lunarblade.finalproject.repositories.ProductosRepository;
import com.lunarblade.finalproject.services.interfaces.ProductosService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProductosServiceImpl implements ProductosService {
    private final ProductosRepository productosRepository;

    public ProductosServiceImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<Productos> getAllProductos() {
        return productosRepository.findAll();
    }

    @Override
    public Productos getProductoByID(Integer idProducto) {
        return productosRepository.findById(idProducto).orElse(null);
    }

    @Override
    public Productos createProducto(Productos datosProducto) {
        return productosRepository.save(datosProducto);
    }

    @Override
    public Productos updateProducto(Integer idProducto, Productos datosProducto) {
        Productos productoExistente = productosRepository.findById(idProducto).orElse(null);
        if (productoExistente != null) {
            productoExistente.setIdCategoria(datosProducto.getIdCategoria());
            productoExistente.setIdModelo(datosProducto.getIdModelo());

            productoExistente.setNombre(datosProducto.getNombre());
            productoExistente.setStockDisponible(datosProducto.getStockDisponible());
            productoExistente.setStockReal(datosProducto.getStockReal());
            productoExistente.setCosto(datosProducto.getCosto());
            productoExistente.setPrecio(datosProducto.getPrecio());

            productoExistente.setStatus(datosProducto.getStatus());
            productoExistente.setActualizadoPor(datosProducto.getActualizadoPor());
            productoExistente.setFechaActualizacion(datosProducto.getFechaActualizacion());

            return productosRepository.save(datosProducto);
        }
        return null;
    }

    @Override
    public void deleteProductoByID(Integer idProducto) {
        productosRepository.deleteById(idProducto);
    }
}
