package co.edu.udea.infocovid.controller;

import co.edu.udea.infocovid.entity.Suscripcion;
import co.edu.udea.infocovid.modelo.SuscripcionDTO;
import co.edu.udea.infocovid.service.SuscripcionService;
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
public class SuscripcionController {
    private final Logger log = LoggerFactory.getLogger(SuscripcionController.class);

    private SuscripcionService suscripcionService;
    private final Messages messages;

    public SuscripcionController(SuscripcionService suscripcionService, Messages messages) {
        this.suscripcionService = suscripcionService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear suscripcion",  response = Suscripcion.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Suscripcion creada existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<SuscripcionDTO>> guardarSuscripcion(@Valid @RequestBody SuscripcionDTO suscripcion){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("suscripcion.guardar.exito")));
    }
}
