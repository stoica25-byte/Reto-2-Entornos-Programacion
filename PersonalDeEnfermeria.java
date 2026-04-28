public class PersonalDeEnfermeria extends Personal {

    public PersonalDeEnfermeria(String nombre, String primerApellido, String segundoApellido) {
        super(nombre, primerApellido, segundoApellido);
    }

    @Override
    public String toString() {
        return "PersonalDeEnfermeria{" +
                "nombre='" + getNombre() + '\'' +
                ", primerApellido='" + getPrimerApellido() + '\'' +
                ", segundoApellido='" + getSegundoApellido() + '\'' +
                '}';
    }
}
