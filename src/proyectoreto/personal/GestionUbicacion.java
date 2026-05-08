package proyectoreto.personal;

import proyectoreto.paciente.Paciente;
import proyectoreto.unidad.Unidad;

/**
 * Interfaz que define las operaciones de gestión de ubicaciones y traslados de
 * pacientes.
 * 
 * Será implementada por Medico y PersonalAdministrativo.
 */
public interface GestionUbicacion {

    /**
     * Traslada a un paciente a una nueva unidad dentro del mismo hospital.
     * 
     * @param paciente      El paciente a trasladar.
     * @param unidadDestino La unidad a la que será trasladado.
     */
    void trasladarPaciente(Paciente paciente, Unidad unidadDestino);

    /**
     * Traslada a un paciente a otro hospital, generando un alta por traslado.
     * 
     * @param paciente        El paciente a trasladar.
     * @param hospitalDestino El nombre del hospital de destino.
     * @param motivoTraslado  El motivo del traslado.
     */
    void trasladarPaciente(Paciente paciente, String hospitalDestino, String motivoTraslado);
}