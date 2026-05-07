// TODO: Añadir Aserciones

package edu.grupo2.proyectoreto.paciente;

import java.time.LocalDate;

/**
 * Representa el alta médica de un paciente en uno de sus ingresos.
 * 
 * El alta marca el final del ciclo de vida del paciente dentro del hospital.
 * Un alta puede darse por recuperación o traslado.
 * 
 * @author Alex
 * @author Wilson
 */
final class Alta{
    /**
     * Tipo de alta basado en el motivo del alta del paciente.
     * 
     * Los valores permitidos son "RECUPERACIÓN" o "TRASLADO".
     * No acepta null.
     */
    private String tipoAlta;

    /**
     * La fecha establecida en la que el paciente sera dado de alta.
     * 
     * No acepta null.
     */
    private LocalDate fechaAlta;

    /**
     * Texto correspondiente a la documentación del alta.
     * 
     * No acepta cadenas llenas de espacios.
     */
    private String documentacion;

    /**
     * Contiene la información del traslado a otro centro médico en caso de alta por traslado.
     * 
     * Este objeto solo contendrá información si el alta es de tipo "TRASLADO". 
     * En caso de alta por recuperación, será null.
     */
    private Traslado traslado;

    /**
     * Crea un nuevo alta de tipo "RECUPERACIÓN".
     * 
     * @param fechaAlta fecha establecida en la que el paciente sera dado de alta, no acepta null
     * 
     * @throws NullPointerException si al parametro se le pasa null
     */
    Alta(LocalDate fechaAlta) {
        if (fechaAlta == null) {
            throw new NullPointerException("Parametro 'fechaAlta' no acepta null.");
        }

        this.fechaAlta = fechaAlta;
        tipoAlta = "RECUPERACIÓN";
    }

    /**
     * Crea un nuevo alta de tipo "TRASLADO".
     * 
     * @param fechaAlta       fecha establecida en la que el paciente sera dado de alta, no acepta null
     * @param hospitalDestino nombre del hospital al cual se trasladara al paciente, no puede estar vacio ni ser null
     * @param motivo          motivo del traslado, no puede estar vacío ni ser null
     * 
     * @throws NullPointerException     si 'fechaAlta','hospitalDestino' o 'motivo' se les pasa null
     * @throws IllegalArgumentException si 'hospitalDestino' o 'motivo' se les pasa una cadena vacia, o
     *                                  si 'hospitalDestino' o 'motivo' se les pasa una cadena llena de espacios
     */
    Alta(LocalDate fechaAlta, String hospitalDestino, String motivo) {
        if (fechaAlta == null) {
            throw new NullPointerException("Parametro 'fechaAlta' no acepta null.");
        }

        this.fechaAlta = fechaAlta;
        tipoAlta = "TRASLADO";

        traslado = new Traslado(hospitalDestino, motivo);
    }

    /**
     * Devuelve el tipo de alta.
     * 
     * @return el tipo de alta
     */
    String getTipoAlta() { return tipoAlta; }

    /**
     * Devuelve la fecha en la que el paciente sera dado de alta.
     * 
     * @return la fecha en la que el paciente sera dado de alta
     */
    LocalDate getFechaAlta() { 
        return fechaAlta; 
    }

    /**
     * Establece la fecha en la que el paciente sera dado de alta.
     * 
     * @param fechaAlta fecha establecida en la que el paciente sera dado de alta, no acepta null
     * 
     * @throws NullPointerException si al parametro se le pasa null
     */
    void setFechaAlta(LocalDate fechaAlta) {
        if (fechaAlta == null) {
            throw new NullPointerException("Parametro 'fechaAlta' no acepta null.");
        }

        this.fechaAlta = fechaAlta;
    }

    /**
     * Devuelve la documentación del alta.
     * 
     * @return la documentación del alta
     */
    String getDocumentacion() {
        return documentacion;
    }

    /**
     * Establece la documentación del alta.
     * 
     * @param documentacion documentación del alta, no acepta cadenas llenas de espacios
     * 
     * @throws IllegalArgumentException si se pasa por parametro una cadena llena de espacios
     */
    void setDocumentacion(String documentacion) {
        if (documentacion.isBlank()) {
            throw new IllegalArgumentException("Parametro 'documentacion' no acepta una cadena con solo espacios.");
        }

        this.documentacion = documentacion;
    }

    /**
     * Devuelve una cadena con todos los datos del alta.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores del alta
     */
    @Override
    public String toString() {
        return String.format(
            "Alta{tipoAlta='%s', fechaAlta=%s, documentacion='%s', traslado=%s}",
            tipoAlta,
            fechaAlta,
            documentacion,
            traslado
        );
    }
}