package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Contactos;
import com.lunarblade.finalproject.repositories.ContactosRepository;
import com.lunarblade.finalproject.services.interfaces.ContactosService;

//Impoertaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ContactosServiceImpl implements ContactosService {
    private final ContactosRepository contactosRepository;

    public ContactosServiceImpl(ContactosRepository contactosRepository) {
        this.contactosRepository = contactosRepository;
    }

    @Override
    public List<Contactos> getAllContactos() {
        return contactosRepository.findAll();
    }

    @Override
    public Contactos getContactoByID(Integer id_contacto) {
        return contactosRepository.findById(id_contacto).orElse(null);
    }

    @Override
    public Contactos createContacto(Contactos contacto) {
        return contactosRepository.save(contacto);
    }

    @Override
    public Contactos updateContacto(Integer id_contacto, Contactos contactoDetails) {
        Contactos contactoExistente = contactosRepository.findById(id_contacto).orElse(null);
        if (contactoExistente != null) {
            contactoExistente.setTipo(contactoDetails.getTipo());
            contactoExistente.setNombre(contactoDetails.getNombre());

            contactoExistente.setStatus(contactoDetails.getStatus());
            contactoExistente.setActualizadoPor(contactoDetails.getActualizadoPor());
            contactoExistente.setFechaActualizacion(contactoDetails.getFechaActualizacion());

            return contactosRepository.save(contactoExistente);
        }
        return null;
    }

    @Override
    public void deleteContacto(Integer id_contacto) {
        contactosRepository.deleteById(id_contacto);
    }
}
