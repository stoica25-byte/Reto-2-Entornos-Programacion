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
    public void generarNotaEvolucionPaciente(Paciente paciente, String observacion){
        //Lógica para generar la nota de evolución
        System.out.println("SISTEMA: Registrando nota clínica para " + paciente.getNombre());
        System.out.println("DETALLE: " + observacion);
    }
    /**
    * En cada ronda se decide si el paciente está recuperado y listo para la evaluación final
    */
    public void rondaMedicaDiariaPaciente(Paciente paciente){
        //Lógica para la ronda médica diaria básica
        //1. Se registra que se ha pasado la ronda hoy
        this.generarNotaEvolucionPaciente(paciente, "Ronda médica diaria realizada.");
        //2.Se actualiza el estado del paciente (avanzar día de estancia)
        paciente.avanzarDia();
        System.out.println("SISTEMA: Ronda completada y día de estancia actualizado");
    }
    /**
    * Sobrecarga del método: Permite añadir una observación específica durante la ronda
    */
    @override //Sobrecarga del método de ronda médica
    public void rondaMedicaDiariaPaciente(Paciente paciente, String observacionNota){
        //Lógica para la ronda médica diaria con observación
        //1. Registramos la nota específica que el profesional dicta
        this.generarEvolucionPaciente(paciente, observacionNota);
        //2. Guardamos en cada ronda si el paciente está recuperado para la evaluación final
        if(observacionNota.toLowerCase().contains("recuperado")){
            System.out.println("Alerta: Paciente marcado como apto para la evaluación final");
        }
        paciente.avanzarDia();
    }
}
