package com.lunarblade.finalproject.services.interfaces;
import com.lunarblade.finalproject.entities.DetallesCompras;
import java.util.List;

public interface DetallesComprasService
{
    List<DetallesCompras> getAllDetallesCompras();
    DetallesCompras getDetalleCompraByID(Integer idDetalleCompra);
    DetallesCompras createDetalleCompra(DetallesCompras datosDetalle);
    DetallesCompras updateDetalleCompra(Integer idDetalleCompra, DetallesCompras datosDetalle);
    void deleteDetalleCompra(Integer idDetalleCompra);
}
