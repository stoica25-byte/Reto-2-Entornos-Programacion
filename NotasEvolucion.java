public class NotaEvolucion {

    private String fecha;
    private String observacion;

    public NotaEvolucion(String fecha, String observacion) {
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "NotaEvolucion{" +
                "fecha='" + fecha + '\'' +
                ", observacion='" + observacion + '\'' +
                '}';
    }
}
