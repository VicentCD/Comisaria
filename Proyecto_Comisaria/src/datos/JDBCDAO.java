package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    public boolean actualizacionPolicia(Policia p) throws SQLException {
        boolean comprobacion = false;
        String update = "UPDATE table SET column1=value WHERE ";
        PreparedStatement ps;
        ResultSet rs;
        ps = conexion.prepareStatement(update);

        return comprobacion;
    }

    public String recogerUltimo(String sql, String campo) {
        String ultimo = "";
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.last();
            ultimo = rs.getString(campo);
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
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaPolicias;
    }
    
    public boolean BorrarPolicia(int idPolicia){
        boolean borrado = false;
        String borrar ="DELETE FROM policia where idPolicia = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(borrar);
            ps.setInt(1, idPolicia);
            ps.executeUpdate();
            borrado = true;
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return borrado;
    }
    
}
