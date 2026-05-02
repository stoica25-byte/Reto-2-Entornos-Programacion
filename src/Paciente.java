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
    public void generarNotaEvolucion(){
    }
    public void rondaMedicaDiaria(){
    }
    public void asignacion(){
    }
    public void traslado(){
    }
    public void evaluacionFinal(){
    }
    public void documentacionAltaPaciente(){
    }
    public void avanzarDia(){
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
        return this.expedient.get(this.expediente.size() - 1);
    }
}
