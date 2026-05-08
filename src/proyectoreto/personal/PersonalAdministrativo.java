package proyectoreto.personal;

import proyectoreto.paciente.Paciente;
import proyectoreto.unidad.Unidad;

/**
 * Clase que representa al personal administrativo del hospital.
 * Hereda de la clase base Personal y se encarga de las gestiones
 * burocráticas, asignación de ubicaciones y documentación de altas.
 *
 * @author Alex
 * @version 1.0 (28/04/2026)
 */
public class PersonalAdministrativo extends Personal implements GestionUbicacion {

    /**
     * Constructor público por defecto (+).
     * Invoca al constructor de la superclase Personal para inicializar
     * los atributos heredados (nombre y apellidos).
     * 
     * @param nombre   nombre del empleado
     * @param apellido apellido del empleado
     */
    public PersonalAdministrativo(String nombre, String apellido) {
        super(nombre, apellido);
    }

    /**
     * Realiza la gestión documental del alta de un paciente.
     * 
     * @param paciente      El paciente cuyo alta se va a documentar.
     * @param documentacion Texto con la información administrativa del alta.
     * 
     * @throws IllegalArgumentException si el paciente o la documentación no son
     *                                  válidos.
     */
    public void documentarAltaPaciente(Paciente paciente, String documentacion) {
        if (paciente == null) {
            throw new IllegalArgumentException("Se requiere un paciente válido para realizar la documentación.");
        }
        if (documentacion == null || documentacion.isBlank()) {
            throw new IllegalArgumentException("La documentación no puede estar vacía.");
        }

        // Delegamos la acción a la clase Paciente (que es la única con acceso a Alta)
        paciente.documentarAlta(documentacion);
    }

    @Override
    public String toString() {
        return String.format("PersonalAdministrativo{nombre='%s', apellido='%s'}", getNombre(), getApellido());
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
