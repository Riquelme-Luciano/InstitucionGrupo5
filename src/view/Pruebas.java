package view;

import controller.Conexion;
import java.util.ArrayList;
import java.util.List;
import model.Alumno;
import model.InscripcionData;
import model.Materia;
import model.MateriaData;

public class Pruebas {

    public static void main(String args[]) {
        Conexion c = new Conexion();

        InscripcionData d = new InscripcionData(c);

        List<Alumno> alumnos = d.listarAlumnosActivos();
        List<Materia> materias = d.listarMateriasActivas();
        
        System.out.println(d.materiasNoInscriptasAlumno(alumnos.get(0)));
        //System.out.println(d.alumnosEnMateria(materias.get(1)));
        
        //d.inscribirAlumno(alumnos.get(4), materias.get(3));
        //d.desinscribirAlumno(1);
        //d.cargarNota(alumnos.get(0), materias.get(1), 9);
        /*Materia m = new Materia("Ingles", 1, false);
        MateriaData data = new MateriaData(c);
                
        data.insertarMateria(m);
        //data.actualizarMateria(m);
        //data.eliminarAlumno(5);
        
        System.out.println(data.listar());
         */
    }
}
