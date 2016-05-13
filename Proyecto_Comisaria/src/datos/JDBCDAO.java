package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.*;

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
        
        return comprobacion;
    }

}
