package uam.mx.sensor_service.entities;

public class SensorData {
    private float humedad;
    private float temperatura;
    private float calidadAire;
    private String barrio;
    
    public SensorData(float humedad, float temperatura, float calidadAire, String barrio) {
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.calidadAire = calidadAire;
        this.barrio = barrio;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public float getCalidadAire() {
        return calidadAire;
    }

    public void setCalidadAire(float calidadAire) {
        this.calidadAire = calidadAire;
    }
    
    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }


    @Override
    public String toString() {
        String humedadStr = String.format("%.2f",humedad);
        String temperaturaStr = String.format("%.2f",temperatura);
        String calidadStr = String.format("%.2f",calidadAire);
        return "SensorData [humedad=" + humedadStr + 
        ", temperatura=" + temperaturaStr + 
        ", calidadAire=" + calidadStr + ", barrio= "+ barrio + "]";
    }
    
}
