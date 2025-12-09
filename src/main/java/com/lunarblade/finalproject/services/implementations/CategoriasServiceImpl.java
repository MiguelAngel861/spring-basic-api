package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Categorias;
import com.lunarblade.finalproject.repositories.CategoriasRepository;
import com.lunarblade.finalproject.services.interfaces.CategoriasService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CategoriasServiceImpl implements CategoriasService {
    private final CategoriasRepository categoriasRepository;

    public CategoriasServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @Override
    public List<Categorias> getAllCategorias() {
        return categoriasRepository.findAll();
    }

    @Override
    public Categorias getCategoriaByID(Integer id_categoria) {
        return categoriasRepository.findById(id_categoria).orElse(null);
    }

    @Override
    public Categorias createCategoria(Categorias datosCategoria) {
        return categoriasRepository.save(datosCategoria);
    }

    @Override
    public Categorias updateCategoria(Integer id_categoria, Categorias datosCategoria) {
        Categorias categoriaExistente = categoriasRepository.findById(id_categoria).orElse(null);

        if (categoriaExistente != null) {
            categoriaExistente.setIdModelo(datosCategoria.getIdModelo());
            categoriaExistente.setNombre(datosCategoria.getNombre());

            categoriaExistente.setStatus(datosCategoria.getStatus());
            categoriaExistente.setActualizadoPor(datosCategoria.getActualizadoPor());
            categoriaExistente.setFechaActualizacion(datosCategoria.getFechaActualizacion());

            return categoriasRepository.save(categoriaExistente);
        }

        return null;
    }

    @Override
    public void deleteCategoria(Integer id_categoria) {
        categoriasRepository.deleteById(id_categoria);
    }
}
