package co.edu.udea.infocovid.service;


import co.edu.udea.infocovid.entity.Pais;
import co.edu.udea.infocovid.exception.BusinessException;
import co.edu.udea.infocovid.repository.PaisRepository;
import co.edu.udea.infocovid.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@Transactional
public class PaisService {

    private final PaisRepository paisRepository;
    private final Messages messages;

    public PaisService(PaisRepository paisRepository, Messages messages){
        this.paisRepository=paisRepository;
        this.messages=messages;
    }

    public Pais addPais(Pais pais){
        Optional<Pais> paisConsulta=paisRepository.findByNombre(pais.getNombre());
        if(paisConsulta.isPresent()){
            throw new BusinessException(messages.get("Pais.nombre.duplicado"));
        }
        return paisRepository.save(pais);
    }
}
