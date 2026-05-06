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
}
