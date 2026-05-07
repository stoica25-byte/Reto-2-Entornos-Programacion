package edu.grupo2.proyectoreto.paciente;

import edu.grupo2.proyectoreto.utilidad.ConstantesHospital;
import edu.grupo2.proyectoreto.unidad.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa los momentos en los que un paciente estubo ingresado en el hospital.
 * 
 * Un paciente puede tener varios ingresos, si su úlitmo ingreso está activo, es por que ese
 * paciente se encuentra ingresado dentro del hospital actualmente.
 * 
 * @author Wilson
 */
final class Ingreso implements Serializable {
    /**
     * Estado del ingreso del paciente.
     * 
     * Solo un ingreso puede ser true, y debe ser el más reciente.
     * 
     * true marca que el último ingreso esta activo, es decir, que ese ingreso referencia
     * al presente, significando que el paciente sigue ingresado dentro del hospital en la
     * actualidad.
     * 
     * false marca que el ingreso esta inactivo. Si el último ingreso de un paciente está 
     * inactivo, significa que el paciente del ingreso no se encuenta ingresado actualmente en
     * el hospital.
     */
    private boolean activo;

    /**
     * Fecha en la que el paciente fue ingresado.
     * 
     * No acepta null.
     */
    private LocalDate fechaIngreso;

    /**
     * Enfermedades mentales del paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Esquizofrenia", 
     * "TDAH", 
     * "Trastorno bipolar", 
     * "Trastorno obsesivo compulsivo", 
     * "Trastorno Psicótico", 
     * "Trastorno antisocial".
     */
    private List<String> enfermedadesMentales = new ArrayList<>();

    /**
     * Marca si el paciente tiene o no discapacidades en este ingreso.
     * 
     * true marca que si tiene discapacidad, false marca que no tiene discapacidad.
     */
    private boolean discapacidad;

    /**
     * Tratamientos del paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Analgésicos", 
     * "Antiinflamatorios", 
     * "Antibióticos", 
     * "Sueros", 
     * "Antidiarreicos", 
     * "Antipsicóticos", 
     * "Terapia conductual", 
     * "Estabilizadores del ánimo", 
     * "Antidepresivos", 
     * "Medicación anticonvulsiva".
     */
    private List<String> tratamientos = new ArrayList<>();

    /**
     * Nivel de gravedad del paceinte en este ingreso.
     * 
     * Los valores permitidos son: "Bajo", "Medio", "Alto".
     * No acepta null.
     */
    private String gravedad;

    /**
     * Especialidad requerida para el paciente en este ingreso.
     * 
     * Los valores permitidos son: 
     * "Psiquiatría", 
     * "Neurología", 
     * "Rehabilitación", 
     * "Traumatología", 
     * "Medicina General", 
     * "Cuidados Intensivos".
     */
    private String especialidad;

    /**
     * Unidad en la que el paceinte esta vinculado/asignado en este ingreso
     */
    private Unidad unidadVinculada;

    /**
     * Habitación en la que el paceinte esta vinculado/asignado en este ingreso
     */
    private Habitacion habitacionVinculada;

    /**
     * Cama en la que el paceinte esta vinculado/asignado en este ingreso
     */
    private Cama camaVinculada;

    /**
     * Crea un nuevo ingreso con la información referente al estado del paciente en este ingreso especificada
     * por parametro.
     * 
     * @param fechaIngreso         fecha en la que el paciente fue ingresado, 
     *                             no acepta null, 
     *                             solo se acepta valores permitidos
     * 
     * @param enfermedadesMentales lista de enfermedades mentales del paciente en este ingreso, 
     *                             solo se acepta valores permitido
     * 
     * @param discapacidades       marca si el paciente tiene o no discapacidad, true si tiene, false no tiene
     * 
     * @throws NullPointerException     si 'fechaIngreso' se le pasa null
     * @throws IllegalArgumentException si a 'enfermedadesMentales' se le pasa una lista con algún valor no valido
     */
    Ingreso(LocalDate fechaIngreso, List<String> enfermedadesMentales, boolean discapacidad) {
        if (fechaIngreso == null) {
            throw new NullPointerException("Parametro 'fechaIngreso' no acepta null.");
        }

        // Se comprueba que cada valor de la lista 'enfermedadesMentales' tenga una cadena valida
        for (String enfermedadMental : enfermedadesMentales) {
            if (!ConstantesHospital.ENFERMEDADES_MENTALES_VALIDAS.contains(enfermedadMental)) {
                throw new IllegalArgumentException
                ("Parametro 'enfermedadesMentales' se le paso una enfermedad no valida.");
            }
        }

        activo = true;
        this.fechaIngreso = fechaIngreso;
        this.enfermedadesMentales = enfermedadesMentales;
        this.discapacidad = discapacidad;
        gravedad = gravedadCorrecta();
        especialidad = especialidadCorrecta();
    }

    /*
     * Devuelve una cadena de cual seria la gravedad correcta del paceinte en función de su condición.
     */
    private String gravedadCorrecta () {
        if (enfermedadesMentales.size() > 3) {
            return "Alto";
        }
        else if (discapacidad == true || enfermedadesMentales.size() > 2) {
            return "Medio";
        }
        else {
            return "Bajo";
        }
    }

    /*
    * Devuelve la especialidad más adecuada para el paciente en función de sus
    * enfermedades mentales y si tiene discapacidad.
    * 
    * Se recogen todas las especialidades requeridas por sus condiciones y se
    * devuelve la más importante según el orden de ESPECIALIDADES_VALIDAS.
    */
    private String especialidadCorrecta() {
        //Lista donde méteremos las especialidades del paciente, de las que elegiremos una
        List<String> especialidadesPaciente = new ArrayList<>();

        // Añadimos a la lista de especialidades una especialidad por enfermedad, sin repetirlas
        for (String enfermedad : enfermedadesMentales) {
            String especialidad = ConstantesHospital.ESPECIALIDAD_POR_CONDICION.get(enfermedad);

            // Se comprueba que la especialida relacioanda a está enfermedad no se haya guardado antes
            if (!especialidadesPaciente.contains(especialidad)) {
                especialidadesPaciente.add(especialidad);
            }
        }

        // Si tiene discapacidad, tambien guardamos Rehabilitación en la lista de especialidades
        if (discapacidad) {
            especialidadesPaciente.add("Rehabilitación");
        }

        // Devolvemos la especialidad más importante según ESPECIALIDADES_VALIDAS
        // Cómo la lista ESPECIALIDADES_VALIDAS ya está ordenada, encontrara primero la más importante
        for (String especialidadMasImportante : ConstantesHospital.ESPECIALIDADES_VALIDAS) {
            if (especialidadesPaciente.contains(especialidadMasImportante)) {
                return especialidadMasImportante;
            }
        }

        // Si el paciente no tiene nada de lo anterior, devolvemos 'Medicina General'
        return "Medicina General";
    }

    /**
     * Devuelve el estado del ingreso del paciente.
     * 
     * @return true si el ingreso está activo, false si está inactivo
     */
    boolean isActivo() {
        return activo;
    }

    /**
     * Devuelve la fecha en la que el paciente fue ingresado.
     * 
     * @return fecha en la que el paciente fue ingresado
     */
    LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha en la que el paciente fue ingresado.
     * 
     * @param fechaIngreso nueva fecha de ingreso del paciente, no acepta null
     * 
     * @throws NullPointerException si 'fechaIngreso' se le pasa null
     */
    void setFechaIngreso(LocalDate fechaIngreso) {
        if (fechaIngreso == null) {
            throw new NullPointerException("Parametro 'fechaIngreso' no acepta null.");
        }
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Devuelve la lista de enfermedades mentales del paciente en este ingreso.
     * 
     * @return lista de enfermedades mentales del paciente
     */
    List<String> getEnfermedadesMentales() {
        return enfermedadesMentales;
    }

    /**
     * Establece las enfermedades mentales del paciente.
     * 
     * Al cambiar las enfermedades, la gravedad y la especialidad se vuelven a reasignar.
     * 
     * @param enfermedadesMentales nueva lista de enfermedades mentales del paciente,
     *                             solo se aceptan valores permitidos
     * 
     * @throws IllegalArgumentException si alguna enfermedad de la lista no es valido
     */
    void setEnfermedadesMentales(List<String> enfermedadesMentales) {
        // Se comprueba que cada valor de la lista 'enfermedadesMentales' tenga una cadena valida
        for (String enfermedadMental : enfermedadesMentales) {
            if (!ConstantesHospital.ENFERMEDADES_MENTALES_VALIDAS.contains(enfermedadMental)) {
                throw new IllegalArgumentException
                ("Parametro 'enfermedadesMentales' se le paso una enfermedad no valida.");
            }
        }

        this.enfermedadesMentales = enfermedadesMentales;

        //Se reasigna la gravedad y especialidad
        this.gravedad = gravedadCorrecta();
        this.especialidad = especialidadCorrecta();
    }

    /**
     * Devuelve si el paciente tiene o no discapacidad en este ingreso.
     * 
     * @return true si tiene discapacidad, false si no tiene
     */
    boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * Establece si el paciente tiene o no discapacidad en este ingreso.
     * 
     * Al cambiar la discapacidad, la gravedad y la especialidad se reasignan.
     * 
     * @param discapacidad true si tiene discapacidad, false si no tiene
     */
    void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;

        //Se reasigna la gravedad y especialidad
        this.gravedad = gravedadCorrecta();
        this.especialidad = especialidadCorrecta();
    }

    /**
     * Devuelve la lista de tratamientos del paciente.
     * 
     * @return lista de tratamientos del paciente
     */
    List<String> getTratamientos() {
        return tratamientos;
    }

    /**
     * Establece los tratamientos del paciente.
     * 
     * @param tratamientos nueva lista de tratamientos del paciente, solo se aceptan valores permitidos
     * 
     * @throws IllegalArgumentException si algún tratamiento de la lista no es válido
     */
    void setTratamientos(List<String> tratamientos) {
        for (String tratamiento : tratamientos) {
            if (!ConstantesHospital.TRATAMIENTOS_VALIDOS.contains(tratamiento)) {
                throw new IllegalArgumentException(
                    "Parametro 'tratamientos' se le paso un tratamiento no valido.");
            }
        }

        this.tratamientos = tratamientos;
    }

    /**
     * Devuelve el nivel de gravedad del paciente en este ingreso.
     * 
     * @return nivel de gravedad del paciente
     */
    String getGravedad() {
        return gravedad;
    }

    /**
     * Devuelve la especialidad requerida para el paciente en este ingreso.
     * 
     * @return especialidad requerida para el paciente
     */
    String getEspecialidad() {
        return especialidad;
    }

    /**
     * Devuelve la unidad en la que el paciente esta vinculado/asignado en este ingreso.
     * 
     * @return la unidad en la que el paciente esta vinculado/asignado en este ingreso
     */
    Unidad getUnidadVinculada() {
        return unidadVinculada;
    }

    /**
     * Devuelve la habitación en la que el paciente esta vinculado/asignado en este ingreso.
     * 
     * @return la habitación en la que el paciente esta vinculado/asignado en este ingreso
     */
    Habitacion geHabitacionVinculada() {
        return habitacionVinculada;
    }

    /**
     * Devuelve la cama en la que el paciente esta vinculado/asignado en este ingreso.
     * 
     * @return la cama en la que el paciente esta vinculado/asignado en este ingreso
     */
    Cama getCamaVinculada() {
        return camaVinculada;
    }

    /**
     * Devuelve una cadena con todos los datos del ingreso.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores del ingreso
     */
    @Override
    public String toString() {
        return String.format(
            "Ingreso{activo=%s, fechaIngreso=%s, enfermedadesMentales=%s, " + 
            "discapacidad=%s, tratamientos=%s, gravedad='%s', especialidad='%s'}",
            activo,
            fechaIngreso,
            enfermedadesMentales,
            discapacidad,
            tratamientos,
            gravedad,
            especialidad
        );
    }
}