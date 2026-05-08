package proyectoreto.paciente;

import proyectoreto.personal.PersonalDeSalud;
import java.time.LocalDate;

/**
 * Clase que representa el registro de una ronda médica diaria realizada a un
 * paciente.
 * * Durante estas rondas, el personal evalúa la evolución del paciente y ajusta
 * sus tratamientos
 * Según las reglas del sistema, solo puede existir una ronda médica por
 * paciente al día
 * y solo se puede realizar si el paciente tiene su último ingreso activo
 * * @author Grupo 2
 */
public class RondaMedicaDiaria {

    /**
     * El paciente al que se le realiza la ronda médica
     * Debe ser un paciente que actualmente resida en el hospital (con ingreso
     * activo).
     */
    private Paciente paciente;

    /**
     * El miembro del personal (generalmente Personal de Salud o Médico) que realiza
     * el seguimiento continuo y registra esta ronda
     */
    private PersonalDeSalud personal;

    /**
     * La fecha exacta en la que se realizó la ronda médica
     * Sirve para controlar que no se dupliquen rondas el mismo día para el mismo
     * paciente
     */
    private LocalDate fecha;

    /**
     * Indicador clave que marca si el paciente ha alcanzado el nivel adecuado de
     * recuperación
     * Si es 'true', el sistema sabrá que el paciente está listo para que un Médico
     * le realice la evaluación final para su posible alta
     */
    private boolean listoEvaluacionFinal;

    /**
     * Constructor con visibilidad de paquete (~) tal y como especifica el UML.
     * Solo puede ser instanciada desde dentro del paquete paciente.
     * 
     * @param paciente El paciente evaluado
     * @param personal El personal de salud que realiza la ronda
     * @param fecha    La fecha de la ronda
     */
    RondaMedicaDiaria(Paciente paciente, PersonalDeSalud personal, LocalDate fecha) {
        if (paciente == null || personal == null || fecha == null) {
            throw new IllegalArgumentException("Ninguno de los parámetros puede ser nulo");
        }
        this.paciente = paciente;
        this.personal = personal;
        this.fecha = fecha;
        this.listoEvaluacionFinal = false; // Por defecto no está listo para alta
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public PersonalDeSalud getPersonal() {
        return personal;
    }

    public void setPersonal(PersonalDeSalud personal) {
        this.personal = personal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isListoEvaluacionFinal() {
        return listoEvaluacionFinal;
    }

    public void setListoEvaluacionFinal(boolean listoEvaluacionFinal) {
        this.listoEvaluacionFinal = listoEvaluacionFinal;
    }

    /**
     * Devuelve una cadena con todos los datos de la ronda médica.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
                "RondaMedicaDiaria{paciente=%s, personal=%s, fecha=%s, listoEvaluacionFinal=%b}",
                paciente,
                personal,
                fecha,
                listoEvaluacionFinal);
    }
}
