package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.Pais;
import co.edu.udea.infocovid.modelo.PaisDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaisMapper extends EntityMapper<PaisDTO, Pais> {
}
