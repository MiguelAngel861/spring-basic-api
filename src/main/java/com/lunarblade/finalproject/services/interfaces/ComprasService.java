package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Compras;
import java.util.List;

public interface ComprasService
{
    List<Compras> getAllCompras();
    Compras createCompra(Compras compra);
    Compras getCompraByID(Integer idCompra);
    Compras updateCompra(Integer idCompra, Compras datosCompra);
    void deleteCompra(Integer idCompra);
}
