package edu.grupo2.proyectoreto.personal;
import edu.grupo2.proyectoreto.paciente.Paciente;
import edu.grupo2.proyectoreto.paciente.Alta;

/**
 * Clase que representa al personal administrativo del hospital.
 * Hereda de la clase base Personal y se encarga de las gestiones 
 * burocráticas, asignación de ubicaciones y documentación de altas.
 *
 * @author Alex
 * @version 1.0 (28/04/2026)
 */
public class PersonalAdministrativo extends Personal {
    
    /**
     * Constructor público por defecto (+).
     * Invoca al constructor de la superclase Personal para inicializar 
     * los atributos heredados (nombre y apellidos).
     */
    public PersonalAdministrativo(){
        super();
    }
    /**
     * Realiza la gestión documental del alta de un paciente.
     * Este método actúa como puente entre el administrativo y el objeto Alta del paciente.
     * * @param paciente El paciente cuyo alta se va a documentar.
     * @param documentacion Texto con la información administrativa del alta.
     * @throws IllegalArgumentException si el paciente o el texto son nulos.
     * @throws IllegalStateException si el paciente no tiene un proceso de alta iniciado.
     */
    public void documentacionAltaPaciente(Paciente paciente, String documentacion){
        if (paciente == null){
            throw new IllegalArgumentException("Se requiere un paciente válido para realizar la documentación.");

        }

        Alta alta = paciente.getUltimoIngreso().getAlta(); //falta por hacer los metodos en la clase paciente//

        if (alta == null) {
            throw new IllegalStateException("No se puede documentar: El paciente no tiene un registro de alta activo.");
        }

        // Llamamos al método que programamos en la clase Alta
        alta.documentacionAltaPaciente(this, documentacion);
    }
}
