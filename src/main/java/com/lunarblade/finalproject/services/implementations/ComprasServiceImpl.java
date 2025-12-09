package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Compras;
import com.lunarblade.finalproject.repositories.ComprasRepository;
import com.lunarblade.finalproject.services.interfaces.ComprasService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ComprasServiceImpl implements ComprasService {
    private final ComprasRepository comprasRepository;

    public ComprasServiceImpl(ComprasRepository comprasRepository) {
        this.comprasRepository = comprasRepository;
    }

    @Override
    public List<Compras> getAllCompras() {
        return comprasRepository.findAll();
    }

    @Override
    public Compras getCompraByID(Integer id_compra) {
        return comprasRepository.findById(id_compra).orElse(null);
    }

    @Override
    public Compras createCompra(Compras datosCompra) {
        return comprasRepository.save(datosCompra);
    }

    @Override
    public Compras updateCompra(Integer id_compra, Compras datosCompra) {
        Compras compraExistente = comprasRepository.findById(id_compra).orElse(null);
        if (compraExistente != null) {
            compraExistente.setIdProveedor(datosCompra.getIdProveedor());

            compraExistente.setStatus(datosCompra.getStatus());
            compraExistente.setActualizadoPor(datosCompra.getActualizadoPor());
            compraExistente.setFechaActualizacion(datosCompra.getFechaActualizacion());

            return comprasRepository.save(compraExistente);
        }

        return null;
    }

    @Override
    public void deleteCompra(Integer id_compra) {
        comprasRepository.deleteById(id_compra);
    }
}