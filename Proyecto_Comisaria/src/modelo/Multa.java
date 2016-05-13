package modelo;
import java.util.Date;

public class Multa {
    private int id;
    private String descripcion;
    private Date fecha;
    private double importe;
    private int idPolicia;
    private String nifInfractor;
    private int idTipo;

    public Multa(int id, String descripcion, String fecha, double importe, int idPolicia, String nifInfractor, int idTipo) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.importe = importe;
        this.idPolicia = idPolicia;
        this.nifInfractor = nifInfractor;
        this.idTipo = idTipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
