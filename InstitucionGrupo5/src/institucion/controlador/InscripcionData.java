package institucion.controlador;

import institucion.modelo.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class InscripcionData {
    private Connection con=null;
    
    public InscripcionData(Conexion conexion) {
        try {
            con=conexion.getConexion();
        } catch(SQLException e) {
            
            JOptionPane.showMessageDialog(null,"Error en la  conexion");
        }
    }
    
    //Para poder isncribir nesecito el id de alumno y materia.
    public void inscribir(Inscripcion insc) {
        String sql="INSERT INTO inscripcion (idMateria,idAlumno,nota) VALUES (?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, insc.getIdMateria().getIdMateria()); //Inscripcion -> Materia -> id
            ps.setInt(2,insc.getIdAlumno().getIdAlumno()); // Inscripcion -> Alumno -> id
            ps.setDouble(3,insc.getNota()); //Inscripcion -> nota
            ps.executeUpdate(); 
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Alumno Inscripto ");
            } else
                JOptionPane.showMessageDialog(null, "Error en la inscripcion");
                 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexion ");
            
        }
    }
    
}

