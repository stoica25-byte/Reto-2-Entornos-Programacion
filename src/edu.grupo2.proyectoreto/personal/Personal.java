package edu.grupo2.proyectoreto.personal;

/**
 * Clase abstracta que representa a cualquier empleado del hospital.
 * Sirve como clase base (superclase) para los diferentes roles específicos
 * como Médico, Personal de Enfermería o Personal Administrativo,
 * centralizando los datos comunes a todos ellos.
 * * @author Alex
 * 
 * @version 1.0 (28/04/2026)
 */

public abstract class Personal {
    /**
     * El nombre del empleado
     */
    private String nombre;
    /**
     * El primer apellido del empleado
     */
    private String primerApellido;
    /**
     * El segundo apellido del empleado
     */
    private String segundoApellido;

    /**
     * <p>
     * Constructor por defecto sin parametros para la clase padre, visibilidad
     * protegida(#),
     * Inicializa los atributos del personal con cadenas vacias en vez de null,
     * diseñado para ser
     * invocado por las clases hijas: PersonalAdministrativo, de enfermeria , Medico
     * etc...
     */
    protected Personal() {
        this.nombre = "";
        this.primerApellido = "";
        this.segundoApellido = "";
    }

    // --- GETTERS Y SETTERS ---
    // (Añádelos si tu equipo ha acordado que las clases hijas
    // necesiten lee    r o modificar estos datos).

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
}