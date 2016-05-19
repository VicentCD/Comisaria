package modelo;
import java.util.Date;

public class Multa {
    private String descripcion;
    private Date fecha;
    private int importe;
    private int idPolicia;
    private String nifInfractor;
    private int idTipo;

    public Multa(String descripcion, Date fecha, int importe, int idPolicia, String nifInfractor, int idTipo) {
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

    public Date getFecha() {
        java.util.Date utilDate = new java.util.Date();
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(int importe) {
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
