package proyectoreto.unidad;

import proyectoreto.paciente.Paciente;

/**
 * Clase que representa una Cama en el sistema hospitalario.
 */
public class Cama {
    private boolean disponibilidad;
    private Paciente pacienteAsignado;

    public Cama() {
        // Inicializamos los valores por defecto.
        // Una cama recién creada debería estar disponible y sin paciente.
        this.disponibilidad = true;
        this.pacienteAsignado = null;
    }

    /**
     * getter de la disponibilidad de la cama.
     * 
     * @return true si la cama esta disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponibilidad;
    }

    /**
     * setter de la disponibilidad de la cama.
     * 
     * @param disponible nuevo estado de disponibilidad.
     */
    public void setDisponibilidad(boolean disponible) {
        this.disponibilidad = disponible;
    }

    /**
     * getter del paciente asignado a la cama.
     * 
     * @return paciente asignado a la cama.
     */
    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    @Override
    public String toString() {
        return String.format("Cama{disponibilidad=%s, pacienteAsignado=%s}", disponibilidad, pacienteAsignado);
    }

}
