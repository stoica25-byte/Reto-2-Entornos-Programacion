package edu.grupo2.proyectoreto.paciente;

import edu.grupo2.proyectoreto.utilidad.Fecha;

/**
 * Clase que representa el alta médica de un paciente correspondiente a un ingreso específico.
 * * El alta marca el final de la estancia de un paciente en el hospital bajo un ingreso determinado.
 * Contiene la información administrativa y temporal de este evento, y puede darse por 
 * diferentes motivos, principalmente por recuperación o por traslado.
 * * @author Grupo 2
 */
public class Alta{
    /**
     * Indica el motivo o tipo de alta del paciente.
     */
    private String tipoAlta;

    /**
     * Contiene la información detallada del traslado a otro centro médico.
     * Este objeto solo contendrá información si el alta es de tipo "Traslado". 
     * En caso de alta por recuperación, este atributo no se utilizará o será nulo.
     */
    private Traslado traslado;

    /**
     * La fecha en la que se ha establecido que el paciente sea dado de alta.
     * Es establecida por el Médico tras una evaluación final exitosa.
     */
    private Fecha fechaAlta;

    /**
     * Almacena los detalles administrativos, notas formales y el papeleo correspondiente al alta.
     * Esta documentación es gestionada y rellenada por el Personal Administrativo 
     */
    private String documentacion;
}