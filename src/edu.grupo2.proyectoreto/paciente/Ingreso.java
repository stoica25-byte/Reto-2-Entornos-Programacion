// TODO: Hacer constructor y su documentación.
// TODO: Hacer getter y setter con su documentación.
// TODO: Hacer overriding del método toString()
// TODO: Añadir Aserciones

package edu.grupo2.proyectoreto.paciente;

import java.time.LocalDate;

/**
 * Representa los momentos en los que un paciente estubo ingresado en el hospital.
 * 
 * Un paciente puede tener varios ingresos, si su úlitmo ingreso está activo, es por que ese
 * paciente se encuentra ingresado dentro del hospital actualmente.
 * 
 * @author Wilson
 */
final class Ingreso {
    /**
     * Estado del ingreso del paciente.
     * 
     * Solo un ingreso puede ser true, y debe ser el más reciente.
     * 
     * true marca que el último ingreso esta activo, es decir, que ese ingreso referencia
     * al presente, significando que el paciente sigue ingresado dentro del hospital en la
     * actualidad.
     * 
     * false marca que el ingreso esta inactivo. Si el último ingreso de un paciente está 
     * inactivo, significa que el paciente del ingreso no se encuenta ingresado actualmente en
     * el hospital.
     */
    boolean activo;

    /**
     * Fecha en la que el paciente fue ingresado.
     * 
     * No acepta null.
     */
    LocalDate fechaIngreso;

    /**
     * Enfermedades mentales del paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Esquizofrenia", 
     * "TDAH", 
     * "Trastorno bipolar", 
     * "Trastorno obsesivo‑compulsivo", 
     * "Trastorno Psicótico", 
     * "Trastorno antisocial".
     */
    String[] enfermedadesMentales;

    /**
     * Discapacidades del paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Ceguere", 
     * "Sordera", 
     * "Parálisis cerebral", 
     * "Amputación", 
     * "Distrofia muscular", 
     * "Epilepsia".
     */
    String[] discapacidades;

    /**
     * Tratamientos del paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Analgésicos", 
     * "Antiinflamatorios", 
     * "Antibióticos", 
     * "Sueros", 
     * "Antidiarreicos", 
     * "Antipsicóticos", 
     * "Terapia conductual", 
     * "Estabilizadores del ánimo", 
     * "Antidepresivos", 
     * "Medicación anticonvulsiva".
     */
    String[] tratamientos;

    /**
     * Nivel de gravedad del paceinte en este ingreso.
     * 
     * Los valores permitidos son: "Bajo", "Medio", "Alto".
     * No acepta null.
     */
    String gravedad;

    /**
     * Especialidad requerida para el paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Psiquiatría", 
     * "Neurología", 
     * "Rehabilitación", 
     * "Traumatología", 
     * "Medicina General", 
     * "Cuidados Intensivos".
     */
    String especialidad;

    Ingreso() {


    }
}