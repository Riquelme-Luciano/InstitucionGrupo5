package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Alumno;
import model.InscripcionData;
import model.Materia;
import view.InscripcionesView;

public class InscripcionController implements ActionListener, ItemListener {

    Conexion con = new Conexion();
    InscripcionData data = new InscripcionData(con);
    InscripcionesView vista = new InscripcionesView();
    DefaultTableModel modelo = new DefaultTableModel();

    Alumno a = new Alumno();
    ArrayList<Materia> materias = new ArrayList();

    public InscripcionController(InscripcionesView v) {
        this.vista = v;
        this.vista.comboBoxAlumnos.addItemListener(this);
        this.vista.rButtonInscriptas.addItemListener(this);
        this.vista.rButtonNoInscriptas.addItemListener(this);
        this.vista.btnInscribir.addActionListener(this);
        this.vista.btnDesinscribir.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        completarComboBox();
    }

    public void completarComboBox() {
        Vector<Alumno> alumnosActivos = new Vector<Alumno>(data.listarAlumnosActivos());
        DefaultComboBoxModel modeloMaterias = new DefaultComboBoxModel(alumnosActivos);
        vista.comboBoxAlumnos.setModel(modeloMaterias);
    }

    public void llenarTabla(JTable tabla, ArrayList materias) {
        modelo.setRowCount(0);//Borras todas las filas
        modelo = (DefaultTableModel) tabla.getModel();

        ArrayList<Materia> lista = new ArrayList();
        lista = (ArrayList<Materia>) materias;

        Object[] object = new Object[3];

        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getIdMateria();
            object[1] = lista.get(i).getNombre();
            object[2] = lista.get(i).getYearMateria();
            modelo.addRow(object);
        }
        vista.tablaMateriasInscripciones.setModel(modelo);
    }

    public int inscribirAlumno() {
        //seleccionar de la tabla
        int fila = vista.tablaMateriasInscripciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            vista.rButtonNoInscriptas.setSelected(true);
            return 0;
        } else {
            Materia m = new Materia();
            int id = Integer.parseInt(vista.tablaMateriasInscripciones.getValueAt(fila, 0).toString());
            String nombre = (String) vista.tablaMateriasInscripciones.getValueAt(fila, 1);
            int anio = Integer.parseInt(vista.tablaMateriasInscripciones.getValueAt(fila, 2).toString());

            m.setIdMateria(id);
            m.setNombre(nombre);
            m.setYearMateria(anio);

            return data.inscribirAlumno(a, m);
        }
    }

    public int desinscribirAlumno() {
        int fila = vista.tablaMateriasInscripciones.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            vista.rButtonInscriptas.setSelected(true);
            return 0;
        } else {
            Materia m = new Materia();
            int id = Integer.parseInt(vista.tablaMateriasInscripciones.getValueAt(fila, 0).toString());
            String nombre = (String) vista.tablaMateriasInscripciones.getValueAt(fila, 1);
            int anio = Integer.parseInt(vista.tablaMateriasInscripciones.getValueAt(fila, 2).toString());
            m.setIdMateria(id);
            m.setNombre(nombre);
            m.setYearMateria(anio);
            
            int idMateria = m.getIdMateria();
            int idAlumno = a.getIdAlumno();

            data.desinscribirAlumno(idMateria, idAlumno);
            return 1;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnInscribir) {
            int r = inscribirAlumno();
            if (r == 1) {
                llenarTabla(vista.tablaMateriasInscripciones, (ArrayList) data.materiasNoInscriptasAlumno(a));
                JOptionPane.showMessageDialog(vista, "Alumno Inscripto");
            }
        }
        
        if(e.getSource() == vista.btnDesinscribir){
            int r = desinscribirAlumno();
            if(r==1){
                llenarTabla(vista.tablaMateriasInscripciones, (ArrayList) data.materiasDeAlumno(a));
                JOptionPane.showMessageDialog(vista, "Alumno Desinscripto");
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            vista.rButtonInvisible.setSelected(true);
            modelo.setRowCount(0);//Borras todas las filas
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.a = (Alumno) vista.comboBoxAlumnos.getSelectedItem();

            if (vista.rButtonInscriptas.isSelected()) {
                System.out.println("Materias inscripto");
                materias = (ArrayList) data.materiasDeAlumno(a);
                llenarTabla(vista.tablaMateriasInscripciones, materias);
            }

            if (vista.rButtonNoInscriptas.isSelected()) {
                System.out.println("Materias no inscripto");
                materias = (ArrayList) data.materiasNoInscriptasAlumno(a);
                llenarTabla(vista.tablaMateriasInscripciones, materias);
            }
        }
    }
}
