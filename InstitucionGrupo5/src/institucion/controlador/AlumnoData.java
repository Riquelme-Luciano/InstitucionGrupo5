package institucion.controlador;

import institucion.modelo.Alumno;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

public class AlumnoData {
    private Connection con = null;
    
    
    public AlumnoData(Conexion conexion) {
        try {
            con = conexion.getConexion();
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conecxion");
        }
    }

    public void guardarAlumno(Alumno alumno){
    
    String sql="INSERT INTO alumno (nombre, apellido, fechaNac, activo) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDate(3, Date.valueOf(alumno.getFechaNac()));//localDate a Date
            ps.setInt(4, alumno.isActivo()?1:0); // if reducido
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
                JOptionPane.showMessageDialog(null, rs);
            }
            else    
                JOptionPane.showMessageDialog(null, "El alumno no fue añadido");
            
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error de conexion desde insertar alumno " + ex);
        }
    
    }
    
    public Alumno buscarAlumno(int id) {
        Alumno alumno = new Alumno();
        String sql = "SELECT apellido, nombre, fechaNac FROM alumno WHERE idAlumno=? AND activo = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql); // Tener el string con la sentencia sql
            ps.setInt(1, id); // seteo al sql el parametro dinamico el id
            ResultSet rs = ps.executeQuery(); 
            
            if (rs.next()){
                alumno.setIdAlumno(id);
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                
                JOptionPane.showMessageDialog(null, "Alumno añadido exitosamente");
            }else {
                JOptionPane.showMessageDialog(null,"No hay nadie con ese id");
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error de conexion con base de datos");
        }
            
        return alumno;
    }


    
    public void modificarAlumno(Alumno alumno) {
        String sql = "UPDATE alumno SET apellido = ?, nombre = ?, fechaNac = ?, activo = ? WHERE  idAlumno = ? AND activo = 1";
        PreparedStatement ps  = null;   
          
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, alumno.getApellido());
            ps.setString(2, alumno.getNombre());
            ps.setDate(3, Date.valueOf(alumno.getFechaNac()));
            ps.setBoolean(4, alumno.isActivo());
            ps.setInt(5, alumno.getIdAlumno());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Modificado Exitosamente");
        
            } 
            catch(SQLException ex){   
                JOptionPane.showMessageDialog(null, "No pudo modificar");
        }
    }
    
    public void eliminarAlumno(int id) {
                    
        try{                                                                   // el borrado va ser logico
            String sql = "UPDATE alumno SET activo = 0 WHERE id_alumno = ? "; // no uso delete porque si el alumno esta en una relacion con inscripcion, no lo pordria borrar
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();  // se usa en sentencia que no son select 
            JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            ps.close();

        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " No se pudo eliminar el alumno");
        }
    }
    
    public List<Alumno> listarAlumnos() {   

        List<Alumno> alumnos = new ArrayList<>();
        try {
           String sql = "SELECT * FROM alumno WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); // devuelve las filas en un resultSet cuando haces un select
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setIdAlumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnos.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la busqueda. ");
        }
        return alumnos;
    }
}








/* 
Jorge Zoom
public void eliminarAlumno(Alumno alumno) {
                    
        try{
            String sql = "UPDATE alumno SET activo = 0 WHERE id_alumno = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
            ps.close();

        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " No se pudo eliminar el alumno");
        }
    }
Caro Zepeda Zoom 
public List<Alumno> listarAlumnos() {

        List<Alumno> alumnos = new ArrayList<>();
        try {
            sql = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setId_alumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnos.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la busqueda. ");
        }
        return alumnos;
    }

    public List<Alumno> listarAlumnos() {

        List<Alumno> alumnos = new ArrayList<>();
        try {
            sql = "SELECT * FROM alumno";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alumno = new Alumno();

                alumno.setId_alumno(rs.getInt(1));
                alumno.setApellido(rs.getString(2));
                alumno.setNombre(rs.getString(3));
                alumno.setFechaNac(rs.getDate(4).toLocalDate());
                alumno.setActivo(rs.getBoolean(5));
                alumnos.add(alumno);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la busqueda. ");
        }
        return alumnos;
    }
*/

   
