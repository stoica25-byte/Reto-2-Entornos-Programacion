package proyectoreto.personal;

/**
 * Clase abstracta que representa a cualquier empleado del hospital.
 * Sirve como clase base (superclase) para los diferentes roles específicos
 * como Médico, Personal de Enfermería o Personal Administrativo,
 * centralizando los datos comunes a todos ellos.
 *
 * @author Alex
 * @version 1.0 (28/04/2026)
 */
public abstract class Personal {
    /**
     * El nombre del empleado
     */
    private String nombre;

    /**
     * El apellido del empleado
     */
    private String apellido;

    /**
     * Constructor protegido con parámetros para inicializar los datos desde las
     * clases hijas.
     * 
     * @param nombre   El nombre del empleado
     * @param apellido El apellido del empleado
     */
    protected Personal(String nombre, String apellido) {
        this.nombre = (nombre != null) ? nombre : "";
        this.apellido = (apellido != null) ? apellido : "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
