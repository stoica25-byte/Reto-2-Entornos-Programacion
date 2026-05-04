/**
 * Clase abstracta base para todo el personal de salud
 * Hereda de la clase general Personal
 */
public abstract class PersonalDeSalud extends Personal{
    //Visibilidad protected para que solo las clases hijas lo usen
    protected PersonalDeSalud(){
        super(); //Llama al cosntructor de la clase padre (Personal)
    }
    public void generarNotaEvolucionPaciente(Paciente paciente, String observacion){
        //Lógica para generar la nota de evolución
    }
    public void rondaMedicaDiariaPaciente(Paciente paciente){
        //Lógica para la ronda médica diaria básica
    }
    @override //Sobrecarga del método de ronda médica
    public void rondaMedicaDiariaPaciente(Paciente paciente, String observacionNota){
        //Lógica para la ronda médica diaria con observación
    }
}
