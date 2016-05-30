package modelo;

import java.sql.Timestamp;

public class Multa {

    private String descripcion;
    private Timestamp fecha;
    private double importe;
    private int idPolicia;
    private String nifInfractor;
    private int idTipo;

    public Multa(String descripcion, Timestamp fecha, double importe, int idPolicia, String nifInfractor, int idTipo) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.importe = importe;
        this.idPolicia = idPolicia;
        this.nifInfractor = nifInfractor;
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getIdPolicia() {
        return idPolicia;
    }

    public void setIdPolicia(int idPolicia) {
        this.idPolicia = idPolicia;
    }

    public String getNifInfractor() {
        return nifInfractor;
    }

    public void setNifInfractor(String nifInfractor) {
        this.nifInfractor = nifInfractor;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

}
