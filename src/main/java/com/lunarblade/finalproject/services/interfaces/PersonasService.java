package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Personas;
import java.util.List;

public interface PersonasService
{
    List<Personas> getAllPersonas();
    Personas getPersonaByID(Integer idPersona);
    Personas createPersona(Personas datosPersona);
    Personas updatePersona(Integer idPersona, Personas datosPersona);
    void deletePersona(Integer idPersona);
}
