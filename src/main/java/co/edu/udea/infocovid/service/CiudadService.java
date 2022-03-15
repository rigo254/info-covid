package co.edu.udea.infocovid.service;

import co.edu.udea.infocovid.entity.Ciudad;
import co.edu.udea.infocovid.exception.BusinessException;
import co.edu.udea.infocovid.repository.CiudadRepository;
import co.edu.udea.infocovid.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CiudadService {

    private final CiudadRepository ciudadRepository;
    private final Messages messages;

    public CiudadService(CiudadRepository ciudadRepository, Messages messages){
        this.ciudadRepository=ciudadRepository;
        this.messages=messages;
    }

    public Ciudad addCiudad(Ciudad ciudad){
        Optional<Ciudad> ciudadConsulta=ciudadRepository.findByNombre(ciudad.getNombre());
        if(ciudadConsulta.isPresent()){
            throw new BusinessException(messages.get("ciudad.nombre.duplicado"));
        }
        return ciudadRepository.save(ciudad);
    }
}
