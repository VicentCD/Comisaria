package modelo;

public class MultaTipo {

    private int id;
    private String descripcion;
    private double importe;
    private Tipo tipo;
    private int carnetpuntos;

    
    /**
     * Constructor MultaTipo
     * @param id
     * @param descripcion
     * @param importe
     * @param tipo
     * @param carnetpuntos 
     */
    public MultaTipo(int id, String descripcion, double importe, Tipo tipo, int carnetpuntos) {
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
        this.tipo = tipo;
        this.carnetpuntos = carnetpuntos;
    }

    public MultaTipo() {
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getCarnetpuntos() {
        return carnetpuntos;
    }

    public void setCarnetpuntos(int carnetpuntos) {
        this.carnetpuntos = carnetpuntos;
    }

    @Override
    public String toString() {
        return id + " - " + descripcion; 
    }
}
