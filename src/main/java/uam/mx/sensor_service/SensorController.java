package uam.mx.sensor_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import uam.mx.sensor_service.entities.SensorData;

@RestController
@RequestMapping("/sensor") // Formacion de la URL
@Tag(name= "Sensor service", description="Simula una estacion de monitoreo de parametros climatologicos.")

public class SensorController{

    @Value ("${BARRIO}")
    private String barrio;

    @Value ("${COLLECTOR_URL}")
    private String url;
    
    @GetMapping("/welcome")
    public SensorData getGreeting(){
        DataGenerator gen = new DataGenerator();
        SensorData data = gen.generate(barrio);
        return data;
    }
    @Operation(summary = "Agregar un valor de un sensor externo a nuestro servicio de sensor")
    @PostMapping("/add")
    public void setValue(@RequestBody SensorData value){
        DataGenerator gen = new DataGenerator();
        gen.add(value);
    }

    @Operation(summary="Metodos que nodifican el indice de un sensor")
    @Parameter(name="Index", description = "Indice de la lectura a modificar")
    @PostMapping("/modify/{index}")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Ejecicion exitosa",content =  {@Content(schema = @Schema(implementation = SensorData.class), mediaType = "aplication/json")}),
        @ApiResponse(responseCode = "404", description = "No se encontro el indice",content = {@Content(schema = @Schema())}),
        @ApiResponse(responseCode = "500", description = "Error en el servidor", content = {@Content(schema = @Schema())})
    })

    public void modify (@PathVariable ("index") int index, @RequestBody SensorData data){
        DataGenerator gen = new DataGenerator();
        SensorData data_org = gen.modify(index, data);
        data_org = data;
    }

    @GetMapping("/search/{index}")
    public SensorData search (@PathVariable ("index") int index){
        DataGenerator gen = new DataGenerator();
        return gen.getById(index);
    }

}