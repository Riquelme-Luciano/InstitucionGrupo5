package model;

public class Materia {

    private int idMateria;
    private String nombre;
    private int yearMateria;
    private boolean active;

    public Materia() {
    }

    public Materia(String nombre, int yearMateria, boolean active) {
        this.nombre = nombre;
        this.yearMateria = yearMateria;
        this.active = active;
    }

    public Materia(int idMateria, String nombre, int yearMateria, boolean active) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.yearMateria = yearMateria;
        this.active = active;
    }

    //--getsetters
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getYearMateria() {
        return yearMateria;
    }

    public void setYearMateria(int yearMateria) {
        this.yearMateria = yearMateria;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
            
    @Override
    public String toString() {
        return "Materia{" + "idMateria=" + idMateria + ", nombre=" + nombre + ", yearMateria=" + yearMateria + '}';
    }
}
