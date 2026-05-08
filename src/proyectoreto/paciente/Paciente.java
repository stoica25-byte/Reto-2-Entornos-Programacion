package proyectoreto.paciente;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa a un paciente en el sistema hospitalario
 * 
 * @author Diana
 * @author Wilson
 */
public final class Paciente implements Serializable {

    /**
     * Nombre del paciente.
     * 
     * No acepta null.
     * No acepta cadena llena de espacios.
     */
    private String nombre;

    /**
     * Apellido del paciente.
     * 
     * No acepta null.
     * No acepta cadena llena de espacios.
     */
    private String apellido;

    /**
     * Expediente, es una lista de Ingresos, cada ingreso representanto las veces
     * que el paciente estubo
     * ingresado en el hospital.
     */
    private List<Ingreso> expediente = new ArrayList<>();

    private static List<Paciente> todosLosPacientes = new ArrayList<>();

    /**
     * Crea un paciente con su nombre y apellido.
     * 
     * @param nombre   nombre del paciente, no acepta null ni cadena llena de
     *                 espacios
     * @param apellido apellido del paciente, no acepta null ni cadena llena de
     *                 espacios
     * 
     * @throws NullPointerException     si 'nombre' o 'apellido' se les pasa null
     * @throws IllegalArgumentException si 'nombre' o 'apellido' se les pasa una
     *                                  cadena llena de espacios
     */
    public Paciente(String nombre, String apellido) {

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

        todosLosPacientes.add(this);
    }

    /**
     * Crea un nuevo ingreso con la información referente al estado del paciente en
     * este ingreso especificada
     * por parametro.
     * 
     * Solo se podra crear un nuevo ingreso, si el paciente no tiene ningún ingreso
     * activo. Es decir, solo si
     * el paciente no se encuentra actualmente ingresado en el hospital.
     * 
     * @param fechaIngreso         fecha en la que el paciente fue ingresado,
     *                             no acepta null,
     *                             solo se acepta valores permitidos
     * 
     * @param enfermedadesMentales lista de enfermedades mentales del paciente en
     *                             este ingreso,
     *                             solo se acepta valores permitido
     * 
     * @param discapacidades       marca si el paciente tiene o no discapacidad,
     *                             true si tiene, false no tiene
     * 
     * @throws NullPointerException     si 'fechaIngreso' se le pasa null
     * @throws IllegalArgumentException si a 'enfermedadesMentales' se le pasa una
     *                                  lista con algún valor no valido
     * @throws IllegalStateException    si se intenta crear un nuevo ingreso cuando
     *                                  el paciente ya tiene su último
     *                                  ingreso activo
     */
    public void crearIngreso(LocalDate fechaIngreso, List<String> enfermedadesMentales, boolean discapacidad) {

        // Si el paceinte tiene ingresos y el último ingreso del paciente está activo,
        // no se podra crear otro
        if (!expediente.isEmpty() && expediente.get(expediente.size() - 1).isActivo() == true) {
            throw new IllegalStateException(
                    "No se puede crear un ingreso, el paciente ya tiene su último ingreso activo.");
        }

        // En caso de que no tenga ingresos o su último ingreso no se un ingreso activo,
        // se crea uno.
        expediente.add(new Ingreso(fechaIngreso, enfermedadesMentales, discapacidad));
    }

    /**
     * Devuelve una lista actualizada de todos los pacientes creados en el sistema.
     * 
     * @return lista actualizada de todos los pacientes creados en el sistema
     */
    public static List<Paciente> getTodosLosPacientes() {
        return todosLosPacientes;
    }

    /**
     * Establece un nuevo nombre para el paciente.
     * 
     * @param nombre nombre del paciente, no acepta null ni cadena llena de espacios
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una cadena llena de
     *                                  espacios
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
     * Devuelve el nombre del paciente.
     * 
     * @return el nombre del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo apellido para el paciente.
     * 
     * @param apellido apellido del paciente, no acepta null ni cadena llena de
     *                 espacios
     * 
     * @throws NullPointerException     si por parametro se pasa null
     * @throws IllegalArgumentException si por parametro se pasa una cadena llena de
     *                                  espacios
     */
    public void setApellido(String apellido) {
        // Comprueba que el apellido se rellene y no sea una cadena llena de espacios.
        if (apellido == null) {
            throw new NullPointerException("Parametro 'apellido' no acepta null.");
        }
        if (apellido.isBlank()) {
            throw new IllegalArgumentException("Parametro 'apellido' no acepta una cadena de solo espacios.");
        }

        this.apellido = apellido;
    }

    /**
     * Devuelve el apellido del paciente.
     * 
     * @return el apellido del paciente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Devuelve la lista de ingresos del paciente.
     * 
     * @return la lista de ingresos del paciente
     */
    List<Ingreso> getExpediente() {
        return expediente;
    }

    /**
     * Permite al personal documentar el alta del último ingreso del paciente.
     * 
     * @param documentacion La documentación a añadir al alta.
     * @throws IllegalStateException si el paciente no tiene ingresos o si su último
     *                               ingreso no tiene un alta.
     */
    public void documentarAlta(String documentacion) {
        if (expediente.isEmpty()) {
            throw new IllegalStateException("El paciente no tiene ningún ingreso en su expediente.");
        }

        // Obtenemos el último ingreso del paciente
        Ingreso ultimoIngreso = expediente.get(expediente.size() - 1);

        // Verificamos que tenga un alta creada
        if (ultimoIngreso.getAlta() == null) {
            throw new IllegalStateException("El último ingreso del paciente todavía no tiene un alta médica asociada.");
        }

        // Guardamos la documentación en el alta
        ultimoIngreso.getAlta().setDocumentacion(documentacion);
    }

    /**
     * Permite al personal de salud registrar una ronda médica en el último ingreso
     * del paciente.
     * 
     * @throws IllegalStateException si el paciente no tiene ingresos.
     */
    public void registrarRondaMedica() {
        if (expediente.isEmpty()) {
            throw new IllegalStateException("El paciente no tiene ningún ingreso en su expediente.");
        }

        // Obtenemos el último ingreso del paciente
        Ingreso ultimoIngreso = expediente.get(expediente.size() - 1);

        // Registramos la ronda médica en el ingreso
        ultimoIngreso.setNuevaRondaMedicaDiaria();
    }

    /**
     * Devuelve una cadena con todos los datos del paciente.
     * 
     * Se muestran los datos según la convención de java para los métodos toString:
     * - NombreClase{campo1='valor1', campo2='valor2'}
     * 
     * @return una cadena con todos los atributos y sus valores
     */
    @Override
    public String toString() {
        return String.format(
                "Paciente{nombre='%s', apellido='%s', expediente=%s}",
                nombre,
                apellido,
                expediente);
    }
}
