package edu.grupo2.proyectoreto.personal;
/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud y gestiona la evaluación final del paciente
 *
 *@author Diana
 */
public class Medico extends PersonalDeSalud{
    /**
    * Poner comentarios
    */
    public Medico(){
        //Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super();
    }
    @override
    public String toString(){
        return String.format(
            "Medico{nombreMedico='%s', especialidadMedica='%s' " +
            "observacionNota='%s'"},
            nombreMedico,
            especialidadMedica,
            observacionNota
        );
    }
}
