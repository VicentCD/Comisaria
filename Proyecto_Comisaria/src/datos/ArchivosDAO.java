package datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArchivosDAO {
    
    
    public boolean cargarDatos(File archivo) {
        boolean comprobacion = false;
        JDBCDAO jd = new JDBCDAO();
        PreparedStatement ps;
        ResultSet rs;
        String linea, datos, nombre, numPlaca, departamento, foto;
        int idPolicia, edad; 
        String [] trozos;
        try (FileReader fr = new FileReader(archivo)) {
            BufferedReader br = new BufferedReader(fr);
            
            while ((linea = br.readLine())!=null){
                trozos = linea.split(",");
                //COMPROBAR SI NO EXISTE EL POLICÍA SACANDO
                //DE LA BASE DE DATOS TODAS LAS idPolicia Y 
                //COMPARANDO. SI NO EXISTE, HAZ ESTO.
                idPolicia = Integer.valueOf(trozos[0]);
                nombre = trozos [1];
                numPlaca= trozos [2];
                edad = Integer.valueOf(trozos[3]);
                departamento = trozos[4];
                foto = trozos[5];
                String sql = "INSERT INTO "
                        + "policia (idPolicia,nombre,numPlaca,edad,departamento,foto)"
                        + "VALUES (?,?,?,?,?,?,?)";
                ps= jd.CrearConexion().prepareStatement(sql);
                
                ps.setInt(1, idPolicia);
                ps.setString(2, nombre);
                ps.setString(3, numPlaca);
                ps.setInt(3, edad);
                ps.setString(4, departamento);
                ps.setString(5, foto);
            
            
            }
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ArchivosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comprobacion;
    }
}
