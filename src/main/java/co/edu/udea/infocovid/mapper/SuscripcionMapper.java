package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.Suscripcion;
import co.edu.udea.infocovid.modelo.SuscripcionDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={UsuarioMapper.class})
public interface SuscripcionMapper extends EntityMapper <SuscripcionDTO, Suscripcion>{
}
