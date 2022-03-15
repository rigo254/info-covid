package co.edu.udea.infocovid.service;

import co.edu.udea.infocovid.entity.Suscripcion;
import co.edu.udea.infocovid.exception.BusinessException;
import co.edu.udea.infocovid.repository.SuscripcionRepository;
import co.edu.udea.infocovid.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;
    private final Messages messages;

    public SuscripcionService(SuscripcionRepository suscripcionRepository, Messages messages) {
        this.suscripcionRepository = suscripcionRepository;
        this.messages = messages;
    }

    public Suscripcion guardarSuscripcion(Suscripcion suscripcion){
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion actualizarSuscripcion(Suscripcion suscripcion){
        if(Objects.isNull(suscripcion.getId())){
            throw new BusinessException(messages.get("suscripcion.id.vacio"));
        }
        consultarPorId(suscripcion.getId());
        return suscripcionRepository.save(suscripcion);
    }
    public Suscripcion consultarPorId(Long id){
        return suscripcionRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("suscripcion.id.no_encontrada")));
    }

    public void eliminarSuscripcion(Long id){
        consultarPorId(id);
        suscripcionRepository.deleteById(id);
    }
}
