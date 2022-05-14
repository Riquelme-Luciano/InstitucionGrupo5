
package institucion.modelo;


public class Inscripcion {
    private int idInscripcion;
    private Alumno idAlumno;
    private Materia idMateria;
    private double nota;

    public Inscripcion() {}
    
    public Inscripcion(int idInscripcion, Alumno idAlumno, Materia idMateria, double nota) {
        this.idInscripcion = idInscripcion;
        this.idMateria = idMateria;
        this.idAlumno = idAlumno;
        this.nota = nota;
    }

    public Inscripcion(Alumno idAlumno, Materia idMateria, double nota) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }  
    
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return idInscripcion + ")"+idAlumno.getNombre()+" "+idAlumno.getApellido()+" Inscripto: "+idMateria.getNombre()+ " Nota Final=" + nota +" Activo= "+idAlumno.isActivo();
    }
}
