package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.DetallesCompras;
import com.lunarblade.finalproject.repositories.DetallesComprasRepository;
import com.lunarblade.finalproject.services.interfaces.DetallesComprasService;

//Impoertaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DetallesComprasServiceImpl implements DetallesComprasService {
    private final DetallesComprasRepository detallesComprasRepository;

    public DetallesComprasServiceImpl(DetallesComprasRepository detallesComprasRepository) {
        this.detallesComprasRepository = detallesComprasRepository;
    }

    @Override
    public List<DetallesCompras> getAllDetallesCompras() {
        return detallesComprasRepository.findAll();
    }

    @Override
    public DetallesCompras getDetalleCompraByID(Integer idDetalleCompra) {
        return detallesComprasRepository.findById(idDetalleCompra).orElse(null);
    }

    @Override
    public DetallesCompras createDetalleCompra(DetallesCompras datosDetalle) {
        return detallesComprasRepository.save(datosDetalle);
    }

    @Override
    public DetallesCompras updateDetalleCompra(Integer idDetalleCompra, DetallesCompras datosDetalle) {
        DetallesCompras detalleExistente = detallesComprasRepository.findById(idDetalleCompra).orElse(null);
        if (detalleExistente != null) {
            detalleExistente.setIdCompra(datosDetalle.getIdCompra());
            detalleExistente.setIdProducto(datosDetalle.getIdProducto());

            detalleExistente.setCantidad(datosDetalle.getCantidad());
            detalleExistente.setDescuento(datosDetalle.getDescuento());
            detalleExistente.setIva(datosDetalle.getIva());
            detalleExistente.setSubtotal(datosDetalle.getSubtotal());

            detalleExistente.setStatus(datosDetalle.getStatus());
            detalleExistente.setActualizadoPor(datosDetalle.getActualizadoPor());
            detalleExistente.setFechaActualizacion(datosDetalle.getFechaActualizacion());

            return detallesComprasRepository.save(detalleExistente);
        }
        return null;
    }
    @Override
    public void deleteDetalleCompra(Integer idDetalleCompra) {
        detallesComprasRepository.deleteById(idDetalleCompra);
    }
}
