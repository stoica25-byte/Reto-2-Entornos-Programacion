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
    /**
    * Método para que el personal de salud realice la ronda médica sobre un pacienteç
    * Utiliza una cadena de llamadas en las que desde la clase PersonalDeSalud se puede
    * acceder al método de rondasMedicas de la clase Ingreso
    */
    void registrarRonda(Paciente objetoPaciente){
        objetoPaciente.getExpediente().setNuevaRondaMedicaDiaria();
    }
}
