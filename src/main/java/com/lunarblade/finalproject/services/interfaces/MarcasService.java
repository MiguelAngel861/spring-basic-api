package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Marcas;
import java.util.List;

public interface MarcasService
{
    List<Marcas> getAllMarcas();
    Marcas getMarcaByID(Integer idMarca);
    Marcas createMarca(Marcas datosMarca);
    Marcas updateMarca(Integer idMarca, Marcas datosMarca);
    void deleteMarca(Integer idMarca);
}
