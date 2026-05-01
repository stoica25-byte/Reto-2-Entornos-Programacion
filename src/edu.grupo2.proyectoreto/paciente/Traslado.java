// TODO: Que Wilson Revise y corrija lo que hizo Jaime
// TODO: Terminar la documentación de la clase, el constructor y los métodos
// TODO: Corregir Override de toString()

/**
 * Las instancias de está clase representan la información relacionada al traslado de un alta.
 * 
 * @author Jaime
 * @author Wilson
 */
public class Traslado {

    private String hospitalDestino;
    private String motivo;

    public Traslado(String hospitalDestino, String motivo) {

        this.hospitalDestino = hospitalDestino;
        this.motivo = motivo;
    }

    public String getHospitalDestino() {
        
        return hospitalDestino;
    }

    public void setHospitalDestino(String hospitalDestino) {

        this.hospitalDestino = hospitalDestino;
    }

    public String getMotivo() {

        return motivo;
    }

    public void setMotivo(String motivo) {

        this.motivo = motivo;
    }

    @Override
    public String toString() {
        
        return "Traslado{" +
                "hospitalDestino='" + hospitalDestino + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
