package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.Contactos;
import java.util.List;

public interface ContactosService
{
    List<Contactos> getAllContactos();
    Contactos getContactoByID(Integer idContacto);
    Contactos createContacto(Contactos contacto);
    Contactos updateContacto(Integer idContacto, Contactos datosContacto);
    void deleteContacto(Integer idContacto);
}
