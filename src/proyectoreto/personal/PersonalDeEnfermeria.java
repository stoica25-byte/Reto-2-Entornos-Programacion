package proyectoreto.personal;

import java.io.Serializable;

/**
 * @author Jaime
 */
public class PersonalDeEnfermeria extends PersonalDeSalud  implements Serializable {

    public PersonalDeEnfermeria(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public String toString() {
        return "PersonalDeEnfermeria{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                '}';
    }
}
