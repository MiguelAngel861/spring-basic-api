package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Marcas;
import com.lunarblade.finalproject.repositories.MarcasRepository;
import com.lunarblade.finalproject.services.interfaces.MarcasService;

// Importaciones de Java y SpringBoot
import  java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MarcasServiceImpl implements MarcasService {
    private final MarcasRepository marcasRepository;
    public MarcasServiceImpl(MarcasRepository marcasRepository) {
        this.marcasRepository = marcasRepository;
    }

    @Override
    public List<Marcas> getAllMarcas() {
        return marcasRepository.findAll();
    }

    @Override
    public Marcas getMarcaByID(Integer idMarca) {
        return marcasRepository.findById(idMarca).orElse(null);
    }

    @Override
    public Marcas createMarca(Marcas datosMarca) {
        return marcasRepository.save(datosMarca);
    }

    @Override
    public Marcas updateMarca(Integer idMarca, Marcas datosMarca) {
        Marcas marcaExistente = marcasRepository.findById(idMarca).orElse(null);
        if (marcaExistente != null) {
            marcaExistente.setNombre(datosMarca.getNombre());

            marcaExistente.setStatus(datosMarca.getStatus());
            marcaExistente.setActualizadoPor(datosMarca.getActualizadoPor());
            marcaExistente.setFechaActualizacion(datosMarca.getFechaActualizacion());

            return marcasRepository.save(marcaExistente);
        }

        return null;
    }

    @Override
    public void deleteMarca(Integer idMarca) {
        marcasRepository.deleteById(idMarca);
    }
}
