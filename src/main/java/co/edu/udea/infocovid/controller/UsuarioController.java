package co.edu.udea.infocovid.controller;

import co.edu.udea.infocovid.modelo.UsuarioDTO;
import co.edu.udea.infocovid.service.UsuarioService;
import co.edu.udea.infocovid.util.Messages;
import co.edu.udea.infocovid.util.StandardResponse;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public class UsuarioController {
    private final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    private UsuarioService usuarioService;
    private final Messages messages;

    public UsuarioController(UsuarioService usuarioService, Messages messages) {

        this.usuarioService = usuarioService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Permite crear un usuario", response = UsuarioDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Se guardó el usuario exitosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<UsuarioDTO>> guardarUsuario(@Valid @RequestBody UsuarioDTO user) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("usuario.guardar.exito")));
    }
}
