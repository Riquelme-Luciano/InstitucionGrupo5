package institucion.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {
    private String url="jdbc:mysql://localhost/institucion"; 
    private String usuario="root"; 
    private String password="";

    private Connection conexion; 
    
   
    public Conexion() { 
        try {
            Class.forName("org.mariadb.jdbc.Driver"); 
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error de Conexion");
        }
    }
    
    public Conexion(String url, String usuario, String password) {
        try {
            this.url = url;
            this.usuario = usuario;
            this.password = password;
            
            
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Connection getConexion() throws SQLException{
        if(conexion == null) {
                  
            conexion = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return conexion;
    }
}

/*

 public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

       
        Class.forName("org.mariadb.jdbc.Driver");

    }
*/

