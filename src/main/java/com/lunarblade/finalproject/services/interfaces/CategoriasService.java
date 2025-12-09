package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Categorias;
import java.util.List;

public interface CategoriasService
{
    List<Categorias> getAllCategorias();
    Categorias getCategoriaByID(Integer idCategoria);
    Categorias createCategoria(Categorias categoria);
    Categorias updateCategoria(Integer idCategoria, Categorias datosCategoria);
    void deleteCategoria(Integer idCategoria);
}
