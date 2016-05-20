package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;
import java.sql.Date;
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

    public boolean introducirMulta(Multa m) throws SQLException {
        boolean comprobacion = false;
        PreparedStatement ps;
        ResultSet rs;
        ps = conexion.prepareStatement("INSERT INTO multas values ('?', '?', '?', '?', '?', '?')");
        ps.setString(1, m.getDescripcion());
        java.sql.Date fechaSql = new java.sql.Date(m.getFecha().getTime());
        ps.setDate(2, fechaSql);
        ps.setDouble(3, m.getImporte());
        ps.setInt(4, m.getIdPolicia());
        ps.setString(5, m.getNifInfractor());
        ps.setInt(6, m.getIdTipo());
        rs = ps.executeQuery();
        comprobacion = true;
        return comprobacion;
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

    public List<MultaTipo> recogerMultasTipo() {
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = conexion.prepareStatement("SELECT * FROM multastipo");
            rs = ps.executeQuery();
            while (rs.next()) {
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(JDBCDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
