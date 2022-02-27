package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.Ciudad;
import co.edu.udea.infocovid.modelo.CiudadDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {EstadoMapper.class})
public interface CiudadMapper extends EntityMapper<CiudadDTO, Ciudad> {
}
