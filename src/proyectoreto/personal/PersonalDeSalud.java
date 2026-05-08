package proyectoreto.personal;

import java.io.Serializable;

import proyectoreto.paciente.Paciente;

/**
 * Clase abstracta base para todo el personal de salud
 * Hereda de la clase general Personal
 * Es la base para Médicos y Enfermeros
 */
public abstract class PersonalDeSalud extends Personal  implements Serializable {
    // Visibilidad protected para que solo las clases hijas lo usen
    protected PersonalDeSalud(String nombre, String apellido) {
        super(nombre, apellido); // Llama al constructor de la clase padre (Personal)
    }

    /**
     * Método para que el personal de salud realice la ronda médica sobre un
     * paciente
     * Utiliza una cadena de llamadas en las que desde la clase PersonalDeSalud se
     * puede
     * acceder al método de rondasMedicas de la clase Ingreso
     * 
     * @param objetoPaciente El paciente al que se le registra la ronda
     */
    void registrarRonda(Paciente objetoPaciente) {
        // Delegamos en la clase Paciente (Aggregate Root) porque getExpediente() es
        // package-private
        if (objetoPaciente != null) {
            objetoPaciente.registrarRondaMedica();
        }
    }

    @Override
    public String toString() {
        return String.format("PersonalDeSalud{nombre='%s', apellido='%s'}", getNombre(), getApellido());
    }
}
