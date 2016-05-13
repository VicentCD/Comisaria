package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;
import java.sql.Date;

public class JDBCDAO {

    private Connection conexion;

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
        ps = conexion.prepareStatement("INSERT INTO multas values ('?', '?', '?', '?', '?', '?', '?')");
        ps.setInt(1, m.getId());
        ps.setString(2, m.getDescripcion()) ;
        ps.setDate(3, m.getFecha());
        ps.setDouble(4, m.getImporte());
        ps.setInt(5, m.getIdPolicia());
        ps.setString(6, m.getNifInfractor());
        ps.setInt(7, m.getIdTipo());
        rs= ps.executeQuery();
        comprobacion=true;
        return comprobacion;
    }

}
