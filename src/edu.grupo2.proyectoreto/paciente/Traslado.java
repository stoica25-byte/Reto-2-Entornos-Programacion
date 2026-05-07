// TODO: Añadir Aserciones

package edu.grupo2.proyectoreto.paciente;

/**
 * Representa el traslado de un paciente a otro hospital.
 * 
 * Cada traslado está asociado a un unico alta.
 * Esta clase no permite valores nulos, cadenas vacias o cadenas llenas de espacios en ninguno de sus atributos.
 * 
 * @author Jaime
 * @author Wilson
 */
final class Traslado {
    /** 
     * Nombre del hospital al cual se trasladara al paciente.
     * 
     * No acepta null.
     * No acepta cadenas vacias.
     * No acepta cadenas llena de espacios.
     */
    private String hospitalDestino;

    /** 
     * Motivo del traslado. 
     * 
     * No acepta null.
     * No acepta cadenas vacias.
     * No acepta cadenas llenas de espacios.
     */
    private String motivo;

    /** 
     * Crea un nuevo traslado con los datos indicados por parametro.
     * 
     * @param hospitalDestino nombre del hospital al cual se trasladara al paciente, no puede estar vacio ni ser null
     * @param motivo          motivo del traslado, no puede estar vacío ni ser null
     * 
     * @throws NullPointerException     si 'hospitalDestino' o 'motivo' se les pasa null
     * @throws IllegalArgumentException si 'hospitalDestino' o 'motivo' se les pasa una cadena vacia, o
     *                                  si 'hospitalDestino' o 'motivo' se les pasa una cadena llena de espacios
     */
    Traslado(String hospitalDestino, String motivo) {
        if (hospitalDestino == null) {
            throw new NullPointerException("Parametro 'hospitalDestino' no acepta null.");
        }
        if (hospitalDestino.equals("")) {
            throw new IllegalArgumentException("Parametro 'hospitalDestino' no acepta una cadena vacia.");
        }
        if(hospitalDestino.isBlank()) {
            throw new IllegalArgumentException("Parametro 'hospitalDestino' no acepta una cadena entera de 'espacio'.");
        }

        if (motivo == null) {
            throw new NullPointerException("Parametro 'motivo' no acepta null.");
        }
        if (motivo.equals("")) {
            throw new IllegalArgumentException("Parametro 'motivo' no acepta una cadena vacia");
        }
        if(motivo.isBlank()) {
            throw new IllegalArgumentException("Parametro 'motivo' no acepta una cadena entera de 'espacio'.");
        }

        this.hospitalDestino = hospitalDestino;
        this.motivo = motivo;
    }

    /**
     * Devuelve el nombre del hospital de destino.
     * 
     * @return el hospital de destino
     */
    String getHospitalDestino() {
        return hospitalDestino;
    }

    /**
     * Establece el nombre del hospital de destino.
     * 
     * @param hospitalDestino nombre del hospital de destino, no puede ser null, estar vacío, ni ser solo espacios
     * 
     * @throws NullPointerException     si al parametro se le pasa null
     * @throws IllegalArgumentException si al parametro se le pasa una cadena vacia, o
     *                                  si al parametro se le pasa una cadena llena de espacios
     */
    void setHospitalDestino(String hospitalDestino) {
        if (hospitalDestino == null) {
            throw new NullPointerException("Parametro 'hospitalDestino' no acepta null.");
        }
        if (hospitalDestino.equals("")) {
            throw new IllegalArgumentException("Parametro 'hospitalDestino' no acepta una cadena vacia.");
        }
        if(hospitalDestino.isBlank()) {
            throw new IllegalArgumentException("Parametro 'hospitalDestino' no acepta una cadena entera de 'espacio'.");
        }
        
        this.hospitalDestino = hospitalDestino;
    }

    /**
     * Devuelve el motivo del traslado.
     * 
     * @return el motivo del traslado
     */
    String getMotivo() {
        return motivo;
    }

    /**
     * Establece le motivo del traslado.
     * 
     * @param motivo motivo del traslado, no puede ser null, estar vacío, ni ser solo espacios
     * 
     * @throws NullPointerException     si al parametro se le pasa null
     * @throws IllegalArgumentException si al parametro se le pasa una cadena vacia, o
     *                                  si al parametro se le pasa una cadena llena de espacios
     */
    void setMotivo(String motivo) {
        if (motivo == null) {
            throw new NullPointerException("Parametro 'motivo' no acepta null.");
        }
        if (motivo.equals("")) {
            throw new IllegalArgumentException("Parametro 'motivo' no acepta una cadena vacia");
        }
        if(motivo.isBlank()) {
            throw new IllegalArgumentException("Parametro 'motivo' no acepta una cadena entera de 'espacio'.");
        }

        this.motivo = motivo;
    }

    /**
     * Devuelve una cadena que muestra el nombre y valor de todos los atributos.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'} 
     * 
     * @return cadena con el hospital de destino y el motivo del traslado.
     */
    @Override
    public String toString() {
        return String.format(
            "Traslado{hospitalDestino='%s', motivo='%s'}", 
            hospitalDestino, 
            motivo
        );
    }
}