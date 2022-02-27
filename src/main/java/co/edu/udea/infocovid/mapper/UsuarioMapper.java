package co.edu.udea.infocovid.mapper;

import co.edu.udea.infocovid.config.EntityMapper;
import co.edu.udea.infocovid.entity.Usuario;
import co.edu.udea.infocovid.modelo.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CiudadMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
