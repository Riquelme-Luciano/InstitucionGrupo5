package model;

import controller.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Alumno;

public class AlumnoData {

    private Connection con = null;
    private Conexion conexion;

    public AlumnoData(Conexion conexion) {
        this.conexion = conexion;
    }

    public int insertarAlumno(Alumno alumno) {
        String instruccion = "INSERT INTO alumno(nombre,apellido,fechaNac,activo) VALUES (?,?,?,?)";
        this.con = conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            //hago la conversion para que me inserte fecha de tipo date.sql
            long d = alumno.getFechaNac().getTime();
            java.sql.Date fechaNacimiento = new java.sql.Date(d);
            ps.setDate(3, fechaNacimiento);
            //-------------
            ps.setBoolean(4, alumno.isActive());

            ps.executeUpdate(); //envio instruccion a la BD

            this.con.close();
            System.out.println("Alumno insertado con exito");
            return 1;

        } catch (Exception e) {
            System.out.println("Error al insertar alumno\n" + e);
            return 0;
        }
    }
    
    public int actualizarAlumno(Alumno alumno){
        String instruccion = "UPDATE alumno SET nombre=?, apellido=?, fechaNac=?, activo=? WHERE idAlumno=?";
        try {
            this.con = conexion.getConexion();
            
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            //conversion para ingresar date
            long d = alumno.getFechaNac().getTime();
            java.sql.Date fechaNacimiento = new java.sql.Date(d);
            ps.setDate(3, fechaNacimiento);
            ps.setBoolean(4, alumno.isActive());
            ps.setInt(5, alumno.getIdAlumno());
            
            ps.executeUpdate();
            
            this.con.close();
            return 1;
        } catch (Exception e) {
             System.out.println(e);
            return 0;
        }
    }
    
    public void eliminarAlumno(int id){
        String instruccion = "DELETE FROM alumno WHERE idAlumno=?";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1,id);
            ps.executeUpdate();
            this.con.close();
        } catch (Exception e) {
            System.out.println("Error al querer eliminar alumno en DAO");
        }
    }

    public List listar() {
        this.con = conexion.getConexion();
        List<Alumno> datos = new ArrayList<>();
        String instruccion = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(instruccion);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getDate(4));//convertir de date a LocalDate
                a.setActive(rs.getBoolean(5));
                datos.add(a);
            }
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Error al lista alumnos " + e);
        }

        return datos;
    }
    
//    public List buscar(){
//        
//    }
}
