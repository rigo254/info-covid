package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.SuscripcionPorCiudad;
import co.edu.udea.infocovid.modelo.SuscripcionPorCiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring", uses={SuscripcionMapper.class , CiudadMapper.class})
public interface SuscripcionPorCiudadMapper extends EntityMapper<SuscripcionPorCiudadDTO, SuscripcionPorCiudad> {
}
