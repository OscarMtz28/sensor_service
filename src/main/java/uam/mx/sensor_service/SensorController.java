package uam.mx.sensor_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uam.mx.sensor_service.entities.SensorData;

@RestController
@RequestMapping("/sensor") // Formacion de la URL

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
}