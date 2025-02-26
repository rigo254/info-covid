package co.edu.udea.infocovid.service;

import co.edu.udea.infocovid.entity.SuscripcionPorCiudad;
import co.edu.udea.infocovid.exception.BusinessException;
import co.edu.udea.infocovid.repository.SuscripcionPorCiudadRepository;
import co.edu.udea.infocovid.util.Messages;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class SuscripcionXciudadService {

    private final SuscripcionPorCiudadRepository suscripcionPorCiudadRepository;
    private final Messages messages;

    public SuscripcionXciudadService(SuscripcionPorCiudadRepository suscripcionPorCiudadRepository, Messages messages){
        this.suscripcionPorCiudadRepository=suscripcionPorCiudadRepository;
        this.messages=messages;
    }

    public SuscripcionPorCiudad guardarSuscripcion(SuscripcionPorCiudad suscripcionPorCiudad) {
        return suscripcionPorCiudadRepository.save(suscripcionPorCiudad);
    }

    public SuscripcionPorCiudad actualizarSuscripcionPorCiudad(SuscripcionPorCiudad suscripcionPorCiudad) {
        if (Objects.isNull(suscripcionPorCiudad.getId())) {
            throw new BusinessException(messages.get("suscripcion.id.vacio"));
        }
        consultarPorId(suscripcionPorCiudad.getId());
        return suscripcionPorCiudadRepository.save(suscripcionPorCiudad);
    }

    public SuscripcionPorCiudad consultarPorId(Long id) {
        return suscripcionPorCiudadRepository.findById(id).orElseThrow(
                () -> new BusinessException(messages.get("estado.id.no_encontrado")));
    }

    public void eliminarSuscripcion(Long id, Long idCiudad) {
        suscripcionPorCiudadRepository.deleteByFkCiudadAndFkSuscripcion(idCiudad, id);
    }

    public List<SuscripcionPorCiudad> buscarPorCodigoUsuario(Long idUsuario) {
        return suscripcionPorCiudadRepository.buscarPorCodigoUsuario(idUsuario);
    }

    public void deleteByFkSuscripcion(Long fkSuscripcion) {
        suscripcionPorCiudadRepository.deleteByFkSuscripcion(fkSuscripcion);
    }

    public List<SuscripcionPorCiudad> findByFkSuscripcion(Long subscriptionId) {
        return suscripcionPorCiudadRepository.findByFkSuscripcion(subscriptionId);
    }
}
