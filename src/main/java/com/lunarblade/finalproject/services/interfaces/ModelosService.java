package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Modelos;
import java.util.List;

public interface ModelosService
{
    List<Modelos> getAllModelos();
    Modelos getModeloByID(Integer idModelo);
    Modelos createModelo(Modelos datosModelo);
    Modelos updateModelo(Integer idModelo, Modelos datosModelo);
    void deleteModelo(Integer idModelo);
}
