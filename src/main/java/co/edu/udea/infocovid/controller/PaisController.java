package co.edu.udea.infocovid.controller;


import co.edu.udea.infocovid.entity.Pais;
import co.edu.udea.infocovid.modelo.PaisDTO;
import co.edu.udea.infocovid.service.PaisService;
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
public class PaisController {
    private final Logger log = LoggerFactory.getLogger(CiudadController.class);

    private PaisService paisService;
    private final Messages messages;

    public PaisController(PaisService paisService, Messages messages) {

        this.paisService = paisService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear Pais", response = Pais.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pais creado existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<PaisDTO>> guardarPais(@Valid @RequestBody PaisDTO pais) {
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("pais.guardar.exito")));

    }
}