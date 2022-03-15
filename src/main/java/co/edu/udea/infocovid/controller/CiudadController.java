package co.edu.udea.infocovid.controller;

import co.edu.udea.infocovid.entity.Ciudad;
import co.edu.udea.infocovid.modelo.CiudadDTO;
import co.edu.udea.infocovid.service.CiudadService;
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
public class CiudadController {

    private final Logger log = LoggerFactory.getLogger(CiudadController.class);

    private CiudadService ciudadService;
    private final Messages messages;


    public CiudadController(CiudadService ciudadService,Messages messages) {

        this.ciudadService = ciudadService;
        this.messages = messages;
    }

    @PostMapping("crear")
    @ApiOperation(value = "Crear Ciudad",  response = Ciudad.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ciudad creada existosamente"),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<StandardResponse<CiudadDTO>>guardarCiudad(@Valid @RequestBody CiudadDTO ciudad){
        return ResponseEntity.ok(new StandardResponse<>(StandardResponse.StatusStandardResponse.OK, messages.get("ciudad.guardar.exito")));
    }

}
