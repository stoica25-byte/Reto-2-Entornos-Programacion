package edu.grupo2.proyectoreto.personal;

/**
 * Clase abstracta que representa a cualquier empleado del hospital.
 * 
 * Sirve como clase base (superclase) para los diferentes roles como Médico, Personal de Enfermería 
 * o Personal Administrativo, centrando los datos que comparten todo el personal.
 * 
 * @author Alex
 */

public abstract class Personal {
    /**
     * El nombre del empleado.
     * 
     * No acepta null.
     * No acepta cadenas llenas de espacios.
     */
    private String nombre;

    /**
     * El apellido del empleado.
     * 
     * No acepta null.
     * No acepta cadenas llenas de espacios.
     */
    private String apellido;

    /**
     * Crea un paciente con su nombre y apellido.
     * 
     * @param nombre   nombre del empleado, no acepta null ni cadena llena de espacios
     * @param apellido apellido del empleado, no acepta null ni cadena llena de espacios
     * 
     * @throws NullPointerException     si 'nombre' o 'apellido' se les pasa null
     * @throws IllegalArgumentException si 'nombre' o 'apellido' se les pasa una cadena llena de espacios
     */
    protected Personal(String nombre, String apellido) {
        // Comprueba que el nombre se rellene y no sea una cadena llena de espacios.
        if (nombre == null) {
            throw new NullPointerException("Parametro 'nombre' no acepta null.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Parametro 'nombre' no acepta una cadena de solo espacios.");
        }

        // Comprueba que el apellido se rellene y no sea una cadena llena de espacios.
        if (apellido == null) {
            throw new NullPointerException("Parametro 'apellido' no acepta null.");
        }
        if (apellido.isBlank()) {
            throw new IllegalArgumentException("Parametro 'apellido' no acepta una cadena de solo espacios.");
        }

        this.nombre = nombre;
        this.apellido = apellido;
    }

    /**
     * Devuelve el nombre del empleado.
     * 
     * @return el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Esteblece un nuevo nombre para el empleado.
     * 
     * @param nombre nuevo nombre para el empleado, no acepta null ni cadenas llenas de espacios
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una cadena llena de espacios
     */
    public void setNombre(String nombre) {
        // Comprueba que el nombre se rellene y no sea una cadena llena de espacios.
        if (nombre == null) {
            throw new NullPointerException("Parametro 'nombre' no acepta null.");
        }
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("Parametro 'nombre' no acepta una cadena de solo espacios.");
        }

        this.nombre = nombre;
    }

    /**
     * Devuelve el apellido del empleado.
     * 
     * @return el apellido del empleado
     */
    public String getapellido() {
        return primerApellido;
    }

    /**
     * Esteblece un nuevo apellido para el empleado.
     * 
     * @param apellido nuevo apellido para el empleado, no acepta null ni cadenas llenas de espacios
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una cadena llena de espacios
     */
    public void setapellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
}