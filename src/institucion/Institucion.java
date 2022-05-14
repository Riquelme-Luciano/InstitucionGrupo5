
package institucion;

//import institucion.controlador.Conexion;
//import institucion.controlador.InscripcionData;
import institucion.modelo.Alumno;
import institucion.modelo.Inscripcion;
import institucion.modelo.Materia;
import java.time.LocalDate;
//import javax.swing.JOptionPane;

public class Institucion {

    public static void main(String[] args) {
        Alumno a1 = new Alumno ("Lucero", "carlos", LocalDate.of(1990,3,4), true);
        Alumno a2 = new Alumno("Saez","Juan",LocalDate.of(1980,02,22),false);
        Alumno a3 = new Alumno("Ortiz","Pedro",LocalDate.of(1995,02,22),true);
        Alumno a4 = new Alumno("martinez","Omar",LocalDate.of(1995,02,22),true);
        
        Materia m1 = new Materia(01,"Matematica", 1, true);
        Materia m2 = new Materia(02,"Logica",1,true);
        Materia m3 = new Materia("Laboratorio 1",1,true);
        m3.setIdMateria(03);
        Materia m4 = new Materia("Programacion Web2",2,false);
        m4.setIdMateria(04);
        m4.setActivo(true);
        
        Inscripcion i1 = new Inscripcion (a1, m1, 8.50);
        i1.setIdInscripcion(1);
        i1.setIdMateria(m3);
        i1.setIdAlumno(a4);
        i1.setNota(5);
        
        
        Inscripcion i2 = new Inscripcion (a2, m3, 4);
        a2.setActivo(true);
        i2.setIdInscripcion(2);
        i2.setNota(9);
        
        Inscripcion i3 = new Inscripcion (a3, m2, 8);
        i3.setIdInscripcion(3);
        
        Inscripcion i4 = new Inscripcion (a4, m4, 8);
        i4.setIdInscripcion(4);
        i4.setNota(7);
        
        System.out.println("Alumnos:\n"+a1+"\n"+a2+"\n"+a3+"\n"+a4);
        System.out.println();
        System.out.println("Materias:\n"+m1+"\n"+m2+"\n"+m3+"\n"+m4);
        System.out.println();
        System.out.println("Inscripciones:\n"+i1+"\n"+i2+"\n"+i3+"\n"+i4);
    
    }
}

/*
   Conexion conexion;
        Alumno a = new Alumno(4,"Mario", "Rojas", LocalDate.of(1974, 02, 02), true);
        Materia m = new Materia(3,  "Ingles", 2, true);
        
        Inscripcion insc = new Inscripcion(a, m, 10);
        try {
            conexion = new Conexion();
            InscripcionData id = new InscripcionData(conexion);
            id.inscribir(insc);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la Conexion"+e.getMessage());
        }
*/



/*
        try {
            Conexion conexion= new Conexion(); // Permite la interaccion de las clases data con la base de datos
            AlumnoData alumnoData= new AlumnoData(conexion);
            Alumno alumno= new Alumno("Aldoñas","Nepumoceno",LocalDate.of(1989,11,31),false);
            
            
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Falla en la Conexion. Intentelo mas tarde"+e.getMessage());
            
        }
 */