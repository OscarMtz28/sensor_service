package uam.mx.sensor_service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/add")
    public void setValue(@RequestBody SensorData value){
        DataGenerator gen = new DataGenerator();
        gen.add(value);
    }

    @PostMapping("/modify/{index}")
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