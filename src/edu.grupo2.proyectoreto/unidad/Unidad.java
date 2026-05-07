package edu.grupo2.proyectoreto.unidad;

import edu.grupo2.proyectoreto.utilidad.ConstantesHospital;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una unidad del hospital.
 * 
 * Dentro de las unidades, es donde se alojara los pacientes ingresados.
 * 
 * @author Jaime
 * @authro Wilson
 */
public final class Unidad implements Serializable{

    /**
     * Nombre de la unidad.
     * 
     * No acepta null.
     * No acepta una cadena llena de espacios.
     */
    private String nombreUnidad;

    /**
     * Porcentaje de las camas disponibles de la unidad.
     * 
     * Valor permitido dentro del rango de 0 a 100.
     */
    private double porcentajeCamasDisponibles;

    /**
     * Especialidad Médica asociada a la unidad.
     */
    private String especialidadMedica;

    /**
     * Habitaciones de la unidad.
     */
    private List<Habitacion> habitaciones = new ArrayList<>();

    /**
     * Crea una unidad, con su nombre, especialidad y con el numero de habitaciones especificado.
     * 
     * @param nombreUnidad       nombre de la unidad
     * @param especialidadMedica especialidad Médica asociada a la unidad
     * @param numeroHabitaciones numero de habitaciones que tendra la unidad
     * @param camasPorHabitacion numero de camas que tendra cada habitacion
     * 
     * @throws NullPointerException     si 'nombreUnidad' o 'especialidadMedica' se les pasa null
     * @throws IllegalArgumentException si 'nombreUnidad' se le pasa una cadena llena de espacios,
     *                                  si 'especialidadMedica' se le pasa una especialidad medica no valida, o
     *                                  si 'numeroHabitaciones' o 'camasPorHabitacion' se les pasa un valor 
     *                                  menor a 1
     */
    public Unidad(String nombreUnidad, String especialidadMedica, int numeroHabitaciones, int camasPorHabitacion) {
        // Se comprueba si se pone null o si el nombre está lleno de espacios
        if (nombreUnidad == null) {
            throw new NullPointerException("Parametro 'nombreUnidad' no acepta null.");
        }
        if (nombreUnidad.isBlank()) {
            throw new IllegalArgumentException
            ("Parametro 'nombreUnidad' no acepta una cadena llena de espacios.");
        }

        // Se comprueba si se pone null o si la especialidadMedica no es una valida
        if (especialidadMedica == null) {
            throw new NullPointerException("Parametro 'especialidadMedica' no acepta null.");
        }
        if (!ConstantesHospital.ESPECIALIDADES_VALIDAS.contains(especialidadMedica)) {
            throw new IllegalArgumentException
            ("Parametro 'especialidadMedica' no se le paso una especialidad medica valida.");
        }

        // Comprobamos que minimo se cree 1 habitacion en la unidad
        if (numeroHabitaciones < 1) {
            throw new IllegalArgumentException("Parametro 'numeroHabitaciones' no acepta valores menores a 1.");
        }

        this.nombreUnidad = nombreUnidad;
        this.especialidadMedica = especialidadMedica;
        
        // Se crea el numero de habitacones que se especifico, con el numero de camas por habitación especificado
        for(int i = 1; i <= numeroHabitaciones; i++) {
            habitaciones.add(new Habitacion(camasPorHabitacion));
        }

        porcentajeCamasDisponibles = porcentajeCamasDisponibles();
    }

    /*
     * Se calcula el porcentaje de camas disponibles respecto a camas totales.
     * 
     * Se devuelve un numero decimal del 0 al 100, truncado a los 2 primeros decimales.
     */
    private int porcentajeCamasDisponibles() {
        int camasTotales = 0;
        int camasDisponibles = 0;
        double porcentaje;

        // Se observa la cantidad de camas que tiene cada habitación
        for(Habitacion habitacion : habitaciones) {
            camasTotales += habitacion.getCamas().size();
        }

        // Se comprueba en cama a cama por habitación, y se guarda la cantidad de camas disponibles
        for(Habitacion habitacion : habitaciones) {
            for(Cama cama : habitacion.getCamas()) {
                if(cama.isDisponibilidad()) {
                    camasDisponibles++;
                }
            }
        }

        // se guarda el calculo del porcentaje
        porcentaje = ((double) camasDisponibles / camasTotales) * 100;

        // Se devuelve el porcentaje, cojiendo solo los 2 primeros decimales
        return ((int)(porcentaje * 100)) / 100.0;
    }

    /**
     * Devuelve el nombre de la unidad.
     * 
     * @return el nombre de la unidad
     */
    public String getNombreUnidad() {
        return nombreUnidad;
    }

    /**
     * Establece un nuevo nombre para la unidad.
     * 
     * @param nombreUnidad nuevo nombre que se le dara a la unidad
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una cadena llena de espacios
     */
    public void setNombreUnidad(String nombreUnidad) {
        // Se comprueba si se pone null o si el nombre está lleno de espacios
        if (nombreUnidad == null) {
            throw new NullPointerException("Parametro 'nombreUnidad' no acepta null.");
        }
        if (nombreUnidad.isBlank()) {
            throw new IllegalArgumentException
            ("Parametro 'nombreUnidad' no acepta una cadena llena de espacios.");
        }

        this.nombreUnidad = nombreUnidad;
    }

    /**
     * Devuelve el porcentaje de camas disponibles respecto a las totales.
     * 
     * El porcentaje es un decimal truncado a 2 decimales.
     * 
     * @return el porcentaje de camas disponibles respecto a las totales
     */
    public double getPorcentajeCamasDisponibles() {
        return porcentajeCamasDisponibles;
    }


    /**
     * Devuelve la especialidad medica de la unidad.
     * 
     * @return la especialidad medica de la unidad
     */
    public String getEspecialidadMedica() {
        return especialidadMedica;
    }

    /**
     * Establece la especialidad medica que se quiere marcar a la unidad.
     * 
     * @param especialidadMedica especialidad Médica asociada a la unidad
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una especialidad medica no valida
     */
    public void setEspecialidadMedica(String especialidadMedica) {
        // Se comprueba si se pone null o si la especialidadMedica no es una valida
        if (especialidadMedica == null) {
            throw new NullPointerException("Parametro 'especialidadMedica' no acepta null.");
        }
        if (!ConstantesHospital.ESPECIALIDADES_VALIDAS.contains(especialidadMedica)) {
            throw new IllegalArgumentException
            ("Parametro 'especialidadMedica' no se le paso una especialidad medica valida.");
        }

        this.especialidadMedica = especialidadMedica;
    }

    /**
     * Devuelve una cadena con todos los datos de la cama.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
            "Unidad{nombreUnidad='%s', porcentajeCamasDisponibles=%f, " +
            "especialidadMedica='%s', habitaciones=%s}",
            nombreUnidad,
            porcentajeCamasDisponibles,
            especialidadMedica,
            habitaciones
        );
    }
}
