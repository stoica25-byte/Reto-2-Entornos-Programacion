package edu.grupo2.proyectoreto.personal;
/**
 * Clase abstracta base para todo el personal de salud
 * Hereda de la clase general Personal
 * Es la base para Médicos y Enfermeros
 */
public abstract class PersonalDeSalud extends Personal{
    //Visibilidad protected para que solo las clases hijas lo usen
    protected PersonalDeSalud(){
        super(); //Llama al cosntructor de la clase padre (Personal)
    }
}
