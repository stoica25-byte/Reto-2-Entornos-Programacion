package proyectoreto.utilidad;

import java.util.List;
import java.util.Map;

/**
 * Esta es una clase de utilidad que contiene todas las constantes y listas de
 * valores validos
 * que se usan en general, en todo el sistema.
 * 
 * No habra instancias de está clase.
 * 
 * @author Wilson
 */
public final class ConstantesHospital {

    /**
     * Lista de las enfermedades mentales validas.
     */
    public final static List<String> ENFERMEDADES_MENTALES_VALIDAS = List.of(
            "Esquizofrenia",
            "TDAH",
            "Trastorno bipolar",
            "Trastorno obsesivo compulsivo",
            "Trastorno Psicótico",
            "Trastorno antisocial");

    /**
     * Lista de los tratamientos validos.
     */
    public final static List<String> TRATAMIENTOS_VALIDOS = List.of(
            "Analgésicos",
            "Antiinflamatorios",
            "Antibióticos",
            "Sueros",
            "Antidiarreicos",
            "Antipsicóticos",
            "Terapia conductual",
            "Estabilizadores del ánimo",
            "Antidepresivos",
            "Medicación anticonvulsiva");

    /**
     * Lista de las especialidades validas, ordenados de más importante a más
     * general.
     */
    public final static List<String> ESPECIALIDADES_VALIDAS = List.of(
            "Cuidados Intensivos",
            "Neurología",
            "Traumatología",
            "Rehabilitación",
            "Psiquiatría",
            "Medicina General");

    /**
     * Lista de las gravedades validas.
     */
    public final static List<String> GRAVEDADES_VALIDAS = List.of("Alto", "Medio", "Bajo");

    /**
     * Lista de cada enfermedad mental y discapacidad a que especialidad está
     * asociada.
     */
    public static final Map<String, String> ESPECIALIDAD_POR_CONDICION = Map.ofEntries(
            // Enfermedades mentales
            Map.entry("Esquizofrenia", "Psiquiatría"),
            Map.entry("TDAH", "Psiquiatría"),
            Map.entry("Trastorno bipolar", "Psiquiatría"),
            Map.entry("Trastorno obsesivo compulsivo", "Psiquiatría"),
            Map.entry("Trastorno Psicótico", "Psiquiatría"),
            Map.entry("Trastorno antisocial", "Psiquiatría"));
}
