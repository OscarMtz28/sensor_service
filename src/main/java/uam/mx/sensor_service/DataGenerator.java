package uam.mx.sensor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import uam.mx.sensor_service.entities.SensorData;

public class DataGenerator {
    
    private List<SensorData> list = new ArrayList<>(); 
    public void add (SensorData value){
        this.list.add(value);
    }

    public SensorData modify (int index, SensorData value){
        return this.list.set(index, value);
    }

    /**
     * Modificar en la lista el objeto con el nuevo valor
     * @param index Indice en la posicion de la lista
     * @param value El objeto con los valores nuevos
     * @return Referencia al valor modificado
     */

     public SensorData getById(int index){
        return this.list.get(index);
     }

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
