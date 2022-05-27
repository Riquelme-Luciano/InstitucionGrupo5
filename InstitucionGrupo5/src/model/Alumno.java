
package model;

import java.time.LocalDate;
import java.util.Date;


public class Alumno {
    
    private int idAlumno;
    private String nombre, apellido;
    private Date fechaNac;
    private boolean active;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, Date fechaNac, boolean active) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.active = active;
    }

    public Alumno(int idAlumno, String nombre, String apellido, Date fechaNac, boolean active) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.active = active;
    }
    
    
    //---getsetters

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return idAlumno + " " + nombre + " " + apellido;
    }
    
    
}
