package com.lunarblade.finalproject.services.interfaces;

import com.lunarblade.finalproject.entities.ContactoPersonas;
import java.util.List;

public interface ContactoPersonasService
{
    List<ContactoPersonas> getAllContactosPersonas();
    ContactoPersonas getContactoPersonaByID(Integer idContactoPersona);
    ContactoPersonas createContactoPersona(ContactoPersonas contactoPersonas);
    ContactoPersonas updateContactoPersona(Integer idContactoPersona, ContactoPersonas datosContactoPersonas);
    void deleteContactoPersona(Integer idContactoPersona);
}
