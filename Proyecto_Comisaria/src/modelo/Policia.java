package modelo;

public class Policia {
   private Integer idPolicia;
   private String nombre;
   private String numPlaca;
   private Integer edad;
   private String departamento;
   private String foto;

    public Policia() {
    }

   
   
    public Policia(Integer idPolicia, String nombre, String numPlaca, Integer edad, String departamento, String foto) {
        this.idPolicia = idPolicia;
        this.nombre = nombre;
        this.numPlaca = numPlaca;
        this.edad = edad;
        this.departamento = departamento;
        this.foto = foto;
    }

  

    public Integer getIdPolicia() {
        return idPolicia;
    }

    public void setIdPolicia(Integer idPolicia) {
        this.idPolicia = idPolicia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    

    @Override
    public String toString() {
        return nombre + " - " + numPlaca;
    }
   
   
}
