package proyectoreto.personal;

/**
 * @author Jaime
 */
public class PersonalDeEnfermeria extends PersonalDeSalud {

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
