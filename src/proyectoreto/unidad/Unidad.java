package proyectoreto.unidad;

import java.io.Serializable;

import java.util.ArrayList;

// TODO: Que Wilson Revise y corrija lo que hizo Jaime

/**
 * @author Jaime
 */
public class Unidad implements Serializable {

    private String nombreUnidad;
    private double porcentajeCamasDisponibles;
    private String especialidadMedica;
    private ArrayList<Habitacion> habitaciones;

    public Unidad(String nombreUnidad, double porcentajeCamasDisponibles, String especialidadMedica) {
        this.nombreUnidad = nombreUnidad;
        this.porcentajeCamasDisponibles = porcentajeCamasDisponibles;
        this.especialidadMedica = especialidadMedica;
        this.habitaciones = new ArrayList<>();
    }

    public String getNombreUnidad() {
        return nombreUnidad;
    }

    public void setNombreUnidad(String nombreUnidad) {
        this.nombreUnidad = nombreUnidad;
    }

    public double getPorcentajeCamasDisponibles() {
        return porcentajeCamasDisponibles;
    }

    public void setPorcentajeCamasDisponibles(double porcentajeCamasDisponibles) {
        this.porcentajeCamasDisponibles = porcentajeCamasDisponibles;
    }

    public String getEspecialidadMedica() {
        return especialidadMedica;
    }

    public void setEspecialidadMedica(String especialidadMedica) {
        this.especialidadMedica = especialidadMedica;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void agregarHabitacion(Habitacion h) {
        habitaciones.add(h);
    }

    @Override
    public String toString() {
        return "Unidad{" +
                "nombreUnidad='" + nombreUnidad + '\'' +
                ", porcentajeCamasDisponibles=" + porcentajeCamasDisponibles +
                ", especialidadMedica='" + especialidadMedica + '\'' +
                ", habitaciones=" + habitaciones +
                '}';
    }
}
