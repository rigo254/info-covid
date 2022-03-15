package co.edu.udea.infocovid.controller;

import co.edu.udea.infocovid.entity.Estado;
import co.edu.udea.infocovid.modelo.EstadoDTO;
import co.edu.udea.infocovid.service.EstadoService;
import co.edu.udea.infocovid.util.Messages;
import co.edu.udea.infocovid.util.StandardResponse;
import com.github.davidrobbo.bounce.vertx.web.annotations.RequestMapping;
import com.github.davidrobbo.bounce.vertx.web.annotations.RestController;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@RestController
@RequestMapping("/infovid")
public class EstadoController {

    private final Logger log = LoggerFactory.getLogger(EstadoController.class);

    private EstadoService estadoService;
    private final Messages messages;

    public EstadoController(EstadoService estadoService, Messages messages) {

        this.estadoService = estadoService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear Estado",  response = Estado.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Estado creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<EstadoDTO>> guardarDepartamento(@Valid @RequestBody EstadoDTO departamento) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("estado.guardar.exito")));

    }
}
