
package controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
   private String db = "universidad2";
   private String url = "jdbc:mysql://127.0.0.1/"+db;
   private String user = "root";
   private String pass = "";
   
   public Conexion(){}
   
   public Connection getConexion(){
       Connection link = null;
       
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           link=DriverManager.getConnection(this.url,this.user,this.pass);
           System.out.println("Conexion exitosa");
       } catch ( SQLException | ClassNotFoundException e) {
           System.out.println("Error al conectar con la base de datos\n"+e);
       }
       return link;
   }
}
