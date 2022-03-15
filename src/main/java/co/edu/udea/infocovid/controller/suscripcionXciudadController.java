package co.edu.udea.infocovid.controller;

import co.edu.udea.infocovid.entity.Ciudad;
import co.edu.udea.infocovid.modelo.SuscripcionPorCiudadDTO;
import co.edu.udea.infocovid.service.SuscripcionXciudadService;
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
public class suscripcionXciudadController {

    private final Logger log = LoggerFactory.getLogger(suscripcionXciudadController.class);

    private SuscripcionXciudadService suscripcionXciudadService;
    private final Messages messages;

    public suscripcionXciudadController(SuscripcionXciudadService suscripcionXciudadService, Messages messages) {
        this.suscripcionXciudadService = suscripcionXciudadService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear suscripcion por ciudad",  response = Ciudad.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suscripcion por ciudad creada existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionPorCiudadDTO>> guardarSuscripcion(@Valid @RequestBody SuscripcionPorCiudadDTO suscripcion) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.guardar.exito")));
    }
}
