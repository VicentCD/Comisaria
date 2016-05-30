package datos;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivosDAO {

    public String cargarPolicias(File archivo) {
        boolean existeID = false;
        int contador = 0;
        JDBCDAO jd = new JDBCDAO();
        PreparedStatement ps;
        ResultSet rs;
        String datos = "", nombre = "", numPlaca = "", departamento = "", foto = "";
        String insert = "INSERT INTO "
                + "policia (idPolicia, nombre, numPlaca, edad, departamento, foto)"
                + "VALUES (?,?,?,?,?,?)";
        String select = "SELECT idPolicia from policia";
        String text = "", nombres = "";
        Integer idPolicia = 0, edad = 0;
        String[] trozos;
        try (FileReader fr = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            while (br.readLine() != null) {
                trozos = br.readLine().split(",");
                idPolicia = Integer.valueOf(trozos[0]);
                nombre = trozos[1];
                numPlaca = trozos[2];
                edad = Integer.valueOf(trozos[3]);
                departamento = trozos[4];
                foto = trozos[5];

                ps = jd.CrearConexion().prepareStatement(select);
                rs = ps.executeQuery();
                //Comprobar que no existe el policia mirando todas las idPolicia 
                existeID = false;
                while (rs.next()) {
                    if (idPolicia == rs.getInt("idPolicia")) {
                        existeID = true;
                        contador++;
                        nombres = nombres + " " + nombre;
                    }
                }
                if (existeID != true) {

                    ps = jd.CrearConexion().prepareStatement(insert);

                    ps.setInt(1, idPolicia);
                    ps.setString(2, nombre);
                    ps.setString(3, numPlaca);
                    ps.setInt(4, edad);
                    ps.setString(5, departamento);
                    ps.setString(6, foto);
                    ps.executeUpdate();
                }

            }

        } catch (IOException | SQLException ex) {
            Logger.getLogger(ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (contador == 0) {
            text = "No se han insertado policías";
        } else if (contador == 1) {
            text = "El policía " + nombres + " ya estaba en la base de datos";
        } else {
            text = "Los policías " + nombres + " ya estaban insertados"
                    + "\n"+"No se han insertado "+ contador+ " policías";
        }
        
        

        return text;
    }
}
