package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.Estado;
import co.edu.udea.infocovid.modelo.EstadoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PaisMapper.class})
public interface EstadoMapper extends EntityMapper<EstadoDTO, Estado> {
}
