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

    public boolean cargarPolicias(File archivo) {
        boolean comprobacion = false, existeID = false;
        JDBCDAO jd = new JDBCDAO();
        PreparedStatement ps;
        ResultSet rs;
        String datos = "", nombre = "", numPlaca = "", departamento = "", foto = "";
        String insert = "INSERT INTO "
                + "policia (idPolicia, nombre, numPlaca, edad, departamento, foto)"
                + "VALUES (?,?,?,?,?,?)";
        String select = "SELECT idPolicia from policia";
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
                comprobacion = true;
            }

        } catch (IOException | SQLException ex) {
            Logger.getLogger(ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return comprobacion;
    }
}
