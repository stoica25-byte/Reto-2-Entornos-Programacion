/**
 * Clase que representa a un paciente en el sistema hospitalario
 */
import java.util.ArrayList;
import java.util.List;
public class Paciente {
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private List<Ingreso> expediente;
    public Paciente(String nombre, String primerApellido, String segundoApellido){
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.expediente = new ArrayList<>();
    }
    public void generarNotaEvolucion(PersonalDeSalud personal, String observacion){
        inf(personal != null) {
            personal.generarNotaEvaluacionPaciente(this, observacion);
        } else {
            throw new IllegalArgumentException("Error: el personal no puede ser nulo");
        }
    }
    public void rondaMedicaDiaria(PersonalDeSalud personal){
        if(personal != null) {
            personal.rondaMedicaDiariaPaciente(this);
        } else {
            throw new IllegalArgumentException("Error: El personal de salud no puede ser nulo");
        }
    }
    //Sobrecarga del método ronda por si el personal quiere añadir una nota especifica
    @override
    public void rondaMedicaDiaria(PersonalDeSalud personal, observacionNota){
        if(personal != null) {
            personal.rondaMedicaDiariaPaciente(this, observacionNota);
        } else {
            throw new IllegalArgumentException("Error: el personal de salud no puede ser nulo");
        }
    }
    public void asignacion(PersonalDeEnfermeria personal, Unidad unidad, Habitacion habitacion, Cama cama){
        if (personal != null){
            personal.asignarCamaPaciente(this, cama);
        } else {
            throw new IllegalArgumentException("Error: El personal de enfermería no puede ser nulo");
        }
    }
    public void traslado(PersonalDeEnfermeria personal, Unidad unidad, Habitacion habitacion, Cama cama){
        if(personal != null){
            //Gestión del traslado del paciente, puede ser interno o externo
            System.out.println("Gestionando el traslado del paciente");
        } else {
            throw new IllegalArgumentException("Error: El personal de enfermería no puede ser nulo");
        }
    }
    public void evaluacionFinal(Medico medico, Fecha fechaAlta){
        if(medico != null) {
            medico.evaluacionFinalPaciente(this, fechaAlta);
        } else {
            throw new IllegalArgumentException("Error: El personal médico no puede ser nulo");
        }
    }
    public void documentacionAltaPaciente(PersonalAdministrativo personal, String documentacion){
        if(personal != null) {
            System.out.println("SISTEMA: Personal administrativo procesando la documentación");
        } else {
            throw new IllegalArgumentException("Error: El personal administrativo no puede ser nulo");
        }
    }
    public void avanzarDia(){
        //Actualizar la información de estancia
        Ingreso actual = getUltimoIngreso();
        if(actual != null) {
            System.out.println("SISTEMA: Avanzando día de estancia para el ingreso actual");
            // actual.incrementarDias(); // Si la clase Ingreso tuviera este método
        }
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public List<Ingreso> getExpediente() {
        return expediente;
    }

    public void setExpediente(List<Ingreso> expediente) {
        this.expediente = expediente;
    }
    public Ingreso getUltimoIngreso(){
        if (this.expediente == null || this.expediente.isEmpty()){
            return null; //Seguridad: si no hay ingresos, devueve nulo
        }
        //Devuelve el último de la lista
        return this.expediente.get(this.expediente.size() - 1);
    }
}
