package edu.grupo2.proyectoreto.paciente;
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
    /**
    * Método que devuelve el objeto de la clase ingreso que está activo en ese momento
    * Obligatorio para que el programa compile sin errores
    */
    Ingreso getExpediente(){
        //Devuelve el último ingreso de la lista (el activo)
        return expediente.get(expediente.size() - 1);
    }
}
