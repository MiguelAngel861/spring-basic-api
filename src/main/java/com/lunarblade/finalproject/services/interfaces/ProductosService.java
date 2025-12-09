package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Productos;
import java.util.List;
public interface ProductosService
{
    List<Productos> getAllProductos();
    Productos getProductoByID(Integer idProducto);
    Productos createProducto(Productos datosProducto);
    Productos updateProducto(Integer idProducto, Productos datosProducto);
    void deleteProductoByID(Integer idProducto);
}
