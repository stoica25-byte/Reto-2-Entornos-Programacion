package edu.grupo2.proyectoreto.personal;

import edu.grupo2.proyectoreto.personal.Personal;

/**
 * @author Jaime
 */
public class PersonalDeEnfermeria extends Personal {

    /**
     * 
     * Crea un nuevo medico con su nombre y apellido.
     * 
     * @param nombre   nombre del empleado, no acepta null ni cadena llena de espacios
     * @param apellido apellido del empleado, no acepta null ni cadena llena de espacios
     * 
     * @throws NullPointerException     si 'nombre' o 'apellido' se les pasa null
     * @throws IllegalArgumentException si 'nombre' o 'apellido' se les pasa una cadena llena de espacios
     */
    public PersonalDeEnfermeria(String nombre, String apellido) {
        super(nombre, apellido);
    }

    /**
     * Devuelve una cadena con todos los datos del paciente.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
            "PersonalDeEnfermeria{nombre='%s', apellido='%s', expediente=%s}",
            getNombre(),
            getapellido()
        );
    }
}
