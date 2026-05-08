package proyectoreto.personal;

import proyectoreto.paciente.Paciente;
import proyectoreto.unidad.Unidad;

/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud y gestiona la evaluación final
 * del paciente
 *
 * @author Diana
 */
public class Medico extends PersonalDeSalud implements GestionUbicacion {
    /**
     * Constructor público por defecto (+)
     * Llama al constructor de la superclase PersonalDeSalud para inicializar
     * los atributos heredados (nombre y apellidos)
     *
     * @param nombre   nombre del médico
     * @param apellido apellido del médico
     */
    public Medico(String nombre, String apellido) {
        // Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super(nombre, apellido);
    }

    /**
     * Devuelve una cadena con los datos del médico
     *
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{ campo1='valor1', campo2='valor2'}
     *
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
                "Medico{nombre='%s', apellido='%s'}",
                getNombre(),
                getApellido());
    }

    @Override
    public void trasladarPaciente(Paciente paciente, Unidad unidadDestino) {
        // TODO: Implementar por Wilson (Mover paciente a nueva unidad)
    }

    @Override
    public void trasladarPaciente(Paciente paciente, String hospitalDestino, String motivoTraslado) {
        // TODO: Implementar por Wilson (Trasladar paciente a otro hospital generando
        // alta por traslado)
    }
}
