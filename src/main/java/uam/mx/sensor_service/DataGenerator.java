package uam.mx.sensor_service;

import java.util.Random;

import uam.mx.sensor_service.entities.SensorData;

public class DataGenerator {
    
    public SensorData generate(String barrio){
        Random ran_temperatura = new Random();
        Random ran_humedad = new Random();
        Random ran_calidadAire = new Random();
        
        float temperatura = ran_temperatura.nextFloat() * 50;
        float humedad = ran_humedad.nextFloat() * 100 ;
        float calidadAire = ran_calidadAire.nextFloat() * 100; 

        SensorData data = new SensorData(humedad, temperatura, calidadAire, barrio);

        return data;
    }

    /*public static void main(String[] args) {
        DataGenerator gen = new DataGenerator();
        SensorData data = gen.generate();
        System.out.println(data);
    }*/

}
