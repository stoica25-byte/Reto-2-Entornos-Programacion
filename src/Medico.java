/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud
 */
public class Medico extends PersonalDeSalud{
    public Medico(){
        //Llamamos al constructo portected de la clase padre (PersonalDeSalud)
        super();
    }
    public void evaluacionFinalPaciente(Paciente paciente, Fecha fechaAlata){
        //Implementar la lógica de la evaluación final
        //Pasos a seguir para crear la lógica:
        //1: Crear el informa del alta (create)
        //2: Actualizar el estado del paciente o su expediente (update)
        //3: Finalizar o "destruir" el ingreso activo actual (destroy)
    }
}
