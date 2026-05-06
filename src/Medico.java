/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud y gestiona la evaluación final del paciente
 */
public class Medico extends PersonalDeSalud{
    public Medico(){
        //Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super();
    }
    /**
    *Realiza la evaluación técnica a los pacientes para determinar si pueden o no recibir el alta médica
    *y que el personal administrativo trabaje posteriormente con ella
    */
    public void evaluacionFinalPaciente(Paciente paciente, Fecha fechaAlata){
     //Valdación
        if(paciente != null) {
            System.out.println("MÉDICO: Iniciando evaluación final para " + paciente.getNombre());
            //Establecer la fecha del alta
            //Aquí se asigna la fechaAlta al último ingreso registrado del paciente

            //Modificar disponibilidad para administración
            System.out.println("SISTEMA: Evaluación técnica positiva. El paciente está listo para el alta");
            System.out.println("AVISO: Notificando al personal administrativo para procesar la documentación");
        } else {
            throw new IllegalArgumentException("El paciente no puede ser nulo");
        }
    }
}
