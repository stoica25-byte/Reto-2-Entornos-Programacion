public class Traslado {

    private String hospitalDestino;
    private String motivo;

    public Traslado(String hospitalDestino, String motivo) {
        this.hospitalDestino = hospitalDestino;
        this.motivo = motivo;
    }

    public String getHospitalDestino() {
        return hospitalDestino;
    }

    public void setHospitalDestino(String hospitalDestino) {
        this.hospitalDestino = hospitalDestino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Traslado{" +
                "hospitalDestino='" + hospitalDestino + '\'' +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
