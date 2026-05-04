package edu.grupo2.proyectoreto.paciente;

import edu.grupo2.proyectoreto.personal.PersonalAdministrativo;
import edu.grupo2.proyectoreto.utilidad.Fecha;
import edu.grupo2.proyectoreto.personal.Medico;

/**
 * Representa el alta médica de un paciente correspondiente a un ingreso
 * específico.
 * *
 * <p>
 * El alta marca el final de la estancia de un paciente en el hospital bajo un
 * ingreso determinado.
 * Contiene la información administrativa y temporal de este evento, y puede
 * darse por
 * diferentes motivos, principalmente por recuperación o por traslado.
 * </p>
 * * @author Alex
 * 
 * @version 1.1 (28/04/2026)
 *  
 */
public class Alta {

    /**
     * Indica el motivo o tipo de alta del paciente (ej. "Recuperación",
     * "Traslado").
     */
    private String tipoAlta;

    /**
     * Contiene la información detallada del traslado a otro centro médico.
     * *
     * <p>
     * Este objeto solo contendrá información si el atributo {@code tipoAlta} es
     * "Traslado".
     * En caso de alta por recuperación, este atributo permanecerá nulo.
     * </p>
     */
    private Traslado traslado;

    /**
     * La fecha en la que se ha establecido que el paciente sea dado de alta.
     * *
     * <p>
     * Es establecida por el personal médico tras una evaluación final exitosa.
     * </p>
     */
    private Fecha fechaAlta;

    /**
     * Almacena los detalles administrativos, notas formales y el papeleo
     * correspondiente al alta.
     * *
     * <p>
     * Esta documentación es gestionada y rellenada por el Personal Administrativo.
     * </p>
     */
    private String documentacion;

   /**
     * <p>
     * Crea una nueva instancia de Alta vacía.
     * La información se irá rellenando posteriormente a través de los métodos
     * de los diferentes actores (Médico y Personal Administrativo).
     * </p>
     */
    public Alta() {
        this.tipoAlta = "";
        this.documentacion = "";
        this.traslado = null;
        this.fechaAlta = null;
    }

    /**
     * <p>
     * Actualiza la fecha de alta tras una evaluación final exitosa, sirve como
     * setter.
     * Solo un Médico puede realizar esta acción.
     * El tipo de alta se marcará automáticamente como "Recuperación".
     * </p>
     * 
     * @param medico
     * @param fechaAlta
     * @throws IllegalArgumentException si no hay un medico valido
     * @throws IllegalArgumentException si no hay una fecha valida
     */
    public void actualizarFechaAlta(Medico medico, Fecha fechaAlta) {
        if (medico == null) {
            throw new IllegalArgumentException("Se requiere de un medico valido para autorizar y validar la fecha");
        }
        if (fechaAlta == null) {
            throw new IllegalArgumentException("La fecha no puede ser nula");
        }
        this.fechaAlta = fechaAlta;
        this.tipoAlta = "Recuperación";

    }

    /**
     * <p>
     * crea la documentacion para el alta de un paciente sirve como setter, es
     * necesario un personal,
     * administrativo valido ,que la fecha de alta no sea nula y tampoco la
     * documentacion
     * </p>
     * 
     * @param personal
     * @param documentacion
     */
    public void documentacionAltaPaciente(PersonalAdministrativo personal, String documentacion) {
        if (personal == null) {
            throw new IllegalArgumentException(
                    "Solo el Personal Administrativo puede gestionar la documentación del alta.");
        }

        if (this.fechaAlta == null && this.traslado == null) {
            throw new IllegalStateException(
                    "Error: No se puede documentar un alta que no ha sido evaluada por un médico o que no es un traslado.");
        }

        this.documentacion = documentacion;
    }

    // Getters//
    public String getTipoAlta() {
        return this.tipoAlta;
    }

    public Traslado getTraslado() {
        return this.traslado;
    }

    public Fecha getFechaAlta() {
        return this.fechaAlta;
    }

    public String getDocumentacion() {
        return this.documentacion;
    }

    // Setters//

    public void setTraslado(Traslado nuevoTraslado) {
        if (nuevoTraslado == null) {
            throw new IllegalArgumentException("El traslado no puede ser nulo");
        }

        this.traslado = nuevoTraslado;
        this.tipoAlta = "Traslado";
    }
}