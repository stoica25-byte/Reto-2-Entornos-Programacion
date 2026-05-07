package edu.grupo2.proyectoreto.personal;

import edu.grupo2.proyectoreto.personal.Personal;

/**
 * Clase abstracta base para todo el personal de salud.
 * 
 * Hereda de la clase general Personal.
 * Es la base para Médicos y Enfermeros.
 * 
 * @author Diana
 */
public abstract class PersonalDeSalud extends Personal {
    /**
     * Inicializa el nombre y el apellido del empleado del personal de salud.
     * 
     * Visibilidad protected para que solo las clases hijas lo usen.
     * 
     * @param nombre   nombre del empleado, no acepta null ni cadena llena de espacios
     * @param apellido apellido del empleado, no acepta null ni cadena llena de espacios
     * 
     * @throws NullPointerException     si 'nombre' o 'apellido' se les pasa null
     * @throws IllegalArgumentException si 'nombre' o 'apellido' se les pasa una cadena llena de espacios
     */
    protected PersonalDeSalud(String nombre, String apellido){
        //Llama al constructor de la clase padre (Personal)
        super(nombre, apellido);
    }
}
