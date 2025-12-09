package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.ContactoPersonas;
import com.lunarblade.finalproject.repositories.ContactoPersonasRepository;
import com.lunarblade.finalproject.services.interfaces.ContactoPersonasService;

// Impoertaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactoPersonasServiceImpl implements ContactoPersonasService {
    private final ContactoPersonasRepository contactoPersonasRepository;

    public ContactoPersonasServiceImpl(ContactoPersonasRepository contactoPersonasRepository) {
        this.contactoPersonasRepository = contactoPersonasRepository;
    }

    @Override
    public List<ContactoPersonas> getAllContactosPersonas() {
        return contactoPersonasRepository.findAll();
    }

    @Override
    public ContactoPersonas getContactoPersonaByID(Integer id_contacto_persona) {
        return contactoPersonasRepository.findById(id_contacto_persona).orElse(null);
    }

    @Override
    public ContactoPersonas createContactoPersona(ContactoPersonas datosContactoPersona) {
        return contactoPersonasRepository.save(datosContactoPersona);
    }

    @Override
    public ContactoPersonas updateContactoPersona(Integer id_contacto_persona, ContactoPersonas datosContactoPersona) {
        ContactoPersonas contactoPersonaExistente = contactoPersonasRepository.findById(id_contacto_persona).orElse(null);

        if (contactoPersonaExistente != null) {
            contactoPersonaExistente.setIdPersona(datosContactoPersona.getIdPersona());
            contactoPersonaExistente.setIdContacto(datosContactoPersona.getIdContacto());
            contactoPersonaExistente.setFormaContacto(datosContactoPersona.getFormaContacto());

            contactoPersonaExistente.setStatus(datosContactoPersona.getStatus());
            contactoPersonaExistente.setActualizadoPor(datosContactoPersona.getActualizadoPor());
            contactoPersonaExistente.setFechaActualizacion(datosContactoPersona.getFechaActualizacion());

            return contactoPersonasRepository.save(contactoPersonaExistente);
        }

        return null;
    }

    @Override
    public void deleteContactoPersona(Integer id_contacto_persona) {
        contactoPersonasRepository.deleteById(id_contacto_persona);
    }
}
