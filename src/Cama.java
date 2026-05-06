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
    /**
    *Visibilidad de paquete.
    *Una cama no puede asignarse si ya está ocupada
    */
    public void asignacionPaciente (PersonalDeEnfermeria personal, Paciente paciente){
        if(this.disponibilidad){
            //Si está libre, asignamos y cambiamos estado
            this.pacienteAsignado = paciente;
            this.disponibilidad = false;
            System.out.println("SISTEMA: Cama asignada al paciente " + paciente.getNombre());
        } else {
            throw new IllegalArgumentException("Error: La cama ya esta ocupada por otro paciente");
        }
    }
    /**
    *Libera la cama para que pueda ser usada
    */
    public void trasladoPaciente (PersonalDeEnfermeria personal, Paciente paciente){
        if(this.pacienteAsignado != null && this.pacienteAsignado.equals(paciente)) {
            //Liberamos la cama
            this.pacienteAsignado = null;
            this.disponibilidad = true;
            System.out.println("SISTEMA: Cama liberada correctamente");
        } else {
            throw new IllegalArgumentException("Error: El paciente indicado no coincide con el ocupante de la cama");
        }
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
