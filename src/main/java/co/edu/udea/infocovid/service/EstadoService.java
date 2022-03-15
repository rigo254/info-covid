package co.edu.udea.infocovid.service;


import co.edu.udea.infocovid.entity.Estado;
import co.edu.udea.infocovid.exception.BusinessException;
import co.edu.udea.infocovid.repository.EstadoRepository;
import co.edu.udea.infocovid.util.Messages;

import java.util.Optional;

public class EstadoService {

    private final EstadoRepository estadoRepository;
    private final Messages messages;

    public EstadoService(EstadoRepository estadoRepository, Messages messages){
        this.estadoRepository=estadoRepository;
        this.messages=messages;
    }

    public Estado addEstado(Estado estado){
        Optional<Estado> estadoConsulta=estadoRepository.findByNombre(estado.getNombre());
        if(estadoConsulta.isPresent()){
            throw new BusinessException(messages.get("Estado.nombre.duplicado"));
        }
        return estadoRepository.save(estado);
    }
}
