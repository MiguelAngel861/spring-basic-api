package com.lunarblade.finalproject.services.implementations;
// Importaciones Locales
import com.lunarblade.finalproject.entities.Modelos;
import com.lunarblade.finalproject.repositories.ModelosRepository;
import com.lunarblade.finalproject.services.interfaces.ModelosService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ModelosServiceImpl implements ModelosService {
    private final ModelosRepository modelosRepository;

    public ModelosServiceImpl(ModelosRepository modelosRepository) {
        this.modelosRepository = modelosRepository;
    }

    @Override
    public List<Modelos> getAllModelos() {
        return modelosRepository.findAll();
    }

    @Override
    public Modelos getModeloByID(Integer idModelo) {
        return modelosRepository.findById(idModelo).orElse(null);
    }

    @Override
    public Modelos createModelo(Modelos modelo) {
        return modelosRepository.save(modelo);
    }

    @Override
    public Modelos updateModelo(Integer idModelo, Modelos datosModelo) {
        Modelos modeloExistente = modelosRepository.findById(idModelo).orElse(null);
        if (modeloExistente != null) {
            modeloExistente.setIdMarca(datosModelo.getIdMarca());
            modeloExistente.setNombre(datosModelo.getNombre());

            modeloExistente.setStatus(datosModelo.getStatus());
            modeloExistente.setActualizadoPor(datosModelo.getActualizadoPor());
            modeloExistente.setFechaActualizacion(datosModelo.getFechaActualizacion());

            return modelosRepository.save(modeloExistente);
        }
        return null;
    }

    @Override
    public void deleteModelo(Integer idModelo) {
        modelosRepository.deleteById(idModelo);
    }
}
