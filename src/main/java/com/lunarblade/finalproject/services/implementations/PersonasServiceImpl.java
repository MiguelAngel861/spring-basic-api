package com.lunarblade.finalproject.services.implementations;

// Importaciones Locales
import com.lunarblade.finalproject.entities.Personas;
import com.lunarblade.finalproject.repositories.PersonasRepository;
import com.lunarblade.finalproject.services.interfaces.PersonasService;

// Importaciones de Java y SpringBoot
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonasServiceImpl implements PersonasService {
    private final PersonasRepository personasRepository;

    public PersonasServiceImpl(PersonasRepository personasRepository) {
        this.personasRepository = personasRepository;
    }

    @Override
    public List<Personas> getAllPersonas() {
        return personasRepository.findAll();
    }

    @Override
    public Personas getPersonaByID(Integer idPersona) {
        return personasRepository.findById(idPersona).orElse(null);
    }

    @Override
    public Personas createPersona(Personas datosPersona) {
        return  personasRepository.save(datosPersona);
    }

    @Override
    public Personas updatePersona(Integer idPersona, Personas datosPersona) {
        Personas personaExistente = personasRepository.findById(idPersona).orElse(null);
        if (personaExistente != null) {
            personaExistente.setCedula(datosPersona.getCedula());
            personaExistente.setNombres(datosPersona.getNombres());
            personaExistente.setApellidos(datosPersona.getApellidos());
            personaExistente.setGenero(datosPersona.getGenero());
            personaExistente.setFechaNacimiento(datosPersona.getFechaNacimiento());

            personaExistente.setStatus(datosPersona.getStatus());
            personaExistente.setActualizadoPor(datosPersona.getActualizadoPor());
            personaExistente.setFechaActualizacion(datosPersona.getFechaActualizacion());

            return personasRepository.save(personaExistente);
        }

        return null;
    }

    @Override
    public void deletePersona(Integer idPersona) {
        personasRepository.deleteById(idPersona);
    }
}
