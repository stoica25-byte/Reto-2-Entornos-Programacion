package proyectoreto;

import java.io.*;
import java.util.*;

import proyectoreto.paciente.Paciente;
import proyectoreto.personal.Medico;
import proyectoreto.personal.PersonalAdministrativo;
import proyectoreto.personal.PersonalDeEnfermeria;
import proyectoreto.unidad.Unidad;
import proyectoreto.utilidad.ConstantesHospital;
import proyectoreto.utilidad.Tiempo;

/**
 * @author Wilson
 */
public class GestionHospital {

    private static final String RUTA = "datos_sistema/hospital.dat";

    private static Medico medico;
    private static PersonalDeEnfermeria enfermero;
    private static PersonalAdministrativo administrativo;
    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Unidad> unidades = new ArrayList<>();

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        File archivo = new File(RUTA);

        try {
            new File("datos_sistema").mkdirs();
            archivo.createNewFile();

            if (archivo.length() == 0) {
                // ── Primera ejecución: generar datos iniciales ──

                medico = new Medico("Carlos", "García");
                enfermero = new PersonalDeEnfermeria("Laura", "Martínez");
                administrativo = new PersonalAdministrativo("Pedro", "López");

                unidades.add(new Unidad("Unidad de Psiquiatría", 100.0, "Psiquiatría"));
                unidades.add(new Unidad("Unidad de Rehabilitación", 100.0, "Rehabilitación"));
                unidades.add(new Unidad("Unidad de Medicina General", 100.0, "Medicina General"));

                String[] nombres = { "Ana", "Luis", "María", "José", "Elena", "Pablo", "Carmen",
                        "David", "Sara", "Miguel", "Lucía", "Javier", "Marta", "Sergio",
                        "Alba", "Rubén", "Nuria", "Diego", "Patricia", "Álvaro" };
                String[] apellidos = { "Rodríguez", "González", "Fernández", "López", "Martínez",
                        "Sánchez", "Pérez", "Gómez", "Ruiz", "Díaz", "Torres", "Jiménez",
                        "Moreno", "Álvarez", "Romero", "Navarro", "Domínguez", "Gil",
                        "Ramos", "Vázquez" };

                Random rnd = new Random();
                List<String> todasEnfermedades = ConstantesHospital.ENFERMEDADES_MENTALES_VALIDAS;

                for (int i = 0; i < 20; i++) {
                    Paciente p = new Paciente(nombres[i], apellidos[i]);

                    List<String> pool = new ArrayList<>(todasEnfermedades);
                    List<String> enfermedadesDelPaciente = new ArrayList<>();
                    int cantidad = rnd.nextInt(3);
                    for (int j = 0; j < cantidad; j++) {
                        enfermedadesDelPaciente.add(pool.remove(rnd.nextInt(pool.size())));
                    }

                    p.crearIngreso(Tiempo.getFechaActual(), enfermedadesDelPaciente, rnd.nextBoolean());
                    pacientes.add(p);
                }

                guardar();

            } else {
                // ── Ejecuciones siguientes: leer del archivo ──

                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
                medico = (Medico) ois.readObject();
                enfermero = (PersonalDeEnfermeria) ois.readObject();
                administrativo = (PersonalAdministrativo) ois.readObject();
                pacientes = (List<Paciente>) ois.readObject();
                unidades = (List<Unidad>) ois.readObject();
                ois.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el sistema: " + e.getMessage());
        }
    }

    public static void guardar() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA));
            oos.writeObject(medico);
            oos.writeObject(enfermero);
            oos.writeObject(administrativo);
            oos.writeObject(pacientes);
            oos.writeObject(unidades);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }
}