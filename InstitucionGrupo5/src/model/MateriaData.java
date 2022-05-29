package model;

import controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaData {
    
    private Connection con = null;
    private Conexion conexion;
    
    public MateriaData(Conexion conexion){
        this.conexion = conexion;
    }
    
    public Materia buscarMateria (int id) {
        Materia materia = new Materia();
        String sql = "SELECT idMateria,nombre,añoMateria FROM materia WHERE idMateria = ? AND activo = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setYearMateria(rs.getInt("añoMateria"));

            }
            ps.close();
        } catch (SQLException e) {
              System.out.println("Error de conexion con base de datos");
        }

        return materia;
    }
    
    public int insertarMateria(Materia materia) {
        String instruccion = "INSERT INTO materia(nombre,añoMateria,activo) VALUES (?,?,?)";
        this.con = conexion.getConexion();
        try {
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getYearMateria());
            ps.setBoolean(3, materia.isActive());

            ps.executeUpdate(); //envio instruccion a la BD

            this.con.close();
            System.out.println("Materia insertada con exito");
            return 1;

        } catch (Exception e) {
            System.out.println("Error al insertar materia\n" + e);
            return 0;
        }
    }
    
    public int actualizarMateria(Materia materia){
        String instruccion = "UPDATE materia SET nombre=?, añoMateria=?, activo=? WHERE idMateria=?";
        try {
            this.con = conexion.getConexion();
            
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getYearMateria());
            ps.setBoolean(3, materia.isActive());
            ps.setInt(4, materia.getIdMateria());
            
            ps.executeUpdate();
            
            this.con.close();
            return 1;
        } catch (Exception e) {
             System.out.println("Error al actualizar materia"+e);
            return 0;
        }
    }
    
    public void eliminarMateria(int id){
        String instruccion = "DELETE FROM materia WHERE idMateria=?";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1,id);
            ps.executeUpdate();
            this.con.close();
        } catch (Exception e) {
            System.out.println("Error al querer eliminar materia en data");
        }
    }
    
    public List listar() {
        this.con = conexion.getConexion();
        List<Materia> datos = new ArrayList<>();
        String instruccion = "SELECT * FROM materia";
        try {
            PreparedStatement ps = con.prepareStatement(instruccion);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
                Materia a = new Materia();
                a.setIdMateria(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setYearMateria(rs.getInt(3));
                a.setActive(rs.getBoolean(4));
                datos.add(a);
            }
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Error al lista materias en data " + e);
        }

        return datos;
    }
}
