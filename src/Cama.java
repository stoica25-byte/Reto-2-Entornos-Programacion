/**
 * Clase que representa una Cama en el sistema hospitalario.
 */
public class Cama {
    private boolean disponibilidad;
    private Paciente pacienteAsignado;
    public Cama(){
        //Inicializamos los valores por defecto.
        //Una cama recién creada debería estar disponible y sin paciente.
        this.disponibilidad = true;
        this.pacienteAsignado = null;
    }
    public void asignacionPaciente (PersonalDeEnfermeria personal, Paciente paciente){
    }
    public void trasladoPaciente (PersonalDeEnfermeria personal, Paciente paciente){
    }
    public boolean isDisponibilidad(){
        return disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    public Paciente getPacienteAsignado(){
        return pacienteAsignado;
    }
    public void setPacienteAsignado(Paciente pacienteAsignado){
        this.pacienteAsignado = pacienteAsignado;
    }
}
