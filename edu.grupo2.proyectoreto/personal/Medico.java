package edu.grupo2.proyectoreto.personal;
/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud y gestiona la evaluación final del paciente
 *
 *@author Diana
 */
public class Medico extends PersonalDeSalud{
    /**
    * Constructor público por defecto (+)
    * Llama al constructor de la superclase PersonalDeSalud para inicializar
    * los atributos heredados (ESPECIFICAR AÚN)
    */
    public Medico(){
        //Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super();
    }
    /**
    * Devuelve una cadena con los datos del médico
    *
    * Se muestran los datos según la convención de java para los métodos toString:
    * - NombreClase{ campo1='valor1', campo2='valor2'}
    *
    * @return una cadena con todos los atributos y sus valores
    */
    @override
    public String toString(){
        return String.format(
            "Medico{nombreMedico='%s', especialidadMedica='%s'}",
            nombreMedico,
            especialidadMedica
        );
    }
}
