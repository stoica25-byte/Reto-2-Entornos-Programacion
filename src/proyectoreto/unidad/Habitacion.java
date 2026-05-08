package proyectoreto.unidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una Habitación en el sistema hospitalario.
 * 
 * Las habitaciones, junto con las camas, es un elemento que usan las unidades
 * para organizar su
 * espacio para los pacientes.
 * 
 * @author Wilson
 */
public final class Habitacion implements Serializable {

    /**
     * Camas de la habitación.
     */
    private List<Cama> camas = new ArrayList<>();

    /**
     * Crea una habitación con el numero de camas especificado.
     * 
     * @param numeroCamas cantidad de camas que tendra la habitación
     * 
     * @throws IllegalArgumentException si se pasa por parametro un valor menor a 1
     */
    Habitacion(int numeroCamas) {
        // Comprobamos que minimo se cree 1 cama en la habitación
        if (numeroCamas < 1) {
            throw new IllegalArgumentException("Parametro 'numeroCamas' no acepta valores menores a 1.");
        }

        // Se crea el numero de camas que se especifique
        for (int i = 1; i <= numeroCamas; i++) {
            camas.add(new Cama());
        }
    }

    /**
     * Devuelve la lista de las camas de la habitación
     */
    List<Cama> getCamas() {
        return camas;
    }

    /**
     * Devuelve una cadena con todos los datos de la cama.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format("Habitacion{camas=%s}", camas);
    }
}
