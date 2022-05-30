package model;

import controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InscripcionData {

    private Connection con = null;
    private Conexion conexion;

    public InscripcionData(Conexion conexion) {
        this.conexion = conexion;
    }

    public List materiasDeAlumno(Alumno alumno) {
        List<Materia> materias = new ArrayList<>();
        String instruccion = "SELECT materia.idMateria,materia.nombre,materia.añoMateria,materia.activo "
                + "FROM inscripcion JOIN materia ON inscripcion.idMateria=materia.idMateria "
                + "WHERE inscripcion .idAlumno=?";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, alumno.getIdAlumno());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setYearMateria(rs.getInt(3));
                m.setActive(rs.getBoolean(4));
                materias.add(m);
            }
            this.con.close();
        } catch (Exception e) {
            System.out.println("Error al lista materias de este alumno en inscripcion data " + e);
        }

        return materias;
    }

    public List alumnosEnMateria(Materia materia) {
        List<Alumno> alumnos = new ArrayList<>();
        String instruccion = "SELECT alumno.idAlumno,alumno.nombre,alumno.apellido,alumno.fechaNac,alumno.activo "
                + "FROM inscripcion JOIN alumno ON inscripcion.idAlumno=alumno.idAlumno "
                + "WHERE inscripcion.idMateria=?";

        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, materia.getIdMateria());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Alumno a = new Alumno();
                a.setIdAlumno(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setFechaNac(rs.getDate(4));
                a.setActive(rs.getBoolean(5));
                alumnos.add(a);
            }

            this.con.close();

        } catch (Exception e) {
            System.out.println("Error al querer mostrar alumnos en esta materia" + e);
        }

        return alumnos;
    }

    public List materiasNoInscriptasAlumno(Alumno alumno) {
        String instruccion = "SELECT * FROM materia WHERE idMateria NOT IN (SELECT idMateria FROM inscripcion WHERE idAlumno = ?)";
        List<Materia> materias = new ArrayList<>();
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, alumno.getIdAlumno());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia m = new Materia();
                m.setIdMateria(rs.getInt(1));
                m.setNombre(rs.getString(2));
                m.setYearMateria(rs.getInt(3));
                m.setActive(rs.getBoolean(4));
                materias.add(m);
            }
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return materias;
    }

    public int inscribirAlumno(Alumno alumno, Materia materia) {
        String instruccion = "INSERT INTO inscripcion(idMateria,idAlumno) VALUES (?,?)";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, materia.getIdMateria());
            ps.setInt(2, alumno.getIdAlumno());

            ps.executeUpdate();
            this.con.close();
            System.out.println("Inscripcion completada");

            return 1;
        } catch (Exception e) {
            System.out.println("Error al querer realizar la inscripcion\n" + e);
            return 0;
        }
    }

    public void desinscribirAlumno(int idMateria, int idAlumno) {
        String instruccion = "DELETE FROM inscripcion WHERE idMateria=? AND idAlumno=?";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, idMateria);
            ps.setInt(2, idAlumno);
            ps.executeUpdate();
            this.con.close();
        } catch (Exception e) {
            System.out.println("Error al querer eliminar la inscripcion en data" + e);
        }
    }
    
    public int cargarNota(int idInscripcion, double nota){
        String instruccion = "UPDATE inscripcion SET nota = ? WHERE idInscripcion=?";
        
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setDouble(1,nota);
            ps.setInt(2, idInscripcion);
            
            ps.executeUpdate();
            
            this.con.close();
            return 1;
        } catch (Exception e) {
            System.out.println("Error al cargar nota en inscripcion data"+e);
            return 0;
        }
    }

    public List listarAlumnosActivos() {
        this.con = conexion.getConexion();
        List<Alumno> datos = new ArrayList<>();
        String instruccion = "SELECT * FROM alumno WHERE activo=1";
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
            System.out.println("Error al lista alumnos activos en inscripcion data " + e);
        }

        return datos;
    }

    public List listarMateriasActivas() {
        this.con = conexion.getConexion();
        List<Materia> datos = new ArrayList<>();
        String instruccion = "SELECT * FROM materia WHERE activo=1";
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
            System.out.println("Error al lista materias activas en inscripcion data " + e);
        }

        return datos;
    }
    
    public List inscripcionesDeAlumno(Alumno alumno) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String instruccion = "SELECT inscripcion.idInscripcion, inscripcion.idMateria,inscripcion.idAlumno, inscripcion.nota "
                + "FROM inscripcion JOIN materia ON inscripcion.idMateria=materia.idMateria "
                + "WHERE inscripcion.idAlumno=?";
        try {
            this.con = conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(instruccion);
            ps.setInt(1, alumno.getIdAlumno());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion i = new Inscripcion();
                i.setIdInscripcion(rs.getInt(1));
                System.out.println("lego");
                i.setMateria(buscarMateria(rs.getInt(2)));
                i.setAlumno(buscarAlumno(rs.getInt(3)));
                i.setNota(rs.getDouble(4));
                inscripciones.add(i);
            }
            this.con.close();
        } catch (SQLException e) {
            System.out.println("Error al listar inscripciones de este alumno en inscripcion data " + e);
        }

        return inscripciones;
    }
    
    public Alumno buscarAlumno(int id) {
        AlumnoData ad= new AlumnoData(conexion);
        return ad.buscarAlumno(id);
    }

    public Materia buscarMateria(int id) {
        MateriaData md= new MateriaData(conexion);
        return md.buscarMateria(id);
    }
    

}
