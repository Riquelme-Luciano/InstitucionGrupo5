package institucion.controlador;

import institucion.modelo.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MateriaData {
    private Connection con=null;
    
    public MateriaData(Conexion conexion) {
        try {
            con=conexion.getConexion();
            
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexion");
        }
    }
    
    public void insertarMateria(Materia materia) {
        String sql="INSERT INTO materia(nombre,añoMateria,activo) VALUES (?,?,?,?)";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,materia.getNombre());
            ps.setInt(2,materia.getAnioMateria());
            ps.setInt(3,materia.isActivo()?1:0);
            
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
                JOptionPane.showMessageDialog(null,"No se genero el id de la materia");
                ps.close(); //No iria tambien al finalizar el if?
            }
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion desde insertar materia");
        }
    }
    
    public Materia buscarMateria (int id) {
        Materia materia = new Materia();
        String sql = "SELECT nombre,anioMateria FROM alumno WHERE idMateria=? AND activo = 1";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                materia.setIdMateria(id);
                materia.setNombre(rs.getString("nombre"));
                //materia.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                
                JOptionPane.showMessageDialog(null, "Materia añadida exitosamente");
            }else {
                JOptionPane.showMessageDialog(null,"No existe una materia asociada a la id");
            }
            ps.close();
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null,"Error de conexion con base de datos");
        }
            
        return materia;
    }


    
    public void modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?, anioMateria = ?, activo = ? WHERE  idAlumno = ? AND activo = 1";
        PreparedStatement ps  = null;   
          
        try{
            ps=con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(5, materia.getAnioMateria());
            ps.setBoolean(4, materia.isActivo());
            
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Modificado Exitosamente");
        
            } 
            catch(SQLException ex){   
                JOptionPane.showMessageDialog(null, "No pudo modificar");
        }
    }
    
    public void eliminarMateria(int id) {
                    
        try{
            String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, " Se eliminó la materia.");
            ps.close();

        }catch (SQLException e) {

            JOptionPane.showMessageDialog(null, " No se pudo eliminar el materia");
        }
    }
    
    public java.util.List<Materia> listarMateria() {

        java.util.List<Materia> materias = new ArrayList<>();
        try {
           String sql = "SELECT * FROM materia WHERE activo = 1 ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();

                materia.setIdMateria(rs.getInt(1));
                materia.setNombre(rs.getString(2));
                //materia.setNombre(rs.getString(3));
                //materia.setFechaNac(rs.getDate(4).toLocalDate());
                materia.setActivo(rs.getBoolean(5));
                materias.add(materia);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error en la busqueda. ");
        }
        return materias;
        }
    

}

    
    
    
    
    
    
    
    

