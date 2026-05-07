package edu.grupo2.proyectoreto.unidad;

import java.io.Serializable;

import edu.grupo2.proyectoreto.paciente.Paciente;

/**
 * Representa una Cama en el sistema hospitalario.
 * 
 * Las camas es un elemento que usan las unidades para organizar su espacio para los pacientes.
 * 
 * @author Diana
 * @author Wilson
 */
public final class Cama implements Serializable{
    /**
     * Marca si la cama esta disponible o no, es decir, si la cama está o no ocupada por un paciente.
     * 
     * true marca que si esta disponible.
     * false marca que no esta disponible.
     */
    private boolean disponibilidad;

    /**
     * Paciente asignado a la cama.
     */
    private Paciente pacienteAsignado;

    /**
     * Crea una nueva cama.
     * 
     * Una cama recién creada debería estar disponible y sin paciente.
     */
    Cama(){
        this.disponibilidad = true;
        this.pacienteAsignado = null;
    }

    /**
     * Devuelve true si la cama esta disponible, false si no lo está.
     * 
     * @return true si la cama esta disponible, false si no lo está.
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    /**
     * Establece un paciente para la cama.
     * 
     * @param pacienteAsignado paciente para asigar a la cama
     */
    public void setPacienteAsignado(Paciente pacienteAsignado) {
        this.pacienteAsignado = pacienteAsignado;
    }

    /**
     * Devuelve el paciente asignado en la cama.
     * 
     * @return el paciente asignado en la cama
     */
    public Paciente getPacienteAsignado() {
        return pacienteAsignado;
    }

    /**
     * Devuelve una cadena con todos los datos de la cama.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
            "Cama{disponibilidad=%b, pacienteAsignado=%s}",
            disponibilidad,
            pacienteAsignado
        );
    }
}
