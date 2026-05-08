package edu.grupo2.proyectoreto.personal;
/**
 * Clase que representa a un Médico en el sistema hospitalario.
 * Hereda de la clase abstracta PersonalDeSalud y gestiona la evaluación final del paciente
 *
 *@author Diana
 */
public class Medico extends PersonalDeSalud{
    /**
    * Constructor público por defecto (+)
    * Llama al constructor de la superclase PersonalDeSalud para inicializar
    * los atributos heredados (nombre y apellidos)
    */
    public Medico(){
        //Llamamos al constructor portected de la clase padre (PersonalDeSalud)
        super(nombre, primerApellido, segundoApellido);
    }
    /**
     * Asigna una cama específica a un paciente durante su ingreso.
     */
    public void asignarCamaPaciente(Paciente paciente, Cama cama) {
        // Aquí iría la lógica para buscar el ingreso activo y asignarle la cama
    }
    /**
     * Realiza la evaluación final y emite el alta médica del paciente.
     * Solo puede realizarse si el paciente tiene un ingreso activo y 
     * fue marcado como 'aptoEvaluacionFinal' en la ronda médica.
     */
    public void darAltaMedicaPaciente(Paciente paciente, String motivoAlta) {
        List<Ingreso> expediente = paciente.getExpediente();
        Ingreso ingresoActivo = null;

        for (Ingreso ingreso : expediente) {
            if (ingreso.isActivo()) {
                ingresoActivo = ingreso;
                break;
            }
        }
        if (ingresoActivo == null) {
            throw new IllegalStateException("El paciente no tiene un ingreso activo.");
        }

        // Crea el objeto Alta y lo guarda en el ingreso (El Administrativo lo documentará después)
        Alta nuevaAlta = new Alta(LocalDate.now(), motivoAlta, this);
        ingresoActivo.setAlta(nuevaAlta);
        
        // Opcional: Marcar el ingreso como inactivo al dar el alta
        // ingresoActivo.setActivo(false);
    }
    /**
    * Devuelve una cadena con los datos del médico
    *
    * Se muestran los datos según la convención de java para los métodos toString:
    * - NombreClase{ campo1='valor1', campo2='valor2'}
    *
    * @return una cadena con todos los atributos y sus valores
    *
    * @param nombre  nombre del epleado, no acepta null ni cadena llena de espacios
    * @param apellido  apellido del empleado, no acepta null ni cadena llena de espacios
    *
    * @throws NullPointerException  si 'nombre' o 'apellido' se les pasa null
    * @throws IllegalArgumentException  si 'nombre' o 'apellido' se les pasa una cadena llena de espacios
    */
    @override
    public String toString(){
        return String.format(
            "Medico{nombre='%s', primerApellido='%s', segundoApellido=%s}",
            getNombre(),
            getPrimerApellido(),
            getSegundoApellido()
        );
    }
}
