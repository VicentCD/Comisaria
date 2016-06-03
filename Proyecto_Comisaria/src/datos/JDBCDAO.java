package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCDAO {

    private Connection conexion;

    public JDBCDAO() {
        this.CrearConexion();
    }

    public Connection CrearConexion() {
        try {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/comisaria", "root", "root");

        } catch (SQLException e) {
            //LabelConexion.setText(e.getMessage() + " -- " + e.getErrorCode());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public int introducirMulta(Multa m) throws SQLException {
        PreparedStatement ps;
        int filasafectadas;
        ps = conexion.prepareStatement("INSERT INTO multas VALUES (null,?,?,?,?,?,?)");
        ps.setString(1, m.getDescripcion());
        ps.setTimestamp(2, m.getFecha());
        ps.setDouble(3, m.getImporte());
        ps.setInt(4, m.getIdPolicia());
        ps.setString(5, m.getNifInfractor());
        ps.setInt(6, m.getIdTipo());

        filasafectadas = ps.executeUpdate();
        return filasafectadas;
    }

    public String recogerUltimaMulta() {
        String ultimo = "", sql = "SELECT max(id) FROM multas";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            ultimo = rs.getString("max(id)");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }
        

    public String recogerUltimoPolicia() {
        String ultimo = "", sql = "SELECT max(idPolicia) FROM policia";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            ultimo = rs.getString("max(idPolicia)");
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }

    public List<MultaTipo> recogerMultasTipo() throws SQLException {
        List<MultaTipo> listaTipo = new ArrayList<>();
        Integer idTipo;
        String descripcion;
        Double importe;
        String sql = "SELECT id, descripcion, importe FROM multastipo ORDER BY id";
        PreparedStatement psSelectPolicia = conexion.prepareStatement(sql);

        ResultSet rs = psSelectPolicia.executeQuery();

        while (rs.next()) {
            MultaTipo mt = new MultaTipo();
            idTipo = rs.getInt("id");
            descripcion = rs.getString("descripcion");
            importe = rs.getDouble("importe");
            mt.setId(idTipo);
            mt.setDescripcion(descripcion);
            mt.setImporte(importe);

            listaTipo.add(mt);
        }
        return listaTipo;
    }

    public List<Policia> MostrarPolicias(String ordenacion) {
        List<Policia> listaPolicias = new ArrayList<>();
        int idPolicia, edad;
        String nombre, numPlaca, departamento, foto, sql = "SELECT * FROM policia ORDER BY " + ordenacion;
        try {

            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                idPolicia = rs.getInt("idPolicia");
                nombre = rs.getString("nombre");
                numPlaca = rs.getString("numPlaca");
                edad = rs.getInt("edad");
                departamento = rs.getString("departamento");
                foto = rs.getString("foto");
                Policia p = new Policia(idPolicia, nombre, numPlaca, edad, departamento, foto);
                listaPolicias.add(p);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
//            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPolicias;
    }

    public boolean BorrarPolicia(Integer idPolicia) {
        boolean borrado = false;
        String borrar = "DELETE FROM policia where idPolicia = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(borrar);
            ps.setInt(1, idPolicia);
            if (ps.executeUpdate() == 1) {
                borrado = true;
            }
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1451) {
                borrado = false;
            }

        }

        return borrado;
    }

    public void InsertarPolicias(Integer idPolicia, String nombre, String numPlaca, Integer edad, String departamento, String foto) throws SQLException {
        PreparedStatement ps;
        String insert = "INSERT INTO "
                + "policia (idPolicia, nombre, numPlaca, edad, departamento, foto)"
                + "VALUES (?,?,?,?,?,?)";

        ps = conexion.prepareStatement(insert);
        ps.setInt(1, idPolicia);
        ps.setString(2, nombre);
        ps.setString(3, numPlaca);
        ps.setInt(4, edad);
        ps.setString(5, departamento);
        ps.setString(6, foto);
        ps.executeUpdate();

    }

    public int ActualizarPolicias(Policia p) throws SQLException {
        PreparedStatement ps;
        String update = "UPDATE policia "
                + "SET nombre=?, numplaca=?, edad=?, departamento=?, foto=?"
                + "WHERE idpolicia = " + p.getIdPolicia().toString();
        ps = conexion.prepareStatement(update);
        ps.setString(1, p.getNombre());
        ps.setString(2, p.getNumPlaca());
        ps.setInt(3, p.getEdad());
        ps.setString(4, p.getDepartamento());
        ps.setString(5, p.getFoto());
        return ps.executeUpdate();
    }
}
