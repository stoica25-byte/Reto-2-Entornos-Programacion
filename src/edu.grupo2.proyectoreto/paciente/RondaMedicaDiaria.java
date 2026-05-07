package edu.grupo2.proyectoreto.paciente;
/**
 * Clase que representa el registro de una ronda médica diaria realizada a un paciente.
 * * Durante estas rondas, el personal evalúa la evolución del paciente y ajusta sus tratamientos
 * Según las reglas del sistema, solo puede existir una ronda médica por paciente al día 
 * y solo se puede realizar si el paciente tiene su último ingreso activo
 * * @author Grupo 2
 */
public class RondaMedicaDiaria {

    /**
     * El paciente al que se le realiza la ronda médica
     * Debe ser un paciente que actualmente resida en el hospital (con ingreso activo).
     */
    private Paciente paciente;

    /**
     * El miembro del personal (generalmente Personal de Salud o Médico) que realiza 
     * el seguimiento continuo y registra esta ronda
     */
    private Personal personal;

    /**
     * La fecha exacta en la que se realizó la ronda médica
     * Sirve para controlar que no se dupliquen rondas el mismo día para el mismo paciente
     */
    private Fecha fecha;

    /**
     * Indicador clave que marca si el paciente ha alcanzado el nivel adecuado de recuperación
     * Si es 'true', el sistema sabrá que el paciente está listo para que un Médico 
     * le realice la evaluación final para su posible alta
     */
    private boolean listoEvaluacionFinal;

    // TODO: Fase 2 - Implementar el constructor. 
    // Nota para el equipo: El diagrama UML indica que el constructor debe tener  
    // visibilidad de paquete (indicado con el símbolo ~ : ~ RondaMedicaDiaria() ).
    // También faltarían los getters y setters si al final se decide que son necesarios

}