package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Proveedores;
import java.util.List;

public interface ProveedoresService
{
    List<Proveedores> getAllProveedores();
    Proveedores getProveedorByID(Integer idProveedor);
    Proveedores createProveedor(Proveedores datosProveedor);
    Proveedores updateProveedor(Integer idProveedor, Proveedores datosProveedor);
    void deleteProveedor(Integer idProveedor);
}
