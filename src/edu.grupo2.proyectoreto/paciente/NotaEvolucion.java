// TODO: Que Wilson Revise y corrija lo que hizo Jaime
// TODO: Terminar la documentación de la clase, el constructor y los métodos
// TODO: Corregir Override de toString()

import java.time.LocalDate;

/**
 * Las instancias de está clase representan la información referente a las notas de evolucion del
 * de un paciente.
 * 
 * @author Jaime
 * @author Wilson
 */
public class NotaEvolucion {

    private LocalDate fecha;
    private String observacion;

    public NotaEvolucion(LocalDate fecha, String observacion) {

        this.fecha = fecha;
        this.observacion = observacion;
    }

    public LocalDate getFecha() {

        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {

        return observacion;
    }

    public void setObservacion(String observacion) {
        
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "NotaEvolucion{" +
                "fecha='" + fecha + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
