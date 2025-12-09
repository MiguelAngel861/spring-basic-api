package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Proveedores;
import com.lunarblade.finalproject.repositories.ProveedoresRepository;
import com.lunarblade.finalproject.services.interfaces.ProveedoresService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
    private final ProveedoresRepository proveedoresRepository;

    ProveedoresServiceImpl(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<Proveedores> getAllProveedores() {
        return proveedoresRepository.findAll();
    }

    @Override
    public Proveedores getProveedorByID(Integer id_proveedor) {
        return proveedoresRepository.findById(id_proveedor).orElse(null);
    }

    @Override
    public Proveedores createProveedor(Proveedores datosProveedor) {
        return proveedoresRepository.save(datosProveedor);
    }

    @Override
    public Proveedores updateProveedor(Integer id_proveedor, Proveedores datosProveedor) {
        Proveedores proveedorExistente = proveedoresRepository.findById(id_proveedor)
                .orElse(null);

        if (proveedorExistente != null)  {
            proveedorExistente.setCompras(datosProveedor.getCompras());
            proveedorExistente.setIdModelo(datosProveedor.getIdModelo());
            proveedorExistente.setIdPersona(datosProveedor.getIdPersona());
            proveedorExistente.setNumeroRuc(datosProveedor.getNumeroRuc());
            proveedorExistente.setFechaActualizacion(datosProveedor.getFechaActualizacion());
            proveedorExistente.setActualizadoPor(datosProveedor.getActualizadoPor());

            return proveedoresRepository.save(proveedorExistente);
        }

        return null;
    }

    @Override
    public void deleteProveedor(Integer id_proveedor) {
        proveedoresRepository.deleteById(id_proveedor);
    }
}
