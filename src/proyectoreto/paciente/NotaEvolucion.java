// TODO: Añadir Aserciones

package proyectoreto.paciente;

import java.time.LocalDate;

/**
 * Representa la información referente a las notas de evolucion de los ingresos
 * de un paciente.
 * 
 * @author Jaime
 * @author Wilson
 */
final class NotaEvolucion {

    /**
     * Fecha en la que se escibio la nota de evolución.
     * 
     * No acepta null.
     */
    private LocalDate fecha;

    /**
     * Mensaje que quiso trasmitir el personal que hizo la nota de evolución.
     * 
     * No acepta null.
     * No acepta cadena llena de espacios.
     */
    private String observacion;

    /**
     * Crea una nueva nota de evolución con los datos especificados por parametro.
     * 
     * @param fecha       fecha en la que se escribio la nota de evolución, no
     *                    acepta null
     * @param observacion mensaje que se quiere trasmitir en la nota de evolución,
     *                    no acepta null ni cadena de espacios
     * @throws NullPointerException     si 'fecha' o 'observación' se les pasa null
     * @throws IllegalArgumentException si 'observacion' se le pasa una cadena llena
     *                                  de espacios
     */
    NotaEvolucion(LocalDate fecha, String observacion) {
        if (fecha == null) {
            throw new NullPointerException("Parametro 'fecha' no acepta null.");
        }

        if (observacion == null) {
            throw new NullPointerException("Parametro 'observacion' no acepta null.");
        }
        if (observacion.isBlank()) {
            throw new IllegalArgumentException("Parametro 'observacion' no acepta una cadena llena de espacios");
        }

        this.fecha = fecha;
        this.observacion = observacion;
    }

    /**
     * Devuelve la fecha en la que se escribio la nota de evolución.
     * 
     * @return la fecha en la que se escribio la nota de evolución
     */
    LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en la que se escribio la nota de evolución.
     * 
     * @param fecha fecha en la que se escribio la nota de evolución, no acepta null
     * 
     * @throws NullPointerException si al parametro se le pasa null
     */
    void setFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new NullPointerException("Parametro 'fecha' no acepta null.");
        }

        this.fecha = fecha;
    }

    /**
     * Devuelve la observación de la nota de evolución.
     * 
     * @return la observación de la nota de evolución.
     */
    String getObservacion() {
        return observacion;
    }

    /**
     * Establece la observación de la nota de evolución.
     * 
     * @param observacion mensaje que se quiere trasmitir en la nota de evolución,
     *                    no acepta null ni cadena de espacios
     * 
     * @throws NullPointerException     si al parametro se le pasa null
     * @throws IllegalArgumentException si al parametro se le pasa una cadena llena
     *                                  de espacios
     */
    void setObservacion(String observacion) {
        if (observacion == null) {
            throw new NullPointerException("Parametro 'observacion' no acepta null.");
        }

        if (observacion.isBlank()) {
            throw new IllegalArgumentException("Parametro 'observacion' no acepta una cadena llena de espacios");
        }

        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return String.format(
                "NotaEvolucion{fecha=%s, observacion='%s'}",
                fecha,
                observacion);
    }
}
