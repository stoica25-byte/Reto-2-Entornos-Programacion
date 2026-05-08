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
    * los atributos heredados (nombre y apellidos)
    */
    public Medico(){
        //Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super(nombre, primerApellido, segundoApellido);
    }
    /**
    * Devuelve una cadena con los datos del médico
    *
    * Se muestran los datos según la convención de java para los métodos toString:
    * - NombreClase{ campo1='valor1', campo2='valor2'}
    *
    * @return una cadena con todos los atributos y sus valores
    *
    * @param nombre  nombre del epleado, no acepta null ni cadena llena de espacios
    * @param apellido  apellido del empleado, no acepta null ni cadena llena de espacios
    *
    * @throws NullPointerException  si 'nombre' o 'apellido' se les pasa null
    * @throws IllegalArgumentException  si 'nombre' o 'apellido' se les pasa una cadena llena de espacios
    */
    @override
    public String toString(){
        return String.format(
            "Medico{nombre='%s', primerApellido='%s', segundoApellido=%s}",
            getNombre(),
            getPrimerApellido(),
            getSegundoApellido()
        );
    }
}